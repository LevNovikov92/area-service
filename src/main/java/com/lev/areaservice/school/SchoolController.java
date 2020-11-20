package com.lev.areaservice.school;

import com.lev.areaservice.helpers.Lang;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class SchoolController {

    final SchoolRepo schoolRepo;
    final SchoolTypeRepo schoolTypeRepo;

    @GetMapping("/school")
    public List<School> getSchools() {
        return Lang.toList(schoolRepo.findAll());
    }

    @GetMapping("/schoolType")
    public List<SchoolType> getSchoolTypes() {
        return Lang.toList(schoolTypeRepo.findAll());
    }

    @GetMapping("/school?area={area}")
    public List<School> getSchools(@PathVariable("area") int areaId) {
        return Lang.toList(schoolRepo.findAllByArea(areaId));
    }
}
