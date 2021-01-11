
package DigimonPkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rahmeh Ibrahim
 * @since 10/01/2021
 */
public class ShowDigimonCard extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            //return the data from the form       
             String count = request.getParameter("count");
             String name = request.getParameter("name_"+count);
             String image = request.getParameter("img_"+count);
             String level = request.getParameter("level_"+count);
             
             //set the attributes and send it to jsp page
             request.setAttribute("name",name);
             request.setAttribute("image",image);
             request.setAttribute("level",level);
             
             request.getRequestDispatcher("Show.jsp").forward(request,response); 
          
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

  
}
