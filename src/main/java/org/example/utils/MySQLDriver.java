package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Config;

import java.sql.*;

public class MySQLDriver {
    final private Logger logger = LogManager.getLogger(this.getClass());
    final private Connection _mysqlConn;

    public MySQLDriver() {
        String url = String.format(
                "jdbc:mysql://%s:%s/%s",
                Config.MYSQL_HOST.value,
                Config.MYSQL_PORT.value,
                Config.MYSQL_DATABASE.value
        );
        try {
            logger.debug("Create mysql connection");
            this._mysqlConn = DriverManager.getConnection(url, Config.MYSQL_USERNAME.value, Config.MYSQL_PASSWORD.value);
            Runtime.getRuntime().addShutdownHook(new Thread(MySQLDriver.this::close));
        } catch (SQLException e) {
            String message = "Could not connect to database";
            logger.error(message + ": Reason: " + e.getMessage());
            throw new RuntimeException(message, e);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return this._mysqlConn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            String message = "Couldn't execute query: \"" + query + "\"";
            logger.error(message + ": Reason: " + e.getMessage());
            throw new RuntimeException(message, e);
        }
    }

    public boolean execute(String query) {
        try {
            return this._mysqlConn.createStatement().execute(query);
        } catch (SQLException e) {
            String message = "Couldn't execute query: \"" + query + "\"";
            logger.error(message + ": Reason: " + e.getMessage());
            throw new RuntimeException(message, e);
        }
    }

    public PreparedStatement preparedStatement(String query) {
        try {
            return this._mysqlConn.prepareStatement(query);
        } catch (SQLException e) {
            String message = "Couldn't create prepared statement with query: \"" + query + "\"";
            logger.error(message + ": Reason: " + e.getMessage());
            throw new RuntimeException(message, e);
        }
    }

    final public void close() {
        try {
            _mysqlConn.close();
            logger.debug("Close mysql connection");
        } catch (SQLException e) {
            // Ignore
        }
    }
}
