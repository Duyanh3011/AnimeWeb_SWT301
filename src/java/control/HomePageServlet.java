package control;

import dal.GenreDao;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dal.VideoDAO;
import model.Favorites;
import model.Genre;
import model.Users;
import model.Video;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String page = request.getParameter("page") == null ? "1" : request.getParameter("page");
		VideoDAO vd = new VideoDAO();
                GenreDao ge = new GenreDao();
		try {
			List<Video> videos = vd.findPage((Integer.parseInt(page)-1) * 6);
			List<Video> videoNew = vd.getTop3Year();
			List<Video> videoView = vd.mostViewVideo();
                        
                        
			request.setAttribute("videos", videos);
			request.setAttribute("videoNew", videoNew);
			request.setAttribute("videoView", videoView);
			request.setAttribute("numPage", (vd.getAll().size()%6==0)?(vd.getAll().size()/6):(vd.getAll().size()/6)+1);
			request.setAttribute("page", page);
                        
                        List<Genre> genre = ge.getAll();
                        request.setAttribute("genre", genre);
//                request.getRequestDispatcher("test.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
                        System.out.println(e);
			request.setAttribute("error", e.getMessage());
		}
                request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String title = request.getParameter("title");
//		VideoDAO vd = new VideoDAO();
//		List<Video> videos = vd.query(title);
//
//		request.setAttribute("videos", videos);
//		request.setAttribute("size", Math.ceil(vd.getAll().size() / 10.0));
//		request.getRequestDispatcher("views/home.jsp").forward(request, response);
	}
        

}
