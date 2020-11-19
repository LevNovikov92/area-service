package com.lev.areaservice.area.search.filter;

import lombok.Data;
import org.springframework.lang.Nullable;

public @Data class SearchFilter {
    final @Nullable Integer schoolType;
    final @Nullable Float minSafety;
    final @Nullable String landmarkKey;
}
