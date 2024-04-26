package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO property){
        PropertyEntity entity = propertyConverter.convertDTOToEntity(property);

        entity = propertyRepository.save(entity);

        PropertyDTO dto = propertyConverter.convertEntityToDTO(entity);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> properties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        for(PropertyEntity entity:properties){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(entity);
            propertyDTOS.add(dto);
        }
        return propertyDTOS;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO dto, Long propertyId) {
        Optional<PropertyEntity> entity = propertyRepository.findById(propertyId);
        PropertyDTO updated = null;
        if(entity.isPresent()){
            PropertyEntity pe = entity.get();
            pe.setTitle(dto.getTitle());
            pe.setAddress(dto.getAddress());
            pe.setDescription(dto.getDescription());
            pe.setOwnerEmail(dto.getOwnerEmail());
            pe.setPrice(dto.getPrice());
            pe.setOwnerName(dto.getOwnerName());

            updated = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return updated;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO dto, Long id) {
        Optional<PropertyEntity> entity = propertyRepository.findById(id);
        PropertyDTO updated = null;
        if(entity.isPresent()){
            PropertyEntity pe = entity.get();
            pe.setDescription(dto.getDescription());

            updated = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return updated;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO dto, Long id) {
        Optional<PropertyEntity> entity = propertyRepository.findById(id);
        PropertyDTO updated = null;
        if(entity.isPresent()){
            PropertyEntity pe = entity.get();
            pe.setPrice(dto.getPrice());

            updated = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return updated;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
