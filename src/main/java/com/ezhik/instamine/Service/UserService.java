package com.ezhik.instamine.Service;


import com.ezhik.instamine.Model.User;

public interface UserService {

    void save(User user);
    User findById(Long id);
    User findByName(String name);
    User findByEmail(String email);
    void update(User user);
    void delete(User user);
}
