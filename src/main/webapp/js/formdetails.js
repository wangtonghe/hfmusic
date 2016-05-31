/**
 * Created by wangtonghe on 2016/5/14.
 */
$(function(){
    var formid=getParam("formId");//从URL中获取歌单id

    $(".navbar-static-top").load("nav.html",function(){  //加载导航栏
        $(this).find("#navbar ul:eq(0) li:eq(1)").addClass("active");  //.siblings(".home-nav").removeClass("active");
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


    initFormDetails(formid);   //初始化歌单详情
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
        if(userId==undefined||userId<1){
            alert("您还没有登录，请先登录！");
            return;
        }
        var musicId=$(this).siblings(".form-musicId-value").val();

        var like = $(this).hasClass("music_liked")?0:1;
        var span =$(this);
        $.post("/hfmusic/site/music/likeMusic",{formId:formid,musicId:musicId,userId:userId,flag:like},function(data){
           if(data.code==0){
               if(like==1){
                   span.addClass("music_liked");
               }else{
                   span.removeClass("music_liked");
               }
           }
        });
    });

    $(".margin-top-fill").on("click",".play-all", function () {  //播放全部
        alert("未实现");


    });

    $(".margin-top-fill").on("click",".row-play .play-collect",function(){  //收藏歌单
        var userId=sessionStorage.getItem("hfmusic_userId");
        if(userId==undefined||userId<1){
            alert("请先登录");
            return;
        }
       if( $(this).children("span").hasClass("form-collected")){ //若已收藏

           $.post("/hfmusic/site/form/collect",{userId:userId,flag:0,formId:formid},function(data){
               var collectNum=  $(".play-collect").text().match(/\d+/ig);

               $(".play-collect").html("").append("<span class='glyphicon glyphicon-bookmark '></span>&nbsp;收藏("+(collectNum-1)+")次");
           });
       }else{  //若未收藏
           $.post("/hfmusic/site/form/collect",{userId:userId,flag:1,formId:formid},function(data){
               var collectNum=  $(".play-collect").text().match(/\d+/ig);
               $(".play-collect").html("").append("<span class='glyphicon glyphicon-bookmark form-collected '></span>&nbsp;已收藏("+(parseInt(collectNum)+1)+")次");
           });

       }
    });



});

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
