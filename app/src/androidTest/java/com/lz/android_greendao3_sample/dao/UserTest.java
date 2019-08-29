package com.lz.android_greendao3_sample.dao;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import com.lz.android_greendao3_sample.User;
import com.lz.android_greendao3_sample.dao.UserDao;

public class UserTest extends AbstractDaoTestLongPk<UserDao, User> {

    public UserTest() {
        super(UserDao.class);
    }

    @Override
    protected User createEntity(Long key) {
        User entity = new User();
        entity.setId(key);
        entity.setRepos();
        return entity;
    }

}
