package org.example.mybatis.test.dao;

/**
 * @author
 * @description
 * @date 2022/3/26
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

}