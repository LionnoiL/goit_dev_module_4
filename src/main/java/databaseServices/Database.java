package services;

import utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database INSTANCE = new Database();

    private Connection connection;

    private Database(){
        try {
            connection = DriverManager.getConnection("jdbc:h2:./megasoft");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int executeUpdateSql(String sql){

        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public void executeSqlFile(String fileName){

        String sql = Utils.getFilesLines(fileName);
        executeUpdateSql(sql);

    }


}
