package org.example.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author
 */
public class MapperProxyFactory<T> {

    /**
     * 你要给哪一个接口做代理？
     * Class<?> 和 Class<T> 的区别
     */
    private final Class<T> mapperInterface;

    //放到 newInstance 方法的内部，因为这个工厂类直接提供实例化方法，调用方不用管具体的代理逻辑
    //private MapperProxy mapperProxy;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        //this.mapperProxy = mapperProxy;
    }

    public T newInstance(Map<String, String> sqlSession) {
        MapperProxy mapperProxy = new MapperProxy(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface}, mapperProxy);
    }

}
