
package control;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author DuyAnhComputer
 */
@WebServlet(name="InfoServlet", urlPatterns={"/info"})
public class InfoServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InfoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InfoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("id");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
            
        UserDAO userDao = new UserDAO();            
        
        request.setAttribute("u", username);
        request.setAttribute("e", email);
        request.setAttribute("f", fullname);

        try {
            userDao.updateInfo(username, fullname, email);
            HttpSession session = request.getSession();
            Users updatedUser = userDao.checkUser(username);
            session.setAttribute("account", updatedUser);
            request.setAttribute("mes1", "Change information successful");
            request.getRequestDispatcher("profile.jsp").forward(request, response);                    
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred while updating the information.");
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }  
    }

    @Override
    public String getServletInfo() {
        return "InfoServlet handles user information updates.";
    }
}
