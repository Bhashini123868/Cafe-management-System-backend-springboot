package edu.icet.service.impl;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final ModelMapper mapper;

    @Override
    public User addUser(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return mapper.map(userEntity, User.class);
    }

    @Override
    public User updateUser(User user) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent())
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, User.class))
                .collect(Collectors.toCollection(null));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .map(user->mapper.map(user, User.class))
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findById(email);
    }
}
