/**
 * Created by wangtonghe on 2016/5/15.
 */
$(function(){
    getMyForm();  //加载我的歌单
    getCollectForm();  //加载我收藏的歌单
    getCollectSinger();//加载收藏的歌手

    $(".myul").on("click",".my-form-li",function(){
      var formId=  $(this).attr("id");
        initFormDetails(formId); //加载歌单
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
                    "<p class='my-singer-name'>"+list[i].singerName+"</p><p class='my-singer-musicNum'>"+list[i].musicNum+"首歌</p></div></div><div class='row'><hr class='hr'/></div> ";
                $(".my-singer-list").append(mysinger);

            }
        }else{
            alert(data.data.error);
        }
    },"json");

}

//加载歌单详情
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
                $(".form-contant").html("");
                for(var i=0;i<musics.length;i++){
                    var row="<tr><td><video class='music-play'  src='"+musics[i].musicUrl+"'width='10' height='20' /><span>"+(i+1)+"</span>&nbsp;&nbsp;<span class=' glyphicon glyphicon-play-circle'></span></td><td>"+musics[i].musicName+"</td><td>"+musics[i].singerName+
                        "</td><td>"+musics[i].album+"</td><td><span class='glyphicon glyphicon-arrow-down'></span>&nbsp;&nbsp;<span class='glyphicon glyphicon-plus'></span>&nbsp;&nbsp;<span class='glyphicon glyphicon-heart'></span>" +
                        "</td></tr>";
                    $(".form-contant").append(row);
                }
            }
        }
    });
}