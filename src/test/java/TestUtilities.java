import service.KlasaService;
import service.UczenService;

import java.sql.*;

/**
 * Created by kamil on 26.10.14.
 */
public class TestUtilities {

    public static final String URL = "jdbc:hsqldb:hsql://localhost/";

    public static void createTables() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            connection.prepareStatement(KlasaService.CREATE_KLASA_TABLE).executeUpdate();
            connection.prepareStatement(UczenService.CREATE_UCZEN_TABLE).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteTables() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            if(!checkIfTableExists("uczen")) {
                connection.prepareStatement("DROP TABLE uczen").executeUpdate();
            }

            if(!checkIfTableExists("klasa")) {
                connection.prepareStatement("DROP TABLE klasa").executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Boolean checkIfTableExists(String tableName) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);

            while (rs.next()) {
                if (tableName.equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
