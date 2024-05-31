import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Variant4 {
    private static final String connectionString = "jdbc:jtds:sqlserver://93.84.82.170:1433;databaseName=Stormnet;user=admin;password=1234-qwer";

    private Connection connection;
    private Statement statement;

    @BeforeEach
    void prepareConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        connection = DriverManager.getConnection(connectionString);
        statement = connection.createStatement();
    }

    @AfterEach
    void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    @Test
    void deleteTable() throws SQLException {
        String query = "DROP TABLE [Stormnet].[dbo].[variant4]";
        int result = statement.executeUpdate(query);
        Assertions.assertEquals(0, result);
    }

    @Test
    void checkInnerJoin() throws SQLException {
        String query = "SELECT * FROM [Stormnet].[dbo].[variant4task2first] INNER JOIN [Stormnet].[dbo].[variant4task2second] ON [Stormnet].[dbo].[variant4task2first].username = [Stormnet].[dbo].[variant4task2second].client";
        ResultSet resultSet = statement.executeQuery(query);
        List<Map<Object, Object>> resultList = new ArrayList<>();
        while (resultSet.next()) {
            Map<Object, Object> map = new HashMap<>();
            for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                System.out.println("Current column: " + resultSet.getMetaData().getColumnName(i));
                System.out.println("Current column value: " + resultSet.getObject(i));
                map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            resultList.add(map);
        }
        Map<Object, Object> lastRecord = resultList.get(resultList.size() - 1);
        Assertions.assertEquals("alex", lastRecord.get("username"));
    }

    @Test
    void checkAge() throws SQLException {
        String query = "SELECT * FROM [Stormnet].[dbo].[variant4task2first] WHERE [age] < 10";
        ResultSet resultSet = statement.executeQuery(query);
        List<Map<Object, Object>> resultList = new ArrayList<>();
        while (resultSet.next()) {
            Map<Object, Object> map = new HashMap<>();
            for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                System.out.println("Current column: " + resultSet.getMetaData().getColumnName(i));
                System.out.println("Current column value: " + resultSet.getObject(i));
                map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            resultList.add(map);
        }
        Assertions.assertEquals(1, resultList.size());
    }
}