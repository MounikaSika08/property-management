package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOToEntity(PropertyDTO property){
        PropertyEntity entity = new PropertyEntity();
        entity.setTitle(property.getTitle());
        entity.setAddress(property.getAddress());
        entity.setDescription(property.getDescription());
        entity.setOwnerEmail(property.getOwnerEmail());
        entity.setPrice(property.getPrice());
        entity.setOwnerName(property.getOwnerName());
        return entity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity entity){
        PropertyDTO dto = new PropertyDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setOwnerEmail(entity.getOwnerEmail());
        dto.setPrice(entity.getPrice());
        dto.setOwnerName(entity.getOwnerName());

        return dto;
    }
}
