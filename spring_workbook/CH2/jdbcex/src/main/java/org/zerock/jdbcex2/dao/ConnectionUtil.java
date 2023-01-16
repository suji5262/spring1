package org.zerock.jdbcex2.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("webdb");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("PrepStmtCacheSize", "250");
        config.addDataSourceProperty("PrepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);

    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
