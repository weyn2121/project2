import java.sql.*;
public class DBConnection 
{
    static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
    static final String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
    static final String USERNAME="BNM123";
    static final String PASSWORD="098";
    Connection con=null;
    public Connection connMethod() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        con=DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
        if(con!= null)
        {
            System.out.println("Connected to database succefully...");
        }else{
            System.out.println("Faild to connect to Orale DB");
        }
        return con;
    }
//            public static void main( String[] args) throws ClassNotFoundException, SQLException{
//                DBConnection db=new DBConnection();
//              System.out.print(db.connMethod());
//}
}
