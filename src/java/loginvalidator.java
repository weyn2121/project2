
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class loginvalidator 
{
  private String UserName;
  private String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String Username) {
        this.UserName = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String ValidateUserNamePassword()
    {
    
          DBConnection dbcon=new DBConnection();
          Connection con;
       
          try {
              con = dbcon.connMethod();
            
              PreparedStatement ps=con.prepareStatement("select USERNAME from USERT where USERNAME=? and password=?");
               System.out.println(getUserName());
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ResultSet rs=ps.executeQuery();
           
        if(rs.next()){
            String  userType=rs.getString(1);
               System.out.println(userType);
            if("Admin".equals(userType))
            {
              return "AdminPage"; 
            }
        } 
           
          } catch (ClassNotFoundException | SQLException ex) {
              System.out.println("error");
          }
            
         
                    
      
      return "Admin";
             
    }
}
  

