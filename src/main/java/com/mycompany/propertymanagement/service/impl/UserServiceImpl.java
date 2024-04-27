package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserConverter converter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity entity = converter.convertDTOToEntity(userDTO);
        repository.save(entity);
        userDTO = converter.convertEntityToDTO(entity);
        return  userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
