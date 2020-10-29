package com.ems.dao;

import com.ems.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xiaozhihe
 * @Description: ${todo}
 * @date 2020/6/2611:51
 */

@Mapper
public interface UserMapper {
    /**
     * 新增一条用户数据
     * @param user 用户信息
     * @return 个数
     */
    int insertUser(User user);

    /**
     * 批量插入用户信息
     * @param userList 用户信息list
     * @return 个数
     */
    int insertBatchUser(List<User> userList);
    /**
     * 修改一条用户数据
     * @param user 用户数据
     * @return 修改个数
     */
    int updateUser(User user);
    int updataUserBatch(List<User> user);
    int deleteUser(User user);
    int deleteUserBatch(List<User> user);
    User selectUserById(String id);
    List<User> selectUserBatch();

}
