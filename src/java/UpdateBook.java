

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped

public class UpdateBook { 
 
    private String bookid;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    private String bookName;



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
   
    private String price;
 
   


    

 
public void updatebook()
  {
      try{
       DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            //String sql = ();
            PreparedStatement ps = con.prepareStatement("update USERTW SET BOOKNAME=?,PRICE=? WHERE BOOKID=?");
            ps.setString(1,bookName );
            ps.setString(2, price);
            ps.setString(3, bookid);
            
            
            
            
            ps.executeUpdate();
      }
      catch(SQLException | ClassNotFoundException e)
      {
      
      System.out.print(e);
      }
       
  }
}

