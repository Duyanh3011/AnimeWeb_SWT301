package control;

import dal.FavoritesDAO;
import dal.GenreDao;
import dal.StudioDao;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dal.VideoDAO;
import jakarta.servlet.http.HttpSession;
import model.Favorites;
import model.Genre;
import model.Studio;
import model.Users;
import model.Video;

@WebServlet("/detail")
public class DetailVideoServlet extends HttpServlet {

//    static Video check;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String videoId = request.getParameter("id");
                
               
		if (videoId != null) {
                    try {
                        VideoDAO vd = new VideoDAO();
                        
                        Video video = vd.findByID(videoId);                       
                        List<Video> sameGen = vd.findByGenre(video.getGenreId());
                        List<Video> sameStu = vd.findByStudio(video.getStudioId());
                        
                        List<Genre> genre = new GenreDao().getAll();
                        List<Studio> studio = new StudioDao().getAll();
                    
//				video.setViews(video.getViews() + 1);
//				vd.update(video);

                        request.setAttribute("video", video);
                        request.setAttribute("genre", genre);
                        request.setAttribute("studio", studio);
                        request.setAttribute("VidGen", sameGen);
                        request.setAttribute("VidStu", sameStu);
                        
                        int fav;
                        HttpSession session = request.getSession();
                        if (session.getAttribute("account") != null) {
                            Users u = (Users) session.getAttribute("account");
                            fav = new FavoritesDAO().findByUserAndVideo(u.getId(), videoId);
                            if(fav != -1)
                            request.setAttribute("fav", fav);
                        }
                        

                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("error", e.getMessage());

                    }
//                request.getRequestDispatcher("test.jsp").forward(request, response);

                    request.getRequestDispatcher("details.jsp").forward(request, response);

                } else {
                    response.sendRedirect("home");
                }
	}
//
//    public static void main(String[] args) {
//        System.out.println(check.getTitle());
//    }
}
