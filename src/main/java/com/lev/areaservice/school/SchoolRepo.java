package com.lev.areaservice.school;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepo extends CrudRepository<School, Integer> {

    @Query("SELECT * FROM `school` WHERE area = :area")
    List<School> findAllByArea(@Param("area") int areaId);
}
