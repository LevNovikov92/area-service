package com.lev.areaservice.search;

import com.lev.areaservice.area.AreaRepo;
import com.lev.areaservice.area.search.filter.SearchFilter;
import com.lev.areaservice.area.search.vo.AreaFromFilter;
import com.lev.areaservice.school.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/searchByFilter")
    public List<AreaFromFilter> getAreaData(@RequestBody SearchFilter filter) {
        return areRepo.getByFilter(filter);
    }
}
