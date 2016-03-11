/**
 * Created by wangtonghe on 2016/1/13.
 * index.js
 */
$(function() {
    $(".login").on("click",function(){
        $("#signin").modal({
            backdrop: true,
            keyboard: false
        })
    });
    $(".register").on("click",function(){
        $("#register").modal({
            backdrop: true,
            keyboard: false
        });
    });

    $("#login_btn").on("click",function(){
        var username = $("#login_name").val();
        var password = $("#login_pwd").val();
        alert("账号不存在，请重试！")
        /*  $.post("/hfmusic/site/user/login",{username:username,password:password},function(data){
         if(data.code==0){
         $("#signin").modal("hide");
         }
         else{
         alert(data.data);
         }
         })*/
    });

    $("#reg_btn").on("click",function(){
        var username = $("#reg_name").val();
        var password = $("#reg_pwd").val();
        var password2 = $("#reg_pwd2").val();
        alert("你两次输入密码不一致");
        if(password==password2){
            $.post("/hfmusic//user/site/register",{username:username,password:password},function(data){
                if(data.code==0){
                    $("#signin").modal("hide");
                    alert("恭喜您已成功注册！")
                }
                else{
                    alert(data.data);
                }
            })
        }
    });

})




