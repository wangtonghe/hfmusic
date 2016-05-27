/**
 * Created by wangtonghe on 2016/5/17.
 */
$(function(){

    $(".navbar-static-top").load("nav.html",function(){  //加载导航栏
        $(this).find("#navbar ul:eq(0) li:eq(2)").addClass("active");
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
    initDetails();

    $(".music-contant").on("click","tr .glyphicon", function () {  //播放
        var $audio= $(".play-audio");
        var cur=$(this);
        var musicUrl=cur.siblings("input").val();
        if(cur.hasClass("play")){  //如果选中的歌曲正在播放
            $audio[0].pause();
            $(this).removeClass("glyphicon-play-circle").addClass("glyphicon-pause").css("color","black").removeClass("play");
        }else if( cur.hasClass("glyphicon-pause")){ //如果选中的歌曲处于暂停状态
            cur.removeClass("glyphicon-pause").addClass("glyphicon-play-circle play").css("color","red");
            $audio.attr("src",musicUrl);
            $audio[0].play(); //播放
        }
        else{
            var other_audios=cur.parents("tr").siblings().find(".play");
            if(other_audios.hasClass("play")){ //如果其他歌曲正在播放
                $audio[0].pause();
                $audio[0].load();
                other_audios.css("color","black");
                other_audios.removeClass("play");
            }
            $audio.attr("src",musicUrl);
            $audio[0].play(); //播放
            cur.addClass("play");
            $(this).css("color","red");
        }
    });


    $(".singer-cover").on("click",".singer-collect", function () {  //歌手收藏
        var singerId=getParam("singerId");
       if($(this).hasClass("collected")){  //收藏
           $.post("/hfmusic/site/singer/collect",{singerId:singerId,flag:0}, function (data) {
               if(data.code==0){
                   $(".singer-collect").html("");
                   $(".singer-collect").append("<span class='glyphicon glyphicon-star'></span>收藏");
               }
           });
       }else{
           $.post("/hfmusic/site/singer/collect",{singerId:singerId,flag:1}, function (data) {
               if(data.code==0) {
                   $(".singer-collect").html("");
                   $(".singer-collect").append("<span class='glyphicon glyphicon-star collected '></span>已收藏");
               }
           });
       }

    })




});

function initDetails(){
    var singerId=getParam("singerId");
    var accessToken=sessionStorage.getItem("hfmusic_accessToken");
    $.get("/hfmusic/site/singer/getMusicTop50",{singerId:singerId},function(data){
        if(data.code==0) {
            var details = data.data;
            $(".singer-name").text(details.singerName);
            $(".singer-cover img").attr("src",details.cover);
            $(".singer-collect").html("");
            if (details.isCollect==1){
                $(".singer-collect").append("<span class='glyphicon glyphicon-star collected'></span>已收藏");
            }else {
                $(".singer-collect").append("<span class='glyphicon glyphicon-star'></span>收藏");
            }
            var musics=details.musics;
            for(var i=0;i<musics.length;i++){
                var row="<tr><td><span>"+(i+1)+"</span>&nbsp;&nbsp;<span class='glyphicon glyphicon-play-circle'></span><input type='hidden' value='"+musics[i].musicUrl+"' /></td>" +
                    "<td><a href='musicplayer.html?musicId="+musics[i].musicId+"'>"+musics[i].musicName+"</a></td>" +
                    "<td><span>"+musics[i].album+"</span></td></tr>";
                $(".music-contant").append(row);
            }

        }else{
            alert(data.data.error);
        }
    },"json")
}
