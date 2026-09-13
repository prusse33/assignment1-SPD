public class FilmDirector {

    public Film createShortFilm() {
        return new FilmBuilder()
                .setTitle("The Silent Room")
                .setGenre("Drama")
                .setDirector("Alex Smith")
                .setDuration(25)
                .setReleaseYear(2026)
                .setSubtitles(true)
                .build();
    }

    public Film createActionFilm() {
        return new FilmBuilder()
                .setTitle("Final Mission")
                .setGenre("Action")
                .setDirector("John Miller")
                .setDuration(130)
                .setReleaseYear(2026)
                .setSubtitles(false)
                .build();
    }

    public Film createDocumentary() {
        return new FilmBuilder()
                .setTitle("Planet Earth")
                .setGenre("Documentary")
                .setDirector("David Brown")
                .setDuration(90)
                .setReleaseYear(2025)
                .setSubtitles(true)
                .build();
    }
}