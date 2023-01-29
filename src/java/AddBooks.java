

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
            String sql = "Insert into USERTW(BOOKID,BOOKCATEGORY,BOOKNAME,AUTHORNAME,PRICE)";
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
  private String id;
  private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
   public void bookstore() throws ClassNotFoundException, SQLException
  {String bokid=new String();
  String bokcat=new String();
  String bokna=new String();
  String aut=new String();
  String pric=new String();
      try{
       DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql1="SELECT *FROM USERTW WHERE BOOKID=?and BOOKNAME=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
             ps1.setString(1, id);
            ps1.setString(2, name);
             ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                bokid=rs.getString("BOOKID");
                 bokcat=rs.getString("BOOKCATEGORY");
                 bokna=rs.getString("BOOKNAME");
                 aut=rs.getString("AUTHORNAME");
                 pric=rs.getString("PRICE");
                
                
                //course[1]=rs.getString("COURSE");
                //usr.setCourse(course);
                
            }
            
            
            
            String sql = "Insert into CART(BOOKID,BOOKCATEGORY,BOOKNAME,AUTHORNAME,PRICE) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bokid);
            ps.setString(2, bokcat);
             ps.setString(3, bokna);
              ps.setString(4, aut);
               ps.setString(5, pric);
               ps.executeUpdate();
      }
      catch(SQLException | ClassNotFoundException e)
      {
      
      System.out.print(e);
      }
      
  }
   
}


