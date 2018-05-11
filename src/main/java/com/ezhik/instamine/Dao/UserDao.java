package com.ezhik.instamine.Dao;

import com.ezhik.instamine.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String login);
    Optional<User> findById(Long id);
}
