package com.github.zouzhberk.dbstudy.common;

import com.github.zouzhberk.dbstudy.deadlock.SQLType;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by berk (zouzhberk@163.com)) on 8/29/16.
 */
public class SQLPrepare
{

    /**
     * @param args
     */
    public static void main(String[] args) throws SQLException
    {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements())
        {
            System.out.println(drivers.nextElement());
        }


        String url = "jdbc:mysql://localhost:3306/dbstudy?user=root&password=engine";
        DriverManager.getConnection(url);
    }

    public void printResultSet(ResultSet resultset) throws SQLException
    {
        int columncount = resultset.getMetaData().getColumnCount();
        for (int i = 1; i <= columncount; i++)
        {

            StringBuilder sb = new StringBuilder();
            sb.append("private ");
            int type = resultset.getMetaData().getColumnType(i);

            sb.append(SQLType.getTypeName(type));

            sb.append(" ");

            sb.append(resultset.getMetaData().getColumnName(i));
            sb.append(";");
            System.out.println(sb.toString());
        }

    }

}
