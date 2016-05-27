/**
 * Created by wangtonghe on 2016/5/18.
 */
var scrollt=0;
var tflag=0;//存放时间和歌词的数组的下标
var lytext=new Array();//放存汉字的歌词
var lytime=new Array();//存放时间
var delay=10;
var line=0;
var scrollh=0;

function getLy()//取得歌词
{
    return lyricText;
}
function show(t)//显示歌词
{
    var div1=document.getElementById("lyric-content");//取得层
    document.getElementById("lyric-content").innerHTML=" ";//每次调用清空以前的一次
    if(t<lytime[lytime.length-1])//若没有播放完，则继续
    {
        for(var k=0;k<lytext.length;k++)
        {
            if(lytime[k]<=t&&t<lytime[k+1])  //正好播放到这一行
            {
                scrollh=k*25;//让当前的滚动条的顶部改变一行的高度
                div1.innerHTML+="<font color=#00008b style=font-weight:bold>"+lytext[k]+"</font><br>";
            }
            else if(t<lytime[lytime.length-1])//没有播放完
                div1.innerHTML+=lytext[k]+"<br>";
        }
    }
    else//最后一句特别处理
    {
        for(var j=0;j<lytext.length-1;j++)
            div1.innerHTML+=lytext[j]+"<br>";
        div1.innerHTML+="<font color=red style=font-weight:bold>"+lytext[lytext.length-1]+"</font><br>";
    }
}
function scrollBar()//设置滚动条的滚动
{
    if(document.getElementById("lyric-content").scrollTop<=scrollh)
        document.getElementById("lyric-content").scrollTop+=1;
    if(document.getElementById("lyric-content").scrollTop>=scrollh+50)
        document.getElementById("lyric-content").scrollTop-=1;
    window.setTimeout("scrollBar()",delay);
}
function getReady()//在显示歌词前做好准备工作
{
    var ly=getLy();//得到歌词
    //alert(ly);
    var arrly=ly.split("$");//转化成数组
    for(var i=0;i<arrly.length;i++) {
        sToArray(arrly[i]);
    }
    sortAr();
    /*for(var j=0;j<lytext.length;j++)
     {
     document.getElementById("lyr").innerHTML+=lytime[j]+lytext[j]+"<br>";
     }*/
    scrollBar();
}
function sToArray(str)//解析如“[02:02][00:24]没想到是你”的字符串前放入数组
{
    var left=0;//"["的个数
    var leftAr=new Array();
    for(var k=0;k<str.length;k++)
    {
        if(str.charAt(k)=="[")
        {
            leftAr[left]=k;
            left++;
        }
    }
    if(left!=0)
    {
        for(var i=0;i<leftAr.length;i++)
        {
            lytext[tflag]=str.substring(str.lastIndexOf("]")+1);//放歌词
            lytime[tflag]=conSeconds(str.substring(leftAr[i]+1,leftAr[i]+6));//放时间
            tflag++;
        }
    }
    //alert(str.substring(leftAr[0]+1,leftAr[0]+6));
}
function sortAr()//按时间重新排序时间和歌词的数组
{
    var temp=null;
    var temp1=null;
    for(var k=0;k<lytime.length;k++)
    {
        for(var j=0;j<lytime.length-k;j++)
        {
            if(lytime[j]>lytime[j+1])
            {
                temp=lytime[j];
                temp1=lytext[j];
                lytime[j]=lytime[j+1];
                lytext[j]=lytext[j+1];
                lytime[j+1]=temp;
                lytext[j+1]=temp1;
            }
        }
    }
}
function conSeconds(t)//把形如：01：25的时间转化成秒；
{
    var m=t.substring(0,t.indexOf(":"));
    var s=t.substring(t.indexOf(":")+1);
    s=parseInt(s.replace(/\b(0+)/gi,""));
    if(isNaN(s))
        s=0;
    var totalt=parseInt(m)*60+s;
    //alert(parseInt(s.replace(/\b(0+)/gi,"")));
    if(isNaN(totalt))
        return 0;
    return totalt;
}
function getSeconds()//得到当前播放器播放位置的时间
{
    var t=getPosition();  //获取当前音乐播放的时间
    t=t.toString();//数字转换成字符串
    var s=t.substring(0,t.lastIndexOf("."));//得到当前的秒
    //alert(s);
    return s;
}
function getPosition()//返回当前播放的时间位置
{
    var mm=document.getElementById("music_audio");
    return mm.currentTime ;
}
function mPlay()//开始播放
{
    var ms=parseInt(getSeconds());
    if(isNaN(ms))
        show(0);
    else
        show(ms);
    window.setTimeout("mPlay()",100)
}
window.setTimeout("mPlay()",100);