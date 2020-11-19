package com.lev.areaservice.area.search.vo;

import com.lev.areaservice.landmark.Landmark;
import lombok.Data;

import java.util.List;


public @Data
class AreaFromFilter {
    final int id;
    final String title;
    final Float safetyScore;
    final List<Landmark> landmarks;
}
