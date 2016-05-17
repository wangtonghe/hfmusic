/**
 * Created by wangtonghe on 2016/1/13.
 * index.js
 */
$(function () {

    initData();
    $(".login").on("click", function () {
        $("#signin").modal({
            backdrop: true,
            keyboard: false
        })
    });
    $(".register").on("click", function () {
        $("#register").modal({
            backdrop: true,
            keyboard: false
        });
    });



    //点击歌单封面，跳到歌单详情页
    $(".hot-collection ").on("click","div img,div .home-formname",function(){
        var formId=$(this).siblings(":input").val();
        window.location.href="formdetails.html?formId="+formId;
    });



});

function initData() {

    //获取热门歌单
    $.get("/hfmusic/site/home/hotForm", function (data) {
        if (data.code == 0) {
            var list = data.data;
            var length = data.data.length;
            for (var i = 0; i < length; i++) {
                var div = "<div class=' col-lg-3 col-md-3 col-sm-4 ' ><img  src='" + list[i].cover + "' class='img-rounded hand' width='140' height='140'>" +
                    "<h6 class='home-formname'><a class='hand'>" + list[i].name +
                    "</a></h6><span class='glyphicon glyphicon-heart ' aria-hidden='true' >" +list[i].hot  +
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class='author'>"+list[i].creator+"</span><input type='hidden' value='"+list[i].formId+"' /></div>";
                    $(".hot-collection").append(div);

            }

        }
    }, "json");

    //获取本月热门歌曲
    $.get("/hfmusic/site/home/monthlyHot", {}, function (data) {
        var list = data.data;
        var length = data.data.length;
        for (var i = 0; i < length; i++) {
            var a_hot = '<a href="#" class="list-group-item">' + list[i].musicName + '<span class="badge">' + list[i].likeNum + '</span></a>';
            $(".container .month-hot .list-group").append(a_hot);
        }
    }, "json");

    //获取本月热门新歌
    $.get("/hfmusic/site/home/monthlyNew", {}, function (data) {
        var list = data.data;
        var length = data.data.length;
        for (var i = 0; i < length; i++) {
            var a_hot = '<a href="#" class="list-group-item">' + list[i].musicName + '<span class="badge">' + list[i].likeNum + '</span></a>';
            $(".container .month-new .list-group").append(a_hot);
        }
    }, "json");

    //获取热门歌手
    $.get("/hfmusic/site/home/hotSinger", {}, function (data) {
        var list = data.data;
        var length = data.data.length;
        for (var i = 0; i < length; i++) {
            var a_hot = '<a href="#" class="list-group-item">' + list[i].singerName + '<span class="badge">' + list[i].hot + '</span></a>';
            $(".container .hot-singer .list-group").append(a_hot);
        }
    }, "json");
}




