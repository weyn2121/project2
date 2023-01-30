
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class buyBookValidator 
{
  private String bookID;
  private String bookName;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String buybook(String bookID,String bookName)
    {
       
    
          DBConnection dbcon=new DBConnection();
          Connection con;
       
          try {
              con = dbcon.connMethod();
            
              PreparedStatement ps=con.prepareStatement("select BOOKID,BOOK_NAME from USERTW where BOOKID=? and BOOK_NAME=?");
              
            ps.setString(1, bookID);
            ps.setString(2, bookName);
            ResultSet rs=ps.executeQuery();
           
        if(rs.next()){
          
              return "BuyDone.xhtml"; 
            
        } else return "UserBookView";
           
          } catch (ClassNotFoundException | SQLException ex) {
              System.out.println("error");
          }
            
         
                    
      
      return "UserBookViewj";
           }
}
