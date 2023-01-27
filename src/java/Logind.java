
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Logind 

{
   public static boolean validate(String UserName, String Password){
           boolean status=false;
           try{
           DBConnection dbcon=new DBConnection();
           Connection con=dbcon.connMethod();
           PreparedStatement ps=con.prepareStatement("select * from USERT where USERNAME=? and PASSWORD=?");
                   ps.setString(1,UserName);
                    ps.setString(2, Password);
                    ResultSet rs= ps.executeQuery();
                    status= rs.next();
                    
                    
           }catch(Exception e)
           {
               System.out.println(e);
           }
           return status;
   }
       
   }   

