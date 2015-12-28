
//var preUrl = 'http://testcli.nggirl.com.cn/';

//获取最终的请求参数
function getFinalRequestObject(appParams) {
    //系统参数
    var finalParams = new Object();
    finalParams.app_id = '123456';
    finalParams.nonce = Math.ceil(Math.random() * 1000000);
    finalParams.timestamp = Date.parse(new Date());

    //放入应用参数
    if (appParams != null && appParams != undefined) {
        for (var prop in appParams) {
            //只保留不为空的参数
            if (appParams[prop] != null && appParams[prop] != undefined
                && $.trim(appParams[prop]).length != 0) {
                finalParams[prop] = appParams[prop];
            }
        }
    }
    //生成sign
    finalParams.sign = getSign(finalParams);
    return finalParams;
}

//根据请求数据中的系统参数和应用参数，生成sign
function getSign(requestObject) {
    var appsecret = '123456';
    var signArray = new Array();
    for (var prop in requestObject) {
        signArray.push(prop + '');
        //signArray.push(prop + '=' + requestObject[prop]);
    }
    var originstr = getSignKeyValueStr(requestObject, signArray, appsecret);
    return md5(originstr);
}

//生成key=value类型字符串
function getSignKeyValueStr(requestObject, signArray, appsecret) {
    var resultArray = quickSort(signArray);
    var str = '';
    for (var i = 0; i < resultArray.length; i++) {
        str += (resultArray[i] + '=' + requestObject[resultArray[i]]);
        str += '&';
    }
    return str + appsecret;
}

//对请求参数进行快速排序
function quickSort(arr) {
    if (arr.length <= 1) {
        return arr;
    }
    var pivotIndex = Math.floor(arr.length / 2);
    var pivot = arr.splice(pivotIndex, 1)[0];
    var left = [];
    var right = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < pivot) {
            left.push(arr[i]);
        } else {
            right.push(arr[i]);
        }
    }
    return quickSort(left).concat([pivot], quickSort(right));
}


// 从地址栏中获取参数
function getParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return '';
}

// 判断字符串是否为空
function strIsEmpty(str) {
    if (str == undefined || str == null || $.trim(str).length == 0) {
        return true;
    }
    return false;
}

// 从地址栏和本地存储中获取accessToken，地址栏参数优先
function getAccessToken() {
    var accessToken = '';
    var appAccessToken = localStorage.accessToken;
    var queryAccessToken = getParam("accessToken");
    if (!strIsEmpty(appAccessToken) || !strIsEmpty(queryAccessToken)) {
        accessToken = !strIsEmpty(queryAccessToken) ? queryAccessToken : appAccessToken;
    }

    // localStorage中始终存储最新的accessToken
    setAccessToken(accessToken);
    return accessToken;
}

//设置accessToken
function setAccessToken(accessToken){
    localStorage.accessToken = accessToken;
}


// 验证手机号是否正确
function isPhoneNum(phoneNum) {
    var reg = /^1(([3|8|7|5][0-9])|(5[^4|\D]))\d{8}$/;
    return reg.test(phoneNum);
}

//当前页面是否在微信内
function isInWeixin() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
}

//微信浏览器版本是否小于5.0
function isWeixinLessThan5() {
    var wechatInfo = navigator.userAgent.match(/MicroMessenger\/([\d\.]+)/i);
    return wechatInfo[1] < "5.0";
}

//回退到上一个页面
function goBack() {
    if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)) { // IE
        if (history.length > 0) {
            window.history.go(-1);
        }
    } else { //非IE浏览器
        if (navigator.userAgent.indexOf('Firefox') >= 0 ||
            navigator.userAgent.indexOf('Opera') >= 0 ||
            navigator.userAgent.indexOf('Safari') >= 0 ||
            navigator.userAgent.indexOf('Chrome') >= 0 ||
            navigator.userAgent.indexOf('WebKit') >= 0) {

            if (window.history.length > 1) {
                window.history.go(-1);
            }
            ;
        } else { //未知的浏览器
            window.history.go(-1);
        }
    }
}

//判断accessToken是否有效
function checkAccessToken(successfun,errorfun){
    if(strIsEmpty(getAccessToken())){
        location.href = 'login.html';
    };

    var data = getFinalRequestObject({
        accessToken : getAccessToken()
    });

    $.ajax({
        type : 'GET',
        url : preUrl+'/nggirl/app/cli/checkAccessToken',
        data : data,
        dataType:'json',
        success : function(result) {
            //授权令牌无效
            if (result.code !=  0) {
                if(typeof(errorfun) == 'function'){
                    errorfun();
                }
                else{
                    location.href = 'login.html';
                }
            }
            //授权令牌有效
            else {
                if(typeof(successfun) == 'function'){
                    successfun();
                }else{
                    //goBack();
                }
            }
        }
    });
}


function checkAccessTokenLogin(successfun,redirectUrlAfterLogin){

    if(strIsEmpty(getAccessToken())){
        if(!strIsEmpty(redirectUrlAfterLogin)){
            setRedirectUrlAfterLogin(redirectUrlAfterLogin);
        }else{
            setRedirectUrlAfterLogin('');
        }
        location.href = 'login.html';
    };

    var data = getFinalRequestObject({
        accessToken : getAccessToken()
    });

    $.ajax({
        type : 'GET',
        url : preUrl+'/nggirl/app/cli/checkAccessToken',
        data : data,
        dataType:'json',
        success : function(result) {
            //授权令牌无效,就登陆
            if (result.code != 0) {
                if(!strIsEmpty(redirectUrlAfterLogin)){
                    setRedirectUrlAfterLogin(redirectUrlAfterLogin);
                }else{
                    setRedirectUrlAfterLogin('');
                }
                location.href = 'login.html';
            }
            //授权令牌有效
            else {
                if(typeof(successfun) == 'function'){
                    successfun();
                }else{
                    //goBack();
                }
            }
        }
    });
}

//获取登陆后的重定向地址
function getRedirectUrlAfterLogin(){
    return localStorage.redirectUrlAfterLogin;
}

//设置登陆后的重定向地址
function setRedirectUrlAfterLogin(redirectUrlAfterLogin){
    localStorage.redirectUrlAfterLogin = redirectUrlAfterLogin;
}

function toString(obj){
    if(obj == null || obj == undefined){
        return '';
    }
    return '' + obj;
}
