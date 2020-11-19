package com.lev.areaservice.area;

import lombok.Data;
import org.springframework.data.annotation.Id;

public @Data
class AreaSafety {

    @Id
    final int areaId;
    final float scoreAvg;
    final float scoreTheft;
}
