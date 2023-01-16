package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    @Test
    public void test1() {

        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void testConnection() throws Exception {

        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/webdb",
                "webuser",
                "webdb"
        );

        Assertions.assertNotNull(connection);

        connection.close();
    } // 자바 코드를 이용해 설치된 MariaDB 와 연결을 확인하는 용도


    @Test
    public void testHikariCP() throws Exception {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("webdb");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("PrepStmtCacheSize", "250");
        config.addDataSourceProperty("PrepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();

    }

}
