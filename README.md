# Film Builder Pattern

## Assignment #1 — Builder Pattern

**Course:** Software Design Patterns
**Language:** Java
**Topic:** Film

## Project Description

This project demonstrates the **Builder Creational Design Pattern** using a `Film` as the product.

A film can have multiple properties such as:

* title
* genre
* director
* duration
* release year
* subtitles

The Builder Pattern allows a `Film` object to be created step by step instead of passing all values directly to a long constructor.

## Project Structure

The project contains four main classes:

* `Film` — Product
* `FilmBuilder` — Builder
* `FilmDirector` — Director
* `Main` — Client

## Builder Pattern

### Product — Film

`Film` represents the complex object that is being constructed. It stores all information about a film.

### Builder — FilmBuilder

`FilmBuilder` is responsible for constructing a `Film` step by step.

It uses a fluent API, which allows method chaining:

```java
Film film = new FilmBuilder()
        .setTitle("Interstellar")
        .setGenre("Science Fiction")
        .setDirector("Christopher Nolan")
        .setDuration(169)
        .setReleaseYear(2014)
        .setSubtitles(true)
        .build();
```

Each setter returns the same builder object using `return this`, which makes method chaining possible.

### Director — FilmDirector

`FilmDirector` contains predefined and reusable film configurations.

For example:

```java
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
```

The Director demonstrates how the same Builder can create different representations of a `Film`.

### Client — Main

The `Main` class acts as the Client. It creates films directly through `FilmBuilder` and also uses `FilmDirector` to create predefined films.

---

# Clean Code Principles

## 1. Meaningful Names

Names should clearly describe the purpose of variables and methods.

### Before

```java
public FilmBuilder setD(int d) {
    this.duration = d;
    return this;
}
```

### After

```java
public FilmBuilder setDuration(int duration) {
    this.duration = duration;
    return this;
}
```

`setDuration` and `duration` clearly explain what the method and variable represent.

---

## 2. Small Methods

Methods should perform one clear task.

### Before

```java
public Film build() {
    if (title == null || title.isBlank()) {
        throw new IllegalStateException("Film title cannot be empty");
    }

    if (duration <= 0) {
        throw new IllegalStateException("Film duration must be greater than 0");
    }

    return new Film(title, genre, director, duration, releaseYear, subtitles);
}
```

### After

```java
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
```

Validation is moved to the separate `validate()` method. Therefore, `build()` focuses on building the object.

---

## 3. Validated Construction

The Builder checks the data before creating a `Film`.

### Before

```java
return new Film(title, genre, director, duration, releaseYear, subtitles);
```

This could create a film with invalid data.

### After

```java
if (title == null || title.isBlank()) {
    throw new IllegalStateException("Film title cannot be empty");
}

if (duration <= 0) {
    throw new IllegalStateException("Film duration must be greater than 0");
}
```

Invalid films cannot be created through the Builder.

---

## 4. Consistent Formatting

Code should have consistent formatting to improve readability.

### Before

```java
Film film=new FilmBuilder().setTitle("Interstellar").setGenre("Science Fiction").setDuration(169).build();
```

### After

```java
Film film = new FilmBuilder()
        .setTitle("Interstellar")
        .setGenre("Science Fiction")
        .setDuration(169)
        .build();
```

The formatted version makes every construction step easy to see and understand.

---

## 5. Small and Focused Classes

Each class has one main responsibility.

### Before

All responsibilities could be placed inside one large class:

```java
class FilmSystem {
    // Film data
    // Film construction
    // Predefined configurations
    // Program execution
}
```

### After

The responsibilities are separated:

```text
Film         -> stores film data
FilmBuilder  -> constructs Film objects
FilmDirector -> defines reusable configurations
Main         -> runs and tests the program
```

This separation makes the project easier to understand, modify, and maintain.

---

## Why Use Builder?

Without Builder, creating a film with many parameters can be difficult to read:

```java
Film film = new Film(
        "Interstellar",
        "Science Fiction",
        "Christopher Nolan",
        169,
        2014,
        true
);
```

With Builder, every value has a clear meaning:

```java
Film film = new FilmBuilder()
        .setTitle("Interstellar")
        .setGenre("Science Fiction")
        .setDirector("Christopher Nolan")
        .setDuration(169)
        .setReleaseYear(2014)
        .setSubtitles(true)
        .build();
```

The Builder version is more readable, flexible, and convenient when different Film configurations need to be created.

## Conclusion

The project demonstrates the Builder Design Pattern with a `Film` product. `FilmBuilder` provides step-by-step construction and a fluent API, while `FilmDirector` provides reusable predefined configurations.

The implementation also follows Clean Code principles such as meaningful names, small methods, validated construction, consistent formatting, and small focused classes.
