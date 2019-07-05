package Application;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement statement;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:HW_Checker.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getStudentsName(String login){
        String sql = String.format("SELECT Full_Name FROM students WHERE login = '%s'", login);

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getStudentsList() throws SQLException{
        ResultSet resultSet = null;
        String sql = String.format("SELECT Login, Full_Name FROM Students");
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static void addStudent(String login, String name) throws SQLException{
        String sql = String.format("INSERT INTO Students (Login, Full_Name) VALUES ('%s', '%s')", login, name);
        statement.execute(sql);
    }
}
