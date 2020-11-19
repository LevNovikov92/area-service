package com.lev.areaservice.area;

import com.lev.areaservice.area.search.SearchAreaRepo;
import org.springframework.data.repository.CrudRepository;


public interface AreaRepo extends CrudRepository<Area, Integer>, SearchAreaRepo {

}
