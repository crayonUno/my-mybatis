package org.example.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author
 * @description 映射器
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -6424540398559729838L;

    /**
     * key: id - namespace
     * value: sql statements
     */ 
    private Map<String, String> sqlSession;
    
    /**
     * 什么接口
     */
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // todo 通用方法不代理

        return method.getName() + "： 我创建了代理对象：你可以在这里编写你想要的代理逻辑" + sqlSession.get(mapperInterface.getMethods());
    }
}
