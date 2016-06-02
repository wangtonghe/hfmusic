/**
 * Created by wangtonghe on 2016/5/15.
 */
var rootUrl = "http://wthfeng.top:8080/hfuploadserver/server/upload/file";
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

    $(".login-register").on("click",".login-nav-img,.login-nav-name", function () {
        location.href=mymusic.html;
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
                var userinfo = data.data;
                localStorage.setItem("hfmusic_accessToken",userinfo.accessToken);
                //alert($(".login-register .rememberMe").attr("checked"));
                if($(".login-register .rememberMe").attr("checked")){
                    localStorage.setItem("hfmusic_rememberMe",$(".login-register #login_name").val());
                }
                $("#signin").modal("hide");
                 var nav = $(".navbar-static-top");
                nav.find(".navbar-login").css("display","none");
                nav.find(".navbar-username").css("display","block");
                nav.find(".navbar-username img").attr("src",userinfo.headPortrait);
                nav.find(".navbar-username .login-nav-name").text(userinfo.nickName);
                sessionStorage.setItem("hfmusic_username",userinfo.nickName);
                sessionStorage.setItem("hfmusic_username_img",userinfo.headPortrait);
                sessionStorage.setItem("hfmusic_userId",userinfo.userId);
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


   $(".navbar-static-top ").on("click", ".navbar-search .glyphicon-search",function () {
       var key =$(".navbar-search input").val();
       location.href="search.html?key="+key;

   });
    $(".navbar-static-top").on("keypress",".navbar-search input",function(e) {
        // 回车键事件
        if(e.which == 13) {
            var key =$(".navbar-search input").val();
            location.href="search.html?key="+key;
        }
    });

});

//时间转化
function unix_to_datetime(unix) {
    var date2 = new Date(parseInt(unix)).toLocaleString().substring(0,9).replace("/g","-");
    //return now
    return date2;
}

function array2str(array){
    var str;
    for(var i=0;i<array.length;i++){
        str+=array[i];
    }
}

