package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOToEntity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setOwnerEmail(userDTO.getOwnerEmail());
        entity.setOwnerName(userDTO.getOwnerName());
        entity.setPassword(userDTO.getPassword());
        entity.setPhoneNumber(userDTO.getPhone());
        return entity;
    }

    public UserDTO convertEntityToDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhoneNumber());
        //dto.setPassword(entity.getPassword());
        dto.setOwnerEmail(entity.getOwnerEmail());
        dto.setOwnerName(entity.getOwnerName());

        return dto;
    }
}
