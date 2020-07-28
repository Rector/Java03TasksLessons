package taskLesson02;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkWithDatabases {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static String nameFile;
    private static List<String> dateIn;

    static{
        nameFile = "D:\\JavaProject\\Java03\\test.txt";
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:myDatabase.db");
        statement = connection.createStatement();
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS humans ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, " + "age INTEGER)");
    }


    public static void addDataToTable(int quantity) throws SQLException {
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("INSERT INTO humans (name, age) VALUES (?, ?);");
        for (int i = 0; i < quantity; i++) {
            preparedStatement.setString(1, "Felix" + i);
            preparedStatement.setInt(2, 20 + i * 5);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.setAutoCommit(true);
    }


    public static void getData() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT name, age FROM humans where age > 20");
        while (result.next()) {
            System.out.println(result.getString("name") + " " + result.getInt(2));
        }
    }


    public static void getMetaData() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT name, age FROM humans where age > 20");
        ResultSetMetaData result2 = result.getMetaData();

        for (int i = 1; i < result2.getColumnCount(); i++) {
            System.out.println(result2.getTableName(i) + " "
                    + result2.getColumnType(i) + " "
                    + result2.getColumnName(i));
        }
    }


    public static void deleteData() throws SQLException {
        int result = statement.executeUpdate("DELETE FROM humans where age = 25");
        System.out.printf("Удалено записей: %d\n", result);
    }


    public static void resettingAutonumberingInTable() throws SQLException{
        statement.executeUpdate("DELETE FROM sqlite_sequence where name = 'humans'");
    }


    public static void tableDelete() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS humans");
    }


    public static void convertFileInList() throws IOException{
        Path path = Paths.get(nameFile);
        Scanner scanner = new Scanner(path);
        dateIn = new ArrayList<>();
        while (scanner.hasNextLine()) {
            dateIn.add(scanner.nextLine());
        }
        scanner.close();
    }


    public static void setData(String[] nameSet, int[] ageSet, int[] idSet, int place) throws SQLException {
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("UPDATE humans set name = ?, age = ? where id = ?;");
        preparedStatement.setString(1, nameSet[place]);
        preparedStatement.setInt(2, ageSet[place]);
        preparedStatement.setInt(3, idSet[place]);
        preparedStatement.addBatch();
        preparedStatement.executeBatch();
        connection.setAutoCommit(true);
    }


    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

// 1. Создать CRUD операции,
        try {

// 1 метод создания таблицы
            createTable();

// 2 метод для добавления записи
            addDataToTable(3);

// 3 метод для получения записи
            getData();
            getMetaData();

// 4 метод для удаления записи
            deleteData();

// 5 удаление таблицы
            tableDelete();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }


        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            createTable();
            addDataToTable(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            convertFileInList();

            String s1 = dateIn.get(0) + " " + dateIn.get(1) + " " + dateIn.get(2);
            String[] array1 = s1.split(" ");

            int[] idArray = {Integer.parseInt(array1[0]),
                    Integer.parseInt(array1[3]),
                    Integer.parseInt(array1[6])};
            String[] nameArray = {array1[1], array1[4], array1[7]};
            int[] ageArray = {Integer.parseInt(array1[2]),
                    Integer.parseInt(array1[5]),
                    Integer.parseInt(array1[8])};

            setData(nameArray, ageArray, idArray, 0);
            setData(nameArray, ageArray, idArray, 1);
            setData(nameArray, ageArray, idArray, 2);
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

}
