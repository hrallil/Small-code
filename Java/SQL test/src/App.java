import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
class App{
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:db/database.db";
            conn = DriverManager.getConnection(url);
            System.out.println("got it!");

            Statement stmt = conn.createStatement();
            //stmt.executeUpdate("create table tbl1 (name text, age integer);");
            stmt.executeUpdate("insert into tbl1 values ('rasmus', 23);");

            ResultSet rs = stmt.executeQuery("select * from tbl1;");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getString("age"));
            }
            
            
        } 
        catch (Exception e) {
            throw new Error("Problem", e);
        } 
        finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
}