
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.HttpSession;
@ManagedBean
@SessionScoped
public class UserLoginValidator 
{
  private String UserName;
  private String Password;
private String user;
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
    public String ValidateUserNamePassword(String str,String str1)
    {
        user=str;
    
          DBConnection dbcon=new DBConnection();
          Connection con;
       
          try {
              con = dbcon.connMethod();
            
              PreparedStatement ps=con.prepareStatement("select USERNAME,PASSWORD from USERDATA where USERNAME=? and password=?");
               System.out.println(getUserName());
            ps.setString(1, str);
            ps.setString(2, str1);
            ResultSet rs=ps.executeQuery();
           
        if(rs.next()){
          
              return "UserBookView"; 
            
        } else return "UserRegister";
           
          } catch (ClassNotFoundException | SQLException ex) {
              System.out.println("error");
          }
            
         
                    
      
      return "UserBookViewj";
             

           }
}
