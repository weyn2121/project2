import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class AddBooks implements Serializable{ 
   private String BookID;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

  
    
    private String BookCategory;
   private String BookName;
     private String AuthorName;
   private String Price;
    private String ClickBookId;
    public String getPrice() {
        return Price;
    }

    public String getClickBookId() {
        return ClickBookId;
    }

    public void setClickBookId(String ClickBookId) {
        this.ClickBookId = ClickBookId;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
  
 
    public String getBookCategory() {
        return BookCategory;
    }

    public void setBookCategory(String BookCategory) {
        this.BookCategory = BookCategory;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    
   

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }
  

  public String bookInserter()
  {
      try{
       DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into USERTW(BOOKID,BOOK_CATEGORY,BOOK_NAME,AUTHORNAME,PRICE) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, BookID);
            ps.setString(2, BookCategory);
            ps.setString(3, BookName);
            ps.setString(4, AuthorName);
            ps.setString(5, Price);
            ps.executeUpdate();
      }
      catch(SQLException | ClassNotFoundException e)
      {
      
      System.out.print(e);
      }
       return "AdminView";
  
      
  }
   
}
