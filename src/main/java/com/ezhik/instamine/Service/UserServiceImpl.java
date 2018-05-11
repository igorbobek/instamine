package com.ezhik.instamine.Service;

import com.ezhik.instamine.Dao.RoleDao;
import com.ezhik.instamine.Dao.UserDao;
import com.ezhik.instamine.Model.Role;
import com.ezhik.instamine.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public void save(User user) {
        Set<Role> roles = user.getRoles();
        roles.add(roleDao.findByRole("USER"));

        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public void update(User user){
        userDao.save(user);
    }

    @Nullable
    @Override
    public User findById(Long id) {
        if(userDao.findById(id).isPresent()){
            return userDao.findById(id).get();
        }
        return null;
    }

    @Nullable
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Secured("ROLE_ADMIN")
    @Nullable
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
