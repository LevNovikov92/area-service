package com.lev.areaservice.area.search.vo;

import com.lev.areaservice.landmark.Landmark;
import com.lev.areaservice.school.School;
import lombok.Data;

import java.util.Set;


public @Data
class AreaFromFilter {
    final int id;
    final String title;
    final Float safetyScore;
    final Set<Landmark> landmarks;
    final Set<School> schools;
}
