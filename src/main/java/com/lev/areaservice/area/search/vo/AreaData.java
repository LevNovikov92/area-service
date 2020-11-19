package com.lev.areaservice.area.search.vo;

import lombok.Data;

public @Data class AreaData {
    public final int id;

    public final String title;

    public final SafetyData safety;
}
