
package DigimonPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rahmeh Ibrahim
 * @since 10/01/2021
 */
public class ModifyDigimonCard extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
             
            //return the data from the form       
       
             String name = request.getParameter("name");
             String level = request.getParameter("level");
             String originalName = request.getParameter("originalName"); 
             
             //check the type of modify
             if(name!= null && level!= null){
              updateCard(request,name,level,originalName);
              request.getRequestDispatcher("Home.jsp").forward(request,response); 
             }else if(name!= null && level == null){
              deleteCard(request,name,level);
              request.getRequestDispatcher("Delete.jsp").forward(request,response); 

             }
          
             
        }
    }
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   /**
    * 
    * @param request
    * @param name
    * @param level
    * @param originalName 
    */
    public static void updateCard(HttpServletRequest request,String name,String level,String originalName){
        Connection connectDb = null;
        Statement updateStatement = null;
           
              
             //store the selected faviourate card in db
             String url = "jdbc:derby://localhost:1527/DigimonDB";
             String userName = "root";
             String password = "root";
             String query = "UPDATE root.FAV_DIGIMON_TABLE " 
                     + "SET NAME = '"+name + "',LEVEL = '" +level + "' WHERE NAME ='"+originalName+"'";

             try{
                 connectDb = DriverManager.getConnection(url,userName ,password);
                 updateStatement = connectDb.createStatement();
                 updateStatement.executeUpdate(query);
                 connectDb.commit();

             }catch(SQLException e){
             System.out.println("The Card Can Not Updated");    
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
    
    /**
     * 
     * @param request
     * @param name
     * @param level 
     */
    public static void deleteCard(HttpServletRequest request,String name,String level){
        Connection connectDb = null;
        Statement updateStatement = null;
           
              
             //store the selected faviourate card in db
             String url = "jdbc:derby://localhost:1527/DigimonDB";
             String userName = "root";
             String password = "root";
             String query = "Delete from root.FAV_DIGIMON_TABLE " 
                     + "WHERE NAME ='"+name+"'";

             try{
                 connectDb = DriverManager.getConnection(url,userName ,password);
                 updateStatement = connectDb.createStatement();
                 updateStatement.executeUpdate(query);
                 connectDb.commit();

             }catch(SQLException e){
             System.out.println("The Card Can Not Deleted");    
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
