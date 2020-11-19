package com.lev.areaservice.area.search;

import com.lev.areaservice.area.search.filter.SearchFilter;
import com.lev.areaservice.area.search.vo.AreaData;
import com.lev.areaservice.area.search.vo.AreaFromFilter;

import java.util.List;

public interface SearchAreaRepo {
    AreaData getAreaData(int id);

    List<AreaFromFilter> getByFilter(SearchFilter filter);
}
