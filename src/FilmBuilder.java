public class FilmBuilder {
    private String title;
    private String genre;
    private String director;
    private int duration;
    private int releaseYear;
    private boolean subtitles;

    public FilmBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public FilmBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public FilmBuilder setDirector(String director) {
        this.director = director;
        return this;
    }

    public FilmBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public FilmBuilder setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public FilmBuilder setSubtitles(boolean subtitles) {
        this.subtitles = subtitles;
        return this;
    }

    public Film build() {
        validate();

        return new Film(
                title,
                genre,
                director,
                duration,
                releaseYear,
                subtitles
        );
    }

    private void validate() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Film title cannot be empty");
        }

        if (genre == null || genre.isBlank()) {
            throw new IllegalStateException("Film genre cannot be empty");
        }

        if (duration <= 0) {
            throw new IllegalStateException("Film duration must be greater than 0");
        }

        if (releaseYear <= 0) {
            throw new IllegalStateException("Release year must be greater than 0");
        }
    }
}