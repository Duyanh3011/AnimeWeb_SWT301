package control;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dal.FavoritesDAO;
import dal.VideoDAO;
import model.Favorites;
import model.Users;
import model.Video;

@WebServlet({"/like"})
public class LikeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Users user = (Users) request.getSession().getAttribute("account");
        String id = request.getParameter("id");
        String act = request.getParameter("act");

        if (act.equals("add")) {
            Video video = new VideoDAO().findByID(id);
            Favorites favorite = new Favorites(user.getId(), video.getId());
            FavoritesDAO fd = new FavoritesDAO();
            try {
                fd.insert(favorite);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        } else if (act.equals("remove")) {
            Video video = new VideoDAO().findByID(id);
            FavoritesDAO fd = new FavoritesDAO();
            int favoriteId = fd.findByUserAndVideo(user.getId(), video.getId());
            fd.delete(favoriteId);
          
        }
        
        String reload = "detail?id="+id;
        
        response.sendRedirect(reload);

    }
}

