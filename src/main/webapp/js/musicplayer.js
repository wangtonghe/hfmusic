/**
 * Created by wangtonghe on 2016/5/17.
 */
var lyricText="";
$(function(){
    initDetails(6);
    $(".music-play").on("click",function(){  //播放歌曲
        $("#music_audio")[0].play();
        getReady();

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
            lyricText=details.lyric;
            getReady();
        }else {
            alert(data.data.error);
        }
    },"json");

}
