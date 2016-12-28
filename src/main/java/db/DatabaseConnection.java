package db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;

/**
 * Created by innopolis on 22.12.2016.
 */
public class DatabaseConnection{

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);
    public static final String DB_URL = "jdbc:h2:~/DevelopmentPlan";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    public static final String H2_DRIVHER = "org.h2.Driver";

    private static Connection conn;

    public static Connection getConnection(){
        try{
            Class.forName(H2_DRIVHER);
            conn = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
        }catch (ClassNotFoundException e){
            DatabaseConnection.LOGGER.info("Can't get driver: " + e.getMessage());
            conn = null;
        } catch (SQLException e) {
            DatabaseConnection.LOGGER.info(e.getMessage());
        }
        return conn;
    }
}
