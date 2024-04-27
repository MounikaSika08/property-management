package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Autowired
    private PropertyService service;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO property){
        property = service.saveProperty(property);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(property, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>>  getAllProperties(){
        List<PropertyDTO> propertyList = service.getAllProperties();
        ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return response;
    }

    @GetMapping("/properties/users/{userId}")
    public ResponseEntity<List<PropertyDTO>>  getAllPropertiesForUser(@PathVariable Long userId){
        List<PropertyDTO> propertyList = service.getAllPropertiesForUser(userId);
        ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return response;
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO dto, @PathVariable Long id){
        PropertyDTO updatedDTO = service.updateProperty(dto, id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatedDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO dto, @PathVariable Long id){
        PropertyDTO updatedDTO = service.updatePropertyDescription(dto, id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatedDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO dto, @PathVariable Long id){
        PropertyDTO updatedDTO = service.updatePropertyPrice(dto, id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatedDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity deleteProperty(@PathVariable Long id){
        service.deleteProperty(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;

    }
}
