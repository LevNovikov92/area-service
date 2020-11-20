package com.lev.areaservice.area;

import com.lev.areaservice.area.search.vo.AreaData;
import com.lev.areaservice.helpers.Lang;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AreaController {

    final AreaRepo areRepo;

    @GetMapping("/area")
    public List<Area> getAreas() {
        return Lang.toList(areRepo.findAll());
    }

    @GetMapping("/areaData")
    public AreaData getAreaData() {
        return areRepo.getAreaData(1);
    }
}
