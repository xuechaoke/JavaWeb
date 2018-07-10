package com.ciao.dao;

import com.ciao.bean.User;
import com.ciao.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Administrator on 2018/7/8/008.
 */
public class UserDao {
    public User findUser(String userName,String passWord){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="SELECT * FROM user  WHERE userName=? AND passWord=?";
        User user1=null;
        try {
            user1 = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),userName,passWord);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user1;

    }

}
