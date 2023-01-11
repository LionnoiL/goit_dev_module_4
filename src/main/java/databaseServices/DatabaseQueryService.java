package databaseServices;

import selectSqlClasses.LongestProject;
import selectSqlClasses.MaxProjectCountClient;
import selectSqlClasses.MaxSalaryWorker;
import selectSqlClasses.YoungestEldestWorker;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        Database db = Database.getInstance();

        String sql = Utils.getFilesLines("sql/find_max_projects_client.sql");

        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setProjectCount(rs.getInt("cnt"));
                maxProjectCountClient.setName(rs.getString("name"));
                result.add(maxProjectCountClient);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> result = new ArrayList<>();

        Database db = Database.getInstance();

        String sql = Utils.getFilesLines("sql/find_longest_project.sql");

        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                LongestProject longestProject = new LongestProject();
                longestProject.setMonth_count(rs.getInt("month_count"));
                longestProject.setName(rs.getString("name"));
                result.add(longestProject);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers(){
        List<MaxSalaryWorker> result = new ArrayList<>();

        Database db = Database.getInstance();

        String sql = Utils.getFilesLines("sql/find_max_salary_worker.sql");

        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(rs.getString("name"));
                maxSalaryWorker.setSalary(rs.getInt("salary"));
                result.add(maxSalaryWorker);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers(){
        List<YoungestEldestWorker> result = new ArrayList<>();

        Database db = Database.getInstance();

        String sql = Utils.getFilesLines("sql/find_youngest_eldest_workers.sql");

        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                youngestEldestWorker.setName(rs.getString("name"));
                youngestEldestWorker.setType(rs.getString("type"));
                youngestEldestWorker.setBirthday(rs.getDate("birthday"));
                result.add(youngestEldestWorker);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

}
