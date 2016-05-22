/**
 * Created by wangtonghe on 2016/5/15.
 */
$(function(){

    $(".login-register").load("login_register.html");


    $(".navbar").on("click",".login", function () {  //点击弹出登录按钮
        $("#signin").modal({
            backdrop: true,
            keyboard: false
        });
       var remember = localStorage.getItem("hfmusic_rememberMe");
        if(remember!=undefined||remember!=''){
            $(".login-register #login_name").val(remember);

        }

    });
    $(".navbar").on("click",".register", function () {  //点击弹出注册按钮
        $("#register").modal({
            backdrop: true,
            keyboard: false
        });
    });

    //登录
    $(".login-register").on("click","#login_btn", function () {
        var username = $("#login_name").val();
        var password = $("#login_pwd").val();
        if(username==''){
            alert("用户名不能为空");
            return;
        }
        if(password==''){
            alert("密码不能为空");
            return;

        }
        $.post("/hfmusic/site/user/login", {username: username, password: password}, function (data) {
            if (data.code == 0) {
                localStorage.setItem("hfmusic_accessToken",data.data.accessToken);
                alert($(".login-register .rememberMe").attr("checked"));
                if($(".login-register .rememberMe").attr("checked")){
                    localStorage.setItem("hfmusic_rememberMe",$(".login-register #login_name").val());
                }
                $("#signin").modal("hide");


            }
            else {
                alert(data.data);
            }
        })
    });
    $(".login-register").on("click",".forget-pwd",function(){
        alert("保留功能，未完成");

    });
    $(".login-register").on("click",".register-instant",function(){
        $("#signin").modal("hide");
        $("#register").modal("show");


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

