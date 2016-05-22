package top.wthfeng.hfmusic.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import top.wthfeng.hfmusic.model.view.ViewError;
import top.wthfeng.hfmusic.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 * @author wangtonghe
 * @date 2016/5/7 17:27
 * @email wthfeng@126.com
 */
public class ExceptionInterceptor extends SimpleMappingExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("未知用户操作异常:" + ex.getMessage() + ";" + request.getPathInfo());
        StringBuffer sb = new StringBuffer();

        Map<String,String[]> paramsMap = request.getParameterMap();
        if(paramsMap != null && !paramsMap.isEmpty()){
            for(String key:paramsMap.keySet()){
                sb.append("&");
                sb.append(key);
                sb.append("=");
                String [] values = paramsMap.get(key);
                if(values != null && values.length > 0){
                    for(String v:values){
                        sb.append(v);
                    }
                }
            }
        }
        sb.append("&exception==**==");
        sb.append(ex.getMessage());

        logger.error(sb.toString());
        try {
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("code", 1);
            result.put("data", new ViewError(ex.getMessage()));
            response.setHeader("Content-Type","text/html;charset=UTF-8");
            response.getWriter().write(StringUtil.map2Json(result));
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }
}
