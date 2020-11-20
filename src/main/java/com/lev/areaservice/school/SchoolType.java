package com.lev.areaservice.school;

import lombok.Data;
import org.springframework.data.annotation.Id;

public @Data class SchoolType {
    @Id
    final int id;
    final String title;
}
