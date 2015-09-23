package baasj005.ivmd.flicklist.models;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Jesse on 17-9-2015.
 */
public class MovieListItem implements Serializable {

    private long Id;
    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String Type;
    private String Response;
    private Bitmap posterThumbnail;

    public MovieListItem(String title, String year, String rated, String released, String runtime,
                         String genre, String director, String writer, String actors, String plot,
                         String language, String country, String awards, String poster, String metascore,
                         String imdbRating, String imdbVotes, String imdbID, String type, String response) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Plot = plot;
        Language = language;
        Country = country;
        Awards = awards;
        Poster = poster;
        Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        Type = type;
        Response = response;
        this.posterThumbnail = null;
    }

    public MovieListItem(){
        Title = null;
        Year = null;
        Rated = null;
        Released = null;
        Runtime = null;
        Genre = null;
        Director = null;
        Writer = null;
        Actors = null;
        Plot = null;
        Language = null;
        Country = null;
        Awards = null;
        Poster = null;
        Metascore = null;
        this.imdbRating = null;
        this.imdbVotes = null;
        this.imdbID = null;
        Type = null;
        Response = null;
        posterThumbnail = null;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public Bitmap getPosterThumbnail() {
        return posterThumbnail;
    }

    public void setPosterThumbnail(Bitmap posterThumbnail) {
        this.posterThumbnail = posterThumbnail;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
