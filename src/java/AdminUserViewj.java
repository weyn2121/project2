
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean

@SessionScoped
public class AdminUserViewj {

    public List<UserRegisterJ> getUserList() {
        List<UserRegisterJ> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from USERDATA");
            while (rs.next()) {
                UserRegisterJ admin = new UserRegisterJ();
                admin.setUserName(rs.getString(1));
                admin.setPassword(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setAddress(rs.getString(4));
                admin.setMobileNumber(rs.getString(5));
                
                
                
                //course[1]=rs.getString("COURSE");
                //usr.setCourse(course);
                list.add(admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            
        }
        return list;
    }

}
