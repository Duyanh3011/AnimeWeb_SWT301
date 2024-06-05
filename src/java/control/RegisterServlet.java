
package control;

import dal.UserDAO;
import model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyAnhComputer
 */
@WebServlet(name="Register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("id");
        String password = request.getParameter("Npass");
        String Cpassword = request.getParameter("Cpass");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
            
        UserDAO sd = new UserDAO();            
        
        if(!password.equals(Cpassword)){
                request.setAttribute("err", "Password is not matching");
                request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
        try {
            Users ad = null;
            
            
            
            for (Users us : sd.getAll()) {
                if(us.getId().equals(username))
                    ad = us;
            }
            if(ad ==null){
                Users ad_new = new Users(username, password,email,fullname,false);
                sd.insert(ad_new);
                response.sendRedirect("login");
            }else{
                request.setAttribute("err", "Username: is existed!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
                    
        } catch (Exception e) {
            System.out.println(e);
        }  
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
