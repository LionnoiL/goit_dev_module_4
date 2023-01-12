package databaseServices;

import utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();

    private Database() {

    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:./megasoft");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public int executeUpdateSql(String sql) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void executeSqlFile(String fileName) {
        String sql = Utils.getFilesLines(fileName);
        executeUpdateSql(sql);
    }

}
