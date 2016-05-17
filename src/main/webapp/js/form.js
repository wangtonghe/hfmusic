/**
 * Created by wangtonghe on 2016/5/15.
 */

$(function(){
    initAllForm(0,1);

    $(".collection").on("click","div img,div home-formname",function(){
        var formId=$(this).siblings(":input").val();
        window.location.href="formdetails.html?formId="+formId;
    });
    initPopover();  //初始化弹出框

    //选择歌单标签
    $(".form-title-list ").on("click",".form-label-text", function () {
       var labelId= $(this).siblings(":input").val();
        var label=$(this).text();
        $(".form-title-name").text(label);
        initAllForm(labelId,1);
        $('#form-all-type').popover("hide");

    });


});

//分类加载歌单
function initAllForm(labelId,pageNum){
    $.ajax({
        "url":"/hfmusic/site/form/getFormByLabelId",
        "data":{labelId:labelId,pageNum:pageNum},
        "dataType":"json",
        "type":"GET",
        "success":function(data){
            var d = data.data;
            if(data.code==0){
                $(".collection").html("");
                for(var i=0;i< d.list.length;i++){
                    var row = "<div class=' col-lg-2 col-md-4 col-sm-4 ' ><img  src='" + d.list[i].cover + "' class='img-rounded hand' width='140' height='140'>" +
                        "<h6 class='home-formname'><a class='hand'>" + d.list[i].name +
                        "</a></h6><span class='glyphicon glyphicon-heart ' aria-hidden='true' >" + d.list[i].hot  +
                        "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class='author'>"+ d.list[i].creator+"</span></div>";
                    $(".collection").append(row);
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

function initPopover (){
    //弹出层
    var form_type_title="<label class='form-label-text'>精选</label><input type='hidden'value='0' />";
    var form_type_comtent=$("<div class='row'></div>");
    $.get("/hfmusic/site/form/getSysLabel",{},function(data){
        if(data.code!=0){
            return;

        }
        var list =data.data;
        for(var i=0;i<list.length;i++){
            var label="<div class='col-sm-3' ><label  class='form-label-text'>"+list[i].labelName+"</label><input type='hidden' value='"+list[i].labelId+"'></div>";
            form_type_comtent.append(label);
        }

    },"json");

    $('#form-all-type'). popover ({
        "html":true,
        "title": form_type_title,
        "content":form_type_comtent,
        "placement": 'bottom',
        "trigger":"click focus"
    });
}


