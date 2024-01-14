package lesson35;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "Root";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
            Statement statement = connection.createStatement();
            String insertSql = "INSERT INTO films (id,title,year,watched) VALUES (8, 'John Smithmp', 2007,true)";
            statement.executeUpdate(insertSql);
            System.out.println("Данные успешно добавлены в таблицу!");

            String updateSql = "UPDATE films SET year = 2010,title = 'Black' WHERE id = 6";
            statement.executeUpdate(updateSql);
            System.out.println("Данные успешно изменены в таблице!");

            String deleteSql = "DELETE FROM films WHERE id = 8";
            statement.executeUpdate(deleteSql);
            System.out.println("Данные успешно удалены из таблицы!");

            String query = "SELECT * FROM films";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");
                System.out.println("ID: " + id);
                System.out.println("title: " + title);
                System.out.println("year: " + year);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
