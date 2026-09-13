public class Film {
    private final String title;
    private final String genre;
    private final String director;
    private final int duration;
    private final int releaseYear;
    private final boolean subtitles;

    public Film(String title, String genre, String director,
                int duration, int releaseYear, boolean subtitles) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.subtitles = subtitles;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration + " minutes" +
                ", releaseYear=" + releaseYear +
                ", subtitles=" + subtitles +
                '}';
    }
}