package com.github.zouzhberk.dbstudy.common;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by berk (zouzhberk@163.com)) on 9/1/16.
 */
public interface ConnectionConsumer
{
    void accept(Connection t) throws SQLException;
}
