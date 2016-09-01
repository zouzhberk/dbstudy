package com.github.zouzhberk.dbstudy.deadlock;

import com.github.zouzhberk.dbstudy.common.ConnectionConsumer;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by berk (zouzhberk@163.com)) on 8/29/16.
 */
public class MySQLDeadLockDemo
{

    public static void main(String[] args) throws SQLException, InterruptedException
    {
        String url = "jdbc:mysql://localhost:3306/dbstudy?user=root&password=engine";
        String sql1 = "UPDATE StockPriceInnoDB SET close = ?  WHERE stockId = ?";

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit( () -> {
            executeTransaction(url, connection -> updateStatement(connection, sql1, 325.5, 30), connection ->
                    updateStatement(connection, sql1, 325.5, 20));
            return 0;
        } );

        service.submit( () -> {
            executeTransaction(url, connection -> updateStatement(connection, sql1, 525.5, 20), connection ->
                    updateStatement(connection, sql1, 525.5, 30));
            return 0;
        } );

        service.awaitTermination(1, TimeUnit.DAYS);

    }

    static int updateStatement(Connection connection, String sql, Object... params) throws SQLException
    {
        int count = 0;
        int index = 0;
        while ((index = sql.indexOf('?', index + 1)) > 0)
        {
            count++;
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < count; i++)
        {
            statement.setObject(i + 1, params[i] != null ? params[i] : null);
        }

        return statement.executeUpdate();
    }


    static void executeTransaction(String url, ConnectionConsumer... consumers) throws SQLException
    {
        Connection connection = DriverManager.getConnection(url);

        try
        {
            connection.setAutoCommit(false);
            for (ConnectionConsumer consumer : consumers)
            {
                consumer.accept(connection);
            }

            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            connection.rollback();
        }
        finally
        {
            if (!connection.isClosed())
            {
                connection.close();
            }
        }

    }
}
