package com.lev.areaservice.search;

import com.lev.areaservice.area.Area;
import com.lev.areaservice.area.AreaRepo;
import com.lev.areaservice.area.search.filter.SearchFilter;
import com.lev.areaservice.area.search.vo.AreaData;
import com.lev.areaservice.area.search.vo.AreaFromFilter;
import com.lev.areaservice.school.School;
import com.lev.areaservice.school.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {

    final SchoolRepo schoolRepo;
    final AreaRepo areRepo;

    @Autowired
    public SearchController(SchoolRepo schoolRepo, AreaRepo areRepo) {
        this.schoolRepo = schoolRepo;
        this.areRepo = areRepo;
    }

    @GetMapping("/school")
    public List<School> getSchools() {
        return toList(schoolRepo.findAll());
    }

    @GetMapping("/area")
    public List<Area> getAreas() {
        return toList(areRepo.findAll());
    }

    @GetMapping("/areaData")
    public AreaData getAreaData() {
        return areRepo.getAreaData(1);
    }

    @PostMapping("/searchByFilter")
    public List<AreaFromFilter> getAreaData(@RequestBody SearchFilter filter) {
        return areRepo.getByFilter(filter);
    }

    private <T> List<T> toList(Iterable<T> iterable) {
        var list = new ArrayList<T>();
        iterable.forEach(list::add);
        return list;
    }
}
