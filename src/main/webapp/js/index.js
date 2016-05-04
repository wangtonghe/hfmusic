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

    //登录
    $("#login_btn").on("click", function () {
        var username = $("#login_name").val();
        var password = $("#login_pwd").val();
        $.post("/hfmusic/site/user/login", {username: username, password: password}, function (data) {
            if (data.code == 0) {
                sessionStorage.setItem("hf_user_accessToekn",data.data.accessToken);
                $("#signin").modal("hide");

            }
            else {
                alert(data.data);
            }
        })
    });

    //注册
    $("#reg_btn").on("click", function () {
        var username = $("#reg_name").val();
        var password = $("#reg_pwd").val();
        var password2 = $("#reg_pwd2").val();
        if (password != password2) {
            alert("你两次输入密码不一致");
        } else {
            $.post("/hfmusic/site/user/register", {username: username, password: password}, function (data) {
                if (data.code == 0) {
                    sessionStorage.setItem("hf_user_accessToekn",data.data.accessToken);
                    $(".navbar .navbar-right .nav-username").text(username);
                }else{
                    alert(data.data);

                }
            })
        }
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
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class='author'>"+list[i].creator+"</span></div>";
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




