package edu.icet.service;

import edu.icet.dto.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    User getUserByEmail(String email);
}
