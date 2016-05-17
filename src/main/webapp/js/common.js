/**
 * Created by wangtonghe on 2016/5/15.
 */
$(function(){

    $("nav").load("nav.html");

    $(".login-register").load("login_register.html");


    $(".navbar").on("click",".login", function () {
        $("#signin").modal({
            backdrop: true,
            keyboard: false
        })
    });
    $(".navbar").on("click",".register", function () {
        $("#register").modal({
            backdrop: true,
            keyboard: false
        });
    });

    //登录
    $(".login-register").on("click","#login_btn", function () {
        var username = $("#login_name").val();
        var password = $("#login_pwd").val();
        $.post("/hfmusic/site/user/login", {username: username, password: password}, function (data) {
            if (data.code == 0) {
                localStorage.setItem("hfmusic_accessToken",data.data.accessToken);
                $("#signin").modal("hide");

            }
            else {
                alert(data.data);
            }
        })
    });

    //注册
    $(".login-register").on("click","#reg_btn", function () {
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

