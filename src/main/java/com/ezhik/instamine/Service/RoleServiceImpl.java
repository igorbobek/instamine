package com.ezhik.instamine.Service;


import com.ezhik.instamine.Dao.RoleDao;
import com.ezhik.instamine.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getRoleByName(String name) {
        return roleDao.findByRole(name);
    }
}
