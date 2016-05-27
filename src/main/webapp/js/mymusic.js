/**
 * Created by wangtonghe on 2016/5/15.
 */
$(function(){

    $(".navbar-static-top").load("nav.html",function(){  //加载导航栏
        $(this).find("#navbar ul:eq(0) li:eq(3)").addClass("active");
        var nav_user= $(this).find(".navbar-username");
        var nav_login=$(this).find(".navbar-login");
        if(sessionStorage.getItem("hfmusic_username")!=undefined){
            nav_login.css("display","none");
            nav_user.find("img").attr("src",sessionStorage.getItem("hfmusic_username_img"));
            nav_user.find(".login-nav-name").text(sessionStorage.getItem("hfmusic_username"));
        }else{
            nav_user.css("display","none");
        }

    });

    getMyForm();  //加载我的歌单
    getCollectForm();  //加载我收藏的歌单
    getCollectSinger();//加载收藏的歌手

    $(".myul").on("click",".my-form-li",function(){  //点击左侧菜单
      var formId=  $(this).attr("id");
        initFormDetails(formId); //加载歌单
    });

    $(".form-contant").on("click","tr .play-music-icon",function(){   //播放

        var audio =  $(this).siblings(".audio-play");
        if(audio.hasClass("play")){  //如果选中的歌曲正在播放
            audio[0].pause();
            $(this).removeClass("glyphicon-play-circle").addClass("glyphicon-pause").css("color","black");
            audio.removeClass("play");
        }else if( $(this).hasClass("glyphicon-pause")){ //如果选中的歌曲处于暂停状态
            $(this).removeClass("glyphicon-pause").addClass("glyphicon-play-circle").css("color","red");
            audio[0].play(); //播放
            audio.addClass("play");
        }
        else{
            var other_audios=$(this).parents("tr").siblings().find(".play");
            if(other_audios.hasClass("play")){ //如果其他歌曲正在播放
                other_audios[0].pause();
                other_audios.siblings(".glyphicon-play-circle").css("color","black");
                other_audios.removeClass("play");
            }
            audio[0].play(); //播放
            audio.addClass("play");
            $(this).css("color","red");
        }
    });

    $(".form-contant").on("click","tr .glyphicon-heart",function(){ //喜欢或取消喜欢
        var userId=sessionStorage.getItem("hfmusic_userId");
        var formId=  $(".form-id").val();
        if(userId==undefined||userId<1){
            alert("您还没有登录，请先登录！");
            return;
        }
        var musicId=$(this).siblings(".form-musicId-value").val();

        var like = $(this).hasClass("music_liked")?0:1;
        var span =$(this);
        $.post("/hfmusic/site/music/likeMusic",{formId:formId,musicId:musicId,userId:userId,flag:like},function(data){
            if(data.code==0){
                if(like==1){
                    span.addClass("music_liked");
                }else{
                    span.removeClass("music_liked");
                }
            }
        });
    });









});

//显示我的歌单
function getMyForm(){
    var accessToken = localStorage.getItem("hfmusic_accessToken");
    $.get("/hfmusic/site/mine/getMyForm",{accessToken:accessToken},function(data){
        if(data.code==0){
            var list = data.data;
            $(".my-form-nav .my-form .form-num").text("("+list.length+")");
            for(var i=0;i<list.length;i++){
                var myform = "<li class='my-form-li' data-toggle='tab' id='"+list[i].formId+"' href='#form-pane'><div><div class='left'><a class='avatar'><img src='"+list[i].cover+"' width='40px' height='40px' /></a></div>" +
                    "<p class='f-name'>"+list[i].formName+"</p><p class='f-num'>"+list[i].musicNum+"首</p> </div></li>";
                $(".my-form-nav .my-form .myForm").append(myform);
            }
        }else{
            alert(data.data.error);
        }
    },"json");
}

//显示我收藏的歌单
function getCollectForm(){
    var accessToken = localStorage.getItem("hfmusic_accessToken");
    $.get("/hfmusic/site/mine/getCollectForm",{accessToken:accessToken},function(data){
        if(data.code==0){
            var list = data.data;
            $(".my-form-nav .my-collect .form-num").text("("+list.length+")");
            for(var i=0;i<list.length;i++){
                var mycollect = "<li class='my-form-li'  data-toggle='tab' id='"+list[i].formId+"' href='#form-pane'><div><div class='left'><a class='avatar'><img src='"+list[i].cover+"' width='40px' height='40px' /></a></div>" +
                    "<p class='f-name'>"+list[i].formName+"</p><p class='f-num'>"+list[i].musicNum+"首</p> </div></li>";
                $(".my-form-nav .my-collect .myCollect").append(mycollect);
            }
        }else{
            alert(data.data.error);
        }
    },"json");
}

//获取收藏的歌手
function getCollectSinger(){
    var accessToken = localStorage.getItem("hfmusic_accessToken");
    $.get("/hfmusic/site/mine/getCollectSinger",{accessToken:accessToken},function(data){
        if(data.code==0){
            var list = data.data;
            $(".my-form-nav .my-singer .singer-num").text("("+list.length+")");
            for(var i=0;i<list.length;i++){
                var mysinger="<div class='row'><div class='col-sm-2 '><img src='"+list[i].portrait+"' width='100px' height='100px' /></div><div class='col-sm-10'>" +
                    "<a href='singerdetails.html?singerId="+list[i].singerId+"' class='my-singer-name'>"+list[i].singerName+"</a><p class='my-singer-musicNum'>"+list[i].musicNum+"首歌</p></div></div><div class='row'><hr class='hr'/></div> ";
                $(".my-singer-list").append(mysinger);

            }
        }else{
            alert(data.data.error);
        }
    },"json");

}

//加载歌单详情
function  initFormDetails(formid){
    var userId=sessionStorage.getItem("hfmusic_userId");
    if(userId==undefined||userId==null){
        userId=0;
    }
    $.ajax({
        "url":"/hfmusic/site/form/details",
        "dataType":"json",
        "type":"GET",
        "data":{formId:formid,userId:userId},
        "success":function(data){
            if(data.code==0){
                var details=data.data;
                $(".form-cover").attr("src",details.cover);
                $(".form-title").text(details.formName);
                $(".form-author-img").attr("src",details.headPortrait);
                $(".form-author").text(details.creator);
                $(".form-date").text(unix_to_datetime(details.createTime)+"   创建");
                $(".form-info").text(details.info);
                $(".form-id").val(details.formId);
                var isCollect="收藏";
                if(details.isCollect==1){
                    isCollect="已收藏";
                    $(".play-collect").html("").append("<span class='glyphicon glyphicon-bookmark form-collected '></span>&nbsp;"+isCollect+"("+details.collectNum+")次");
                }else{
                    $(".play-collect").html("").append("<span class='glyphicon glyphicon-bookmark '></span>&nbsp;"+isCollect+"("+details.collectNum+")次");
                }

                var f_label="";
                for(var i=0;i<details.labels.length;i++){

                    f_label+="<a href='form.html?labelId="+details.labels[i].labelId+"'><span class='f-tag'><i>"+details.labels[i].labelName+"</i></span></a>";
                }
                $(".form-label").html("").append(f_label);

                var musics=details.musicList;
                $(".form-details-totalNum").text(musics.length);
                $(".form-contant").html("");
                for(var i=0;i<musics.length;i++){
                    var islikespan="";
                    if(musics[i].isLike==1){
                        islikespan="<span class='glyphicon glyphicon-heart music_liked '>";
                    }else{
                        islikespan="<span class='glyphicon glyphicon-heart '>";
                    }
                    var row="<tr><td><audio class='audio-play'  src='"+musics[i].musicUrl+"' /><span>"+(i+1)+"</span>&nbsp;&nbsp;"+islikespan+"</span>&nbsp;&nbsp;<span class=' glyphicon glyphicon-play-circle play-music-icon'></span>" +
                        "<input class='form-musicId-value' type='hidden' value='"+musics[i].musicId+"'/><input class='form-singerId-value' type='hidden'value='"+musics[i].singerId+"' /></td>" +
                        "<td class='form-list-music'><a href='musicplayer.html?musicId="+musics[i].musicId+"'>"+musics[i].musicName+"</a></td><td><a href='singerdetails.html?singerId="+musics[i].singerId+"'>"+musics[i].singerName+
                        "</a></td><td>"+musics[i].album+"</td>" +
                        "</tr>";
                    $(".form-contant").append(row);
                }
            }
        }
    });
}