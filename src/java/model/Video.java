package model;

import java.util.List;
import java.lang.String;

public class Video {

    private String id;
    private String title;
    private String poster;
    private int views;
    private String description;
    private String link;
    private int year;
    private int genreId;
    private int studioId;
    

//	private List<Share> shares;
    private List<Favorites> favorites;
//	
//	

    public List<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
    }
//
//	public List<Share> getShares() {
//		return shares;
//	}
//
//	public void setShares(List<Share> shares) {
//		this.shares = shares;
//	}

    public Video(String id, String title, String poster, int views, String description, String link, int year, int genreId, int studioId) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.description = description;
        this.link = link;
        this.year = year;
        this.genreId = genreId;
        this.studioId = studioId;
    }





    public Video() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

 
}
