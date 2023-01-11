package services;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.executeSqlFile("sql/init_db.sql");
    }
}
