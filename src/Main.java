public class Main {
    public static void main(String[] args) {

        Film customFilm = new FilmBuilder()
                .setTitle("Interstellar")
                .setGenre("Science Fiction")
                .setDirector("Christopher Nolan")
                .setDuration(169)
                .setReleaseYear(2014)
                .setSubtitles(true)
                .build();

        System.out.println("Custom film:");
        System.out.println(customFilm);

        System.out.println();

        FilmDirector filmDirector = new FilmDirector();

        Film shortFilm = filmDirector.createShortFilm();
        Film actionFilm = filmDirector.createActionFilm();
        Film documentary = filmDirector.createDocumentary();

        System.out.println("Films created by Director:");
        System.out.println(shortFilm);
        System.out.println(actionFilm);
        System.out.println(documentary);
    }
}
