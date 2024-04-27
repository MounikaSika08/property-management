package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.AddressEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.excepttion.BusinessException;
import com.mycompany.propertymanagement.excepttion.ErrorModel;
import com.mycompany.propertymanagement.repository.AddressRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserConverter converter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> existingEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(existingEntity.isPresent()){
            List<ErrorModel>  errorModels = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL ALREADY EXISTS");
            errorModel.setMessage("The email with which you are trying to register already exists");
            errorModels.add(errorModel);
            throw new BusinessException(errorModels);
        }
        UserEntity entity = converter.convertDTOToEntity(userDTO);
        entity =userRepository.save(entity);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setHouseNumber(userDTO.getHouseNumber());
        addressEntity.setCity(userDTO.getCity());
        addressEntity.setPostalCode(userDTO.getPostalCode());
        addressEntity.setStreet(userDTO.getStreet());
        addressEntity.setCountry(userDTO.getCountry());
        addressEntity.setUserEntity(entity);

        addressRepository.save(addressEntity);

        userDTO = converter.convertEntityToDTO(entity);
        return  userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO dto = null;
        Optional<UserEntity> entity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(entity.isPresent()){
            dto = converter.convertEntityToDTO(entity.get());
        } else {
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email and password");
            errors.add(errorModel);
            throw new BusinessException(errors);
        }
        return dto;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserEntity> entities = (List<UserEntity>)userRepository.findAll();
        List<AddressEntity> addresses = (List<AddressEntity>)addressRepository.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for(UserEntity entity:entities){
            UserDTO dto = converter.convertEntityToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
