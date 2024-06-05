package model;

import java.util.Date;
import java.util.List;

public class Favorites {

    private int id;
    private String userId;
    private String videoId;

    public Favorites() {
        super();
    }

    public Favorites(String userId, String videoId) {
        this.userId = userId;
        this.videoId = videoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Favorites{" + "id=" + id + ", userId=" + userId + ", videoId=" + videoId + '}';
    }
    
    
}
