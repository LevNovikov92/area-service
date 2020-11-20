package com.lev.areaservice.helpers;

import java.util.ArrayList;
import java.util.List;

public class Lang {

    public static <T> List<T> toList(Iterable<T> iterable) {
        var list = new ArrayList<T>();
        iterable.forEach(list::add);
        return list;
    }
}
