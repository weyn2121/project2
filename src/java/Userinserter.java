
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
@ManagedBean


public class Userinserter {
 public String UserName;
 public String Password;

 
 
 
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

  public String Inserter()
  {
      try{
       DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into USERP(USERNAME,PASSWORD) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, UserName);
            ps.setString(2, Password);
           
            ps.executeUpdate();
      }
      catch(SQLException | ClassNotFoundException e)
      {
      
      System.out.print(e);
      }
       return "UserBookView";
  }
   
}
