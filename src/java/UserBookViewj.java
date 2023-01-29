
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean

@SessionScoped
public class UserBookViewj  {

    public List<AddBooks> getBookList() {
        List<AddBooks> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from USERTW");
            while (rs.next()) {
                AddBooks admin = new AddBooks();
                admin.setBookID(rs.getString(1));
                admin.setBookCategory(rs.getString(2));
                admin.setBookName(rs.getString(3));
                admin.setAuthorName(rs.getString(4));
                admin.setPrice(rs.getString(5));
                
                
                
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
//insert into cart(select *from usertw where bookid=? ,book_name=?);
