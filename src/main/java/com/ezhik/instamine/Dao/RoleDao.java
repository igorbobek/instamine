package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
