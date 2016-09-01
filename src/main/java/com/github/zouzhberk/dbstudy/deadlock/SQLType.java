package com.github.zouzhberk.dbstudy.deadlock;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by berk (zouzhberk@163.com)) on 8/29/16.
 */
public class SQLType
{

    private static final Map<Integer, String> map = new HashMap<>();

    static
    {
        map.put(Types.BIGINT, "Long");
        map.put(Types.BIT, "boolean");
        map.put(Types.BOOLEAN, "Boolean");
        map.put(Types.VARCHAR, "String");
        map.put(Types.DATE, "java.util.Date");
        map.put(Types.DOUBLE, "Double");
    }

    /**
     * @param type
     * @return
     */
    public static String getTypeName(int type)
    {
        return map.get(type);
    }
}
