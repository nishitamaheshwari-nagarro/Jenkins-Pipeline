package com.nagarro.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.userservice.entity.User;
import com.nagarro.userservice.entity.UserRole;
import com.nagarro.userservice.repository.UserRepository;
import com.nagarro.userservice.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setActive(1);
        UserRole role = userRoleRepository.findUserRoleByRoleName("ROLE_USER");
        user.setRole(role);
        return userRepository.save(user);
    }
}
