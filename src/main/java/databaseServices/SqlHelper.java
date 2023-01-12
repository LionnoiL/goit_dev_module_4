package databaseServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

public class SqlHelper {

    public void executeQuery(String sql, Consumer<ResultSet> consumer) {

        Database db = Database.getInstance();

        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            consumer.accept(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
