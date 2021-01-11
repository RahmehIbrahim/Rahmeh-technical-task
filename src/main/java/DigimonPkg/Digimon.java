package DigimonPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rahmeh Ibrahim
 * @since 09/01/2021
 */
public class Digimon extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
              //return the data from the form       
             String count = request.getParameter("count");
             String name = request.getParameter("name_"+count);
             String image = request.getParameter("img_"+count);
             String level = request.getParameter("level_"+count);
             
             storeDigimonCards(request,name,image,level);
            
             request.getRequestDispatcher("FavouriteCards.jsp").forward(request,response); 
           
        
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public static void storeDigimonCards(HttpServletRequest request,String name, String image,String level){
        
            Connection connectDb = null;
            PreparedStatement insertStatement = null;
         
             //store the selected faviourate card in db
             String url = "jdbc:derby://localhost:1527/DigimonDB";
             String userName = "root";
             String password = "root";
             String query =  " INSERT INTO ROOT.FAV_DIGIMON_TABLE (NAME, IMAGE, LEVEL)" + " VALUES (?, ?, ?)";
             try{
                 connectDb = DriverManager.getConnection(url,userName ,password);
                 
                 insertStatement = connectDb.prepareStatement(query);
                 insertStatement.setString (1, name);
                 insertStatement.setString (2, image);
                 insertStatement.setString (3, level);
                 insertStatement.execute();
                 connectDb.commit();
             }catch(SQLException e){
             System.out.println("The Card is Already Added !");    
             }finally{
                 if(connectDb !=null){
                     try{
                         connectDb.close();
                     }catch(SQLException e){
                         System.out.println("Can Not Close Connection");
                     }
                 }
             }
             
    }
}
