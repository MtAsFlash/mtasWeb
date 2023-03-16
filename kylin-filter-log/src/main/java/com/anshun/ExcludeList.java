package com.anshun;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mtasflash Created on 2023/3/16 17:50
 */
public class ExcludeList {

    public static final Set<String> EXCLUDE_ERROR_KEY = new HashSet<>();
    public static final Set<String> EXCLUDE_ERROR_CONTENT = new HashSet<>();

    static {
        EXCLUDE_ERROR_KEY.add("c.e.k.m.r.l.SpringRedisLock");
    }
}
