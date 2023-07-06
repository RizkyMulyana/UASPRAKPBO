package uasprakpbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewClass {
    private String url;
    private String username;
    private String password;
    
    public NewClass(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
        public void displayData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM todolist"; // 
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String todo = resultSet.getString("todo");
                String kategori = resultSet.getString("kategori");
                String tanggal = resultSet.getString("tanggal");
                String status = resultSet.getString("status");

                // Tampilkan data yang diambil
                System.out.println("ID: " + id );
                System.out.println("todo: " + todo);
                System.out.println("kategori: " + kategori);
                System.out.println("tanggal: " + tanggal);
                System.out.println("status: " + status);
            }
 
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }
        
     public void createData(int id, String todo, String kategori, String tanggal, String status) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO todolist (id, todo, kategori, tanggal, status) VALUES (" + id + ", '" + todo + "', '" + kategori + "', '" + tanggal + "', '" + status + "')";
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }
            
    public void updateData(int id, String newTodo, String newKategori, String newTanggal, String newStatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "UPDATE todolist SET todo = '" + newTodo + "', kategori = '" + newKategori + "', tanggal = '" + newTanggal + "', status = '" + newStatus + "' WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }
    
    public void deleteData(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM todolist WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }
}


