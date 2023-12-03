package com.kmsr.utils;

import java.util.ArrayList;
import java.util.List;

public final class ListUtils {
    public static <T> List<T> newArrayList(T ...params) {
        List<T> list = new ArrayList<>(params.length);
        for (T param: params) {
            list.add(param);
        }
        return list;
    }
}
