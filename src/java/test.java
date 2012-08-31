
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteJDBCLoader;
import org.sqlite.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class test {

    public static void main(String args[]) throws ClassNotFoundException {
       
 Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample123.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists productMaster");
            statement.executeUpdate("create table productMaster "
            + "(prodId INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name string, price integer, quant integer)");
            PreparedStatement st=connection.prepareStatement("insert into productMaster(name,price,quant) "+
                    "values(?,?,?)");     
            st.setString(1, "asdsa");
            st.setInt(2, 50);
            st.setInt(3, 88);
            st.executeUpdate();
//            statement.executeUpdate();
  //          statement.executeUpdate("insert into productMaster(name,price,quant) values('yui555555',456,45)");
                      ResultSet rs = statement.executeQuery("select * from productMaster");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("prodId"));
            }

        } catch (Exception e) {
            System.err.println("error   " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}


/*
  JSONObject json = new JSONObject();
        JSONObject json1 = new JSONObject();
        JSONArray jArray = new JSONArray();
        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(90);
        list.add(80);
        list.add(70);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(110);
        list1.add(901);
        list1.add(805);
        list1.add(705);
        json.put("city", "Mumbai");
        json.put("country", "India");
        json1.put("city", "Mumbaasdasdi");
        json1.put("country", "Indiasdasa");
        jArray.addAll(list);
        jArray.addAll(list1);
        jArray.add(json);
        jArray.add(json1);
        System.out.println(jArray);
 */