package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
   // List<PropertyEntity> findAllByUserEntityId(Long userEntityId);
@Query("SELECT p from PropertyEntity p WHERE p.userEntity.id=:userId")
    List<PropertyEntity> findAllByUserEntityId(@Param("userId") Long userEntityId);
}
