/**
 * Created by wangtonghe on 2016/5/17.
 */
var lyricText="";
var interval;
$(function(){
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

    var musicId=getParam("musicId");
    initDetails(musicId);
    var t1 = window.setInterval(getTotalTime,1000);

    $(".margin-top-fill").on("click",".music-play",function(){  //播放歌曲
        var $audio= $("#music_audio");
        if( !$audio.hasClass("played")){
            $audio.addClass("played");
        }
        $(".play-progress .progress-bar").css("width","0%");
        var allTime=$audio[0].duration;
         $audio[0].load();
         $audio[0].play();//开始播放
        $(".navbar-fixed-bottom .glyphicon-play").removeClass("glyphicon-play").addClass("glyphicon-pause");
        if(interval==undefined) {
            interval = setInterval(function () {
                var currentTime = $audio[0].currentTime;
                $(".music-cur-time").text(timeChange(currentTime) + " /  ");
                var progress = (currentTime / allTime) * 100 + "%";
                $(".play-progress .progress-bar").css("width", progress);
            }, 1000);
        }


    });

    $(".navbar-fixed-bottom").on("click",".music-play", function (){ //底端栏播放
         var $audio= $("#music_audio");
         var cur=$(this);
          if($audio.hasClass("played")){ //正在播放
              $audio[0].pause();
              $audio.removeClass("played");
              cur.removeClass("glyphicon-pause").addClass("glyphicon-play");
          }else{
              $audio[0].play();
              $audio.addClass("played");
              cur.removeClass("glyphicon-play").addClass("glyphicon-pause");
              var allTime=$audio[0].duration;
              if(interval==undefined){
                  interval=setInterval(function(){
                      var currentTime = $audio[0].currentTime;
                      $(".music-cur-time").text(timeChange(currentTime)+" /  ");
                      var progress =(currentTime/allTime)*100+"%";
                      $(".play-progress .progress-bar").css("width",progress);
                  },1000);
              }
          }
    });

    $(".lyric-row").on("click",".lyric-more", function () {   //展开、收起歌词
        var lyric_row=lyricText.split("$");
        var length =lyric_row.length;
        if($(this).find("span").hasClass("glyphicon-chevron-up")){  //处于展开状态
           $("#lyric-content p").remove(".lyric-line-more");
            $(this).html("展开<span class='glyphicon glyphicon-chevron-down'></span>");
        }else{
            for(var i=15;i<length;i++){
                var regObj = new RegExp("/d+","g");
                var content =lyric_row[i].replace(regObj,"");
                var row ="<p class='lyric-line-more'>"+content+"</p>";
                $(this).before(row);
            }
            $(this).html("收起<span class='glyphicon glyphicon-chevron-up'></span>");
        }
    });

    $(".music-play-row .music-add").on("click", function () {  //添加歌曲到歌单 弹出

        var userId=sessionStorage.getItem("hfmusic_userId");
        if(userId==undefined||userId==''){
            return;
        }
        $.get("/hfmusic/site/form/listMyForm",{userId:userId},function(data){
            if(data.code==0){
                var list=data.data;
                $("#select_form .container").html("");
                for(var i=0;i<list.length;i++){
                    var row="<div class='row modal-margin'><img class='img-rounded'src='"+list[i].cover+"' width='40px' height='40px'" + " />" +
                        "<a>"+list[i].formName+"</a><input type='hidden' value='"+list[i].formId+"'></div>";
                    $("#select_form .container").append(row);
                }
                $("#select_form").modal();
            }

        });
    });

    $("#select_form .container").on("click","img,a",function(){
        var formId= $(this).siblings("input").val();
        var musicId=getParam("musicId");
        $.post("/hfmusic/site/form/add2Form",{formId:formId,musicId:musicId},function(data){
            if(data.code==0){
                $("#select_form").modal("hide");
                alert("添加成功！");
            }
        });
    });


});



//加载歌曲详情
function initDetails(musicId){
    $.get("/hfmusic/site/music/details",{musicId:musicId},function(data){
        if(data.code==0){
            var details= data.data;
            $(".music-name").text(details.musicName);
            $(".music-singername").text(details.singerName);
            $(".music-cover").attr("src",details.cover);
            $(".music-album").text(details.album);
            $("#music_audio").attr("src",details.musicUrl);
            showLyric(details.lyric);  //展示歌词
            lyricText=details.lyric;
            //getReady();
        }else {
            alert(data.data.error);
        }
    },"json");

}

function getTotalTime(){
    var audio= $("#music_audio")[0];
    $(".music-total-time").text(timeChange(audio.duration));
}

//播放时间
function timeChange(time) {//默认获取的时间是时间戳改成我们常见的时间格式

    //分钟
    var minute = time / 60;
    var minutes = parseInt(minute);
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    //秒
    var second = time % 60;
    seconds = parseInt(second);
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    var allTime = "" + minutes + "" + ":" + "" + seconds + "";
    return allTime;

}
function Interval(){   //激发进度条

        var $audio= $("#music_audio");
         var allTime=$audio[0].duration;
        var currentTime = $audio[0].currentTime;
        $(".music-cur-time").text(timeChange(currentTime)+" /  ");
        var progress =(currentTime/allTime)*100+"%";
        $(".play-progress .progress-bar").css("width",progress);

}
function showLyric(lyric){  //展示歌词

    var lyric_row=lyric.split("$");
    for(var i=0;i<15;i++){
        var regObj = new RegExp("/d+","g");
        var content =lyric_row[i].replace(regObj,"");
        var row ="<p class='lyric-line'>"+content+"</p>";
        $("#lyric-content").append(row);
    }
    if(lyric.length>15){
        var lyricmore =" <a class='lyric-more'>展开<span class='glyphicon glyphicon-chevron-down'></span></a>";
        $("#lyric-content").append(lyricmore);
    }



}

