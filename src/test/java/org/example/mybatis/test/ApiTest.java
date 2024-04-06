package org.example.mybatis.test;

import com.alibaba.fastjson.JSON;
import org.example.mybatis.binding.MapperProxyFactory;
import org.example.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("nihao", "sql statements");
        IUserDao iUserDao = factory.newInstance(objectObjectHashMap);
        String nihao = iUserDao.queryUserName("nihao");
        logger.info("sdf: {}", nihao);
    }

    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                (proxy, method, args) -> "你被代理了");
        String result = userDao.queryUserName("my id");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}
