package com.zkg.delegate.servlet;

import com.zkg.delegate.servlet.controller.SystemAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/*
 * created by kgzhang 2018/10/13
 */
public class ServletDispatcher {

    // 保存url和执行方法的对应关系
    private List<Handler> handlerMapping = new ArrayList<>();
    ServletDispatcher() {
        Class systemActionClass = SystemAction.class;
        Handler systemHandler = new Handler();

        try {
            systemHandler.setController(systemActionClass.newInstance());
            systemHandler.setUrl("/system/logout");
        } catch (Exception e) {
            e.printStackTrace();
        }

        handlerMapping.add(systemHandler);
    }


    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        // 1获取用户请求的url
        String uri = request.getRequestURI();
        // 2 Servlet 拿到Url以后，做选择
        //  根据url，知道对应的某一个java类的方法，
        //  可以用策略模式
        Handler handle =null;
        // 3 通过url到handlermapping中找
        for(Handler h : handlerMapping){
            if(uri.equals(h.getUrl())){
                handle = h;
                break;
            }
        }
        // 4 将任务交给methon
        Object result;
        try {
            assert handle != null;
            result = handle.getMethod().invoke(handle.getController(),request.getParameter(""));

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 5 将method执行结果，通过response返回出去

        try {
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Handler(){}

        public Handler(Object controller, Method method, String url) {
            this.controller = controller;
            this.method = method;
            this.url = url;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
