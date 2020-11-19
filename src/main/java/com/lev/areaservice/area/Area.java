package com.lev.areaservice.area;

import com.lev.areaservice.school.School;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

public @Data
class Area {
    @Id
    final int id;

    final String title;

    final Set<School> schools;
}
