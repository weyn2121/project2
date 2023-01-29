
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean

@SessionScoped
public class buyBook  {

    public List<BuyBookBean> getBuyBookList() {
        List<BuyBookBean> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from CART");
            while (rs.next()) {
                BuyBookBean buyer = new BuyBookBean();
                buyer.setBookID(rs.getString(1));
                buyer.setBookCategory(rs.getString(2));
                buyer.setBookName(rs.getString(3));
                buyer.setAuthorName(rs.getString(4));
                buyer.setPrice(rs.getString(5));
                
                
                
                //course[1]=rs.getString("COURSE");
                //usr.setCourse(course);
                list.add(buyer);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            
        }
        return list;
    }

}
//insert into cart(select *from usertw where bookid=? ,book_name=?);
