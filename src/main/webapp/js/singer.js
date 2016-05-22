/**
 * Created by wangtonghe on 2016/5/15.
 */

$(function(){
    var area = 1;
    var sex=0;
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
                        var row = "<div class=' col-lg-2 col-md-4 col-sm-4 singer-div ' ><img  src='" + d.list[i].portrait + "' class='img-rounded hand' width='140' height='140'>" +
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
