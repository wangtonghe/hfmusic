/**
 * Created by wangtonghe on 2016/5/14.
 */
$(function(){
    var formid=getParam("formId");
    initFormDetails(formid);   //初始化表单详情

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



});

function  initFormDetails(formid){
    $.ajax({
        "url":"/hfmusic/site/form/details",
        "dataType":"json",
        "type":"GET",
        "data":{formId:formid},
        "success":function(data){
            if(data.code==0){
                var details=data.data;
                $(".form-cover").attr("src",details.cover);
                $(".form-title").text(details.formName);
                $(".form-author-img").attr("src",details.portrait);
                $(".form-author").text(details.creator);
                $(".form-info").text(details.info);
                $(".form-label").text(details.labels);
                $(".form-details-totalNum").text(details.musicNum);
                var musics=details.musicList;
                for(var i=0;i<musics.length;i++){
                    var row="<tr><td><audio class='audio-play'  src='"+musics[i].musicUrl+"' /><span>"+(i+1)+"</span>&nbsp;&nbsp;<span class=' glyphicon glyphicon-play-circle play-music-icon'></span></td><td>"+musics[i].musicName+"</td><td>"+musics[i].singerName+
                        "</td><td>"+musics[i].album+"</td><td><span class='glyphicon glyphicon-arrow-down'></span>&nbsp;&nbsp;<span class='glyphicon glyphicon-plus'></span>&nbsp;&nbsp;<span class='glyphicon glyphicon-heart'></span>" +
                        "</td></tr>";
                    $(".form-contant").append(row);
                }
            }
        }
    });
}
