package com.lev.areaservice.landmark;

import lombok.Data;
import org.springframework.data.annotation.Id;

public @Data class Landmark {
    @Id
    final int id;
    final String title;
    final String desc;
    final int area;
}
