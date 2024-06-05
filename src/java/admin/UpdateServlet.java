
package admin;

import dal.GenreDao;
import dal.StudioDao;
import dal.VideoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Genre;
import model.Studio;
import model.Video;

/**
 *
 * @author DuyAnhComputer
 */
@WebServlet(name="UpdateServlet", urlPatterns={"/update"})
public class UpdateServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AddServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath () + "</h1>");
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
        String id = request.getParameter("id");

        VideoDAO vd = new VideoDAO();
        GenreDao ge = new GenreDao();
        StudioDao sd = new StudioDao();

        try {
                List<Genre> genre = ge.getAll();
                request.setAttribute("genre", genre);
                List<Studio> studio = sd.getAll();
                request.setAttribute("studio", studio);
                Video video = vd.findByID(id);
                request.setAttribute("video", video);
//                request.getRequestDispatcher("test.jsp").forward(request, response);

        } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
                request.setAttribute("error", e.getMessage());
        }
        request.getRequestDispatcher("admin/update.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String poster = request.getParameter("poster");
        String Rviews = request.getParameter("views");
        String description = request.getParameter("description");
        String link = request.getParameter("link");
        String Ryear = request.getParameter("year");
        String RseleGenre = request.getParameter("seleGenre");
        String ReleStudio = request.getParameter("seleStudio");
        
        VideoDAO vd = new VideoDAO();
        
        try {
            int views = Integer.parseInt(Rviews);
            int year = Integer.parseInt(Ryear);
            int genre = Integer.parseInt(RseleGenre);
            int studio = Integer.parseInt(ReleStudio);
            Video v = new Video(id, title, poster, views, description, link, year, genre, studio);
            vd.update(v);
            
//            request.setAttribute("v", v);
            request.setAttribute("mes", "Updated successful!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("home");
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
