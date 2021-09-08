import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarParts", "root", "Dovydas123/");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * Parts");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("partsName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
