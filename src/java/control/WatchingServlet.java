
package control;

import dal.FavoritesDAO;
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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Genre;
import model.Studio;
import model.Users;
import model.Video;

/**
 *
 * @author DuyAnhComputer
 */
@WebServlet(name="WatchingServlet", urlPatterns={"/watch"})
public class WatchingServlet extends HttpServlet {
   
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
            out.println("<title>Servlet WatchingServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WatchingServlet at " + request.getContextPath () + "</h1>");
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
        String videoId = request.getParameter("id");

        if (videoId != null) {
            try {
                VideoDAO vd = new VideoDAO();
                Video video = vd.findByID(videoId);

                List<Genre> genre = new GenreDao().getAll();
                List<Studio> studio = new StudioDao().getAll();

                    video.setViews(video.getViews() + 1);
                    vd.update(video);
                                   
                request.setAttribute("video", video);
                request.setAttribute("genre", genre);
                request.setAttribute("studio", studio);

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", e.getMessage());

            }
//                request.getRequestDispatcher("test.jsp").forward(request, response);

            request.getRequestDispatcher("watching.jsp").forward(request, response);

        } else {
            response.sendRedirect("home");
        }
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
