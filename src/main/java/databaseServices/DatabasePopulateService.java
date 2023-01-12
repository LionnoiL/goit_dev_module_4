package databaseServices;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.executeSqlFile("sql/populate_db.sql");
    }

}
