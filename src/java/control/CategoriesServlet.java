
package control;

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
@WebServlet(name="CategoriesServlet", urlPatterns={"/categories"})
public class CategoriesServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CategoriesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriesServlet at " + request.getContextPath () + "</h1>");
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
        String page = request.getParameter("page") == null ? "1" : request.getParameter("page");
        String search = request.getParameter("search");
            VideoDAO vd = new VideoDAO();
            GenreDao ge = new GenreDao();
            StudioDao sd = new StudioDao();

                try {
                     List<Video> videos;
                    if(search == null){
                        videos = vd.findPage((Integer.parseInt(page)-1) * 6);
                        request.setAttribute("numPage", (vd.getAll().size()/6)+1);
                        request.setAttribute("page", page);
                    }else
                        videos = vd.getByTitle(search);

                    List<Video> videoView = vd.mostViewVideo();

                    request.setAttribute("videos", videos);
                    
                    
                    
                    request.setAttribute("videoView", videoView);

                    List<Genre> genre = ge.getAll();
                    request.setAttribute("genre", genre);
                    List<Studio> studio = sd.getAll();
                    request.setAttribute("studio", studio);

                    request.setAttribute("gid", "0");
                    request.setAttribute("std", "0");
                    request.setAttribute("order", "0");
//                request.getRequestDispatcher("test.jsp").forward(request, response);

            } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                    request.setAttribute("error", e.getMessage());
            }
            request.getRequestDispatcher("categories.jsp").forward(request, response);
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
                String page = request.getParameter("page") == null ? "1" : request.getParameter("page");
                String seleGenre = request.getParameter("seleGenre");
                String seleStudio = request.getParameter("seleStudio");
                String order = request.getParameter("order");
                if(order.equals(0)) order = "1-10";

                
		VideoDAO vd = new VideoDAO();
                GenreDao ge = new GenreDao();
                StudioDao sd = new StudioDao();
		try {
			List<Video> videos = vd.categoriesVideo(seleGenre, seleStudio, order);
                        List<Video> videoView = vd.mostViewVideo();

			request.setAttribute("videos", videos);
			request.setAttribute("videoView", videoView);

                    //Paging
			request.setAttribute("numPage", 1);
			request.setAttribute("page", 1);
                        
                    //Genre, Studio
                        List<Genre> genre = ge.getAll();
                        request.setAttribute("genre", genre);
                        List<Studio> studio = sd.getAll();
                        request.setAttribute("studio", studio);
                 
                    //set search
                        request.setAttribute("gid", seleGenre);
                        request.setAttribute("seleStudio", seleStudio);
                        request.setAttribute("order", order);

		} catch (Exception e) {
			e.printStackTrace();
                        System.out.println(e);
			request.setAttribute("error", e.getMessage());
		}
//                request.getRequestDispatcher("test.jsp").forward(request, response);

        request.getRequestDispatcher("categories.jsp").forward(request, response);
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
