package databaseServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SqlHelper<T> {

    public List<T> executeQuery(String sql, Consumer<ResultSet> consumer) {

        List<T> result = new ArrayList<T>();
        Database db = Database.getInstance();

        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            consumer.accept(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
