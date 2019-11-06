package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/git?createDatabaseIfNotExist=true&allowMultiQueries=true", "root", "1234");

            PreparedStatement preparedStatement = connection.prepareStatement("SHOW TABLES");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                String sql = "\n" +
                        "CREATE TABLE  IF NOT EXISTS customer(\n" +
                        "\tid VARCHAR(4) PRIMARY KEY NOT NULL,\n" +
                        "\tname VARCHAR(50),\n" +
                        "\taddress VARCHAR(50),\n" +
                        ");\n" ;
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static DBConnection getInstance() {
        if (dbConnection == null)
            dbConnection = new DBConnection();

        return dbConnection;

//        return dbConnection=((dbConnection==null)?new DB.DBConnection():dbConnection);
    }

    public Connection getConnection() {
        return connection;
    }
}
