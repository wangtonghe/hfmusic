/**
 * Created by wangtonghe on 2016/5/15.
 */

$(function(){

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
    initAtoZ();


    //点击字符选择歌手
    $(".singer-title").on("click",function(){
       if(!$(this).hasClass("singer-title-selected")){
           $(this).addClass("singer-title-selected");
           $(this).siblings(".singer-title").removeClass("singer-title-selected");
       }
        var character = $(this).text();
        initSinger(character,1);
    });

    $(".singer").on("click","div img,div home-formname",function(){
        var singerId=$(this).siblings(":input").val();
        window.location.href="singerdetails.html?singerId="+singerId;
    });





});

//初始化歌手
function initSinger(character,pageNum){

    $.ajax({
            "url":"/hfmusic/site/singer/getSingerByChar",
            "data":{character:character,pageNum:pageNum},
            "dataType":"json",
            "type":"GET",
            "success":function(data){
                var d = data.data;

                if(data.code==0){
                    $(".singer").html("");
                    for(var i=0;i< d.list.length;i++){
                        var row = "<div class=' col-lg-2 col-md-4 col-sm-4 singer-div ' ><input type='hidden' value='"+ d.list[i].singerId+"' /><img  src='" + d.list[i].portrait + "' class='img-rounded hand' width='140' height='140'>" +
                            "<h6 class='home-formname'><a class='hand'>" + d.list[i].singerName +
                            "</a></h6></div>";
                        $(".singer").append(row);
                    }
                    var total = d.totlePageNum;
                    if (total> 1) {
                        $('#mm-pager .pagination .pager').twbsPagination({
                            totalPages: total,
                            visiblePages: total > 4 ? 4 : 2,
                            first:'首页',
                            prev:'上一页',
                            next:'下一页',
                            last:'尾页',
                            onPageClick: function (event, page) {
                                initMusic(page,pageSize);
                            }
                        });
                    }
                }
            }
        }
    )
}

function initAtoZ(){
    for(var i=25;i>=0;i--){
        var char = "<label class='singer-title'>"+String.fromCharCode(65+i)+"</label>";
        $(".singer-title-all").after(char);
    }
    $(".singer-title-all").addClass("singer-title-selected");
    initSinger("热门",1);
}
