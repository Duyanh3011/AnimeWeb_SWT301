
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
@WebServlet(name="PasswordServlet", urlPatterns={"/password"})
public class PasswordServlet extends HttpServlet {
   
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
            out.println("<title>Servlet PasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PasswordServlet at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        String Opassword = request.getParameter("Opass");
            
        UserDAO sd = new UserDAO();             
        try {
            Users ad = sd.checkUserPass(username, Opassword);
            if(ad ==null){
                request.setAttribute("err", "Password is incorrect");
            }else if(!password.equals(Cpassword)){
                request.setAttribute("err1", "Password is not matching");
            }else{
                sd.update(username, password);
                HttpSession session = request.getSession();
                session.setAttribute("account", new UserDAO().checkUser(username));
                request.setAttribute("mes", "Change password successful!!!");

            }            
        } catch (Exception e) {
            System.out.println(e);
        }  
        HttpSession session = request.getSession();
        Users u = (Users)session.getAttribute("account");
        request.getRequestDispatcher("profile.jsp").forward(request, response);

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
