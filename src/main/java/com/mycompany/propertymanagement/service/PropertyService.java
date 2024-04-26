package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO property);

    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO dto, Long propertyId);

    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO dto, @PathVariable Long id);
    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO dto, @PathVariable Long id);

    void deleteProperty(Long propertyId);
}
