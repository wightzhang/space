package com.zkg.rpc;

import java.io.Serializable;

/*
 * created by kgzhang 2018/11/4
 * 传输对象
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = -1756979266601010335L;

    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
