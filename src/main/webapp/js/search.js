/**
 * Created by wangtonghe on 2016/5/27.
 */
$(function () {




    $(".navbar-static-top").load("nav.html",function(){  //加载导航栏
        $(this).find("#navbar ul:eq(0) li:eq(2)").addClass("active");
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

    var key = getParam("key");
    if(key!=''){
        $(".search-input").val(key);
        $(".search-input").trigger("click");
    }

    $(".search-input").keypress(function(e) {
        // 回车键事件
        if(e.which == 13) {
            $(".margin-top .search-m").trigger("click");
        }
    });

    $(".glyphicon-search").on("click",function(){
        $(".margin-top .search-m").trigger("click");
    });

    $(".search-singer").on("click","img",function(){  //点击歌手封面
        var url=$(this).attr("href");
        window.location.href=url;

    });

    $(".margin-top .search-m").on("click",function(){  //搜索歌曲
        if(key!=''){
            $(".search-input").val(key);
        }
         key =$(".search-input").val();
        if(key==undefined||key==''){
            return;
        }
        $.get("/hfmusic/site/search/all",{key:key,flag:1}, function (data) {
            if(data.code==0){
                var list=data.data;
                $(".search-music .table").html("");
                for(var i=0;i<list.length;i++){
                    var row = "<tr><td><a href='musicplayer.html?musicId="+list[i].musicId+"'>"+list[i].musicName+"</a></td><td><a href='singerdetails.html?singerId="+list[i].singerId+"'>"+list[i].singerName+"</a></td>" +
                        "<td>"+list[i].album+"</td></tr>"
                    $(".search-music .table").append(row);
                }
            }
        },"json")
    });
    $(".margin-top .search-f").on("click",function(){  //搜索歌单
        var key =$(".search-input").val();
        if(key==undefined||key==''){
            return;
        }
        $.get("/hfmusic/site/search/all",{key:key,flag:2}, function (data) {
            if(data.code==0){
                var list=data.data;
                $(".search-form").html("");
                for(var i=0;i<list.length;i++){
                    var div = "<div class=' col-lg-3 col-md-3 col-sm-4 ' ><img  src='" + list[i].cover + "' class='img-rounded hand' width='140px' height='140px'>" +
                        "<h6 class='home-formname'><a >" + list[i].name +
                        "</a></h6>&nbsp;&nbsp;&nbsp;&nbsp;<span class='author'>"+list[i].creator+"</span><input type='hidden' value='"+list[i].formId+"' /></div>";
                    $(".search-form").append(div);
                }
            }
        },"json")
    });

    $(".margin-top .search-s").on("click",function(){  //搜索歌手
        var key =$(".search-input").val();
        if(key==undefined||key==''){
            return;
        }
        $.get("/hfmusic/site/search/all",{key:key,flag:3}, function (data) {
            if(data.code==0){
                var list=data.data;
                $(".search-singer").html("");
                for(var i=0;i<list.length;i++){
                    var div = "<div class=' col-lg-3 col-md-3 col-sm-4 ' ><img href='singerdetails.html?singerId="+list[i].singerId+"'  src='" + list[i].portrait + "' class='img-rounded hand' width='140px' height='140px'>" +
                        "<p><a href='singerdetails.html?singerId="+list[i].singerId+"' >" + list[i].singerName + "</a></p><input type='hidden' value='"+list[i].singerId+"' /></div>";
                    $(".search-singer").append(div);
                }
            }
        },"json")
    });






});
