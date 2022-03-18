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

            Statement stmt = null;
            String query = "select * from dummyTbl;";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println(name);                    
                }
            } catch (SQLException e) {
                throw new Error("problem",e);
            }finally{
                if(stmt != null){
                    stmt.close();
                }
            }
        } catch (Exception e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
}