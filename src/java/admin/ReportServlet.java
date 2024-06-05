
package admin;

import dal.GenreDao;
import dal.StudioDao;
import dal.UserDAO;
import dal.VideoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Users;

/**
 *
 * @author DuyAnhComputer
 */
@WebServlet(name="ReportServlet", urlPatterns={"/report"})
public class ReportServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ReportServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportServlet at " + request.getContextPath () + "</h1>");
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
        UserDAO ud = new UserDAO();
        VideoDAO vd = new VideoDAO();
        GenreDao gd = new GenreDao();
        StudioDao sd = new StudioDao();
        try {
            List<Users> users = ud.getAll();
            request.setAttribute("users", users);

            int totalView = vd.totalView();
            request.setAttribute("totalView", totalView);
            int avgView = vd.avgView();
            request.setAttribute("avgView", avgView);
            int fav = vd.mostFavorite();
            request.setAttribute("fav", fav);
            String favT  = vd.mostFavoriteTitle();
            request.setAttribute("favT", favT);
          
          
            int gen =  gd.mostGenre();
            request.setAttribute("gen", gen);
            String genN  = gd.mostGenreName();
            request.setAttribute("genN", genN);
          
            
            int stu =  sd.mostStudio();
            request.setAttribute("stu", stu);
            String stuN  = sd.mostStudioName();
            request.setAttribute("stuN", stuN);
            
            int user = ud.totalUsers();
            request.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            request.setAttribute("error", e.getMessage());
        }
        request.getRequestDispatcher("admin/report_ad.jsp").forward(request, response);    
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
        processRequest(request, response);
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
