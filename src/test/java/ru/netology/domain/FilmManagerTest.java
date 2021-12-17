package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerTest {
    private FilmManager filmManager = new FilmManager();
    private FilmItem avengers = new FilmItem(1, "Avengers", "imageAven", "adventure");
    private FilmItem frozen = new FilmItem(2, "Frozen", "imageSnow", "cartoon");
    private FilmItem sing = new FilmItem(3, "Sing", "imageSing", "cartoon");
    private FilmItem hangover = new FilmItem(4, "Hangover", "imageHangover", "comedy");
    private FilmItem theEnd = new FilmItem(5, "TheEnd", "imageTheEnd", "comedy");
    private FilmItem intouchables = new FilmItem(6, "Intouchables", "image1", "drama");
    private FilmItem safeHouse = new FilmItem(7, "SafeHouse", "imageSaveHouse", "action");
    private FilmItem lost = new FilmItem(8, "Lost", "imageLost", "thriller");
    private FilmItem blitz = new FilmItem(9, "Blitz", "imageLost", "thriller");
    private FilmItem help = new FilmItem(10, "Help", "imageHelp", "drama");
    private FilmItem cash = new FilmItem(11, "Cash", "imageCash", "thriller");

    @Test
    public void shouldAddFilmEmpty() {
        FilmItem[] actual = filmManager.findAll();
        FilmItem[] expected = new FilmItem[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddOneFilm() {
        filmManager.add(sing);
        FilmItem[] actual = filmManager.findAll();
        FilmItem[] expected = new FilmItem[]{sing};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldLastAddFilmNoOne() {
        FilmManager filmManager = new FilmManager(0);
        filmManager.getAll();
        FilmItem[] actual = filmManager.getAll();
        FilmItem[] expected = new FilmItem[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldLastAddFilmOne() {
        FilmManager filmManager = new FilmManager(1);
        filmManager.add(avengers);
        filmManager.getAll();
        FilmItem[] actual = filmManager.getAll();
        FilmItem[] expected = new FilmItem[]{avengers};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldTenLastAddFilm() {
        filmManager.add(frozen);
        filmManager.add(hangover);
        filmManager.add(sing);
        filmManager.add(theEnd);
        filmManager.add(intouchables);
        filmManager.add(help);
        filmManager.add(cash);
        filmManager.add(blitz);
        filmManager.add(avengers);
        filmManager.add(safeHouse);
        filmManager.getAll();
        FilmItem[] actual = filmManager.getAll();
        FilmItem[] expected = new FilmItem[]{
                safeHouse,avengers, blitz, cash, help, intouchables, theEnd, sing, hangover, frozen
        };
        assertArrayEquals(actual, expected);
    }


    @Test
    public void shouldTenLastAddFilmInLimit() {
        FilmManager filmManager = new FilmManager(9);
        filmManager.add(frozen);
        filmManager.add(hangover);
        filmManager.add(sing);
        filmManager.add(safeHouse);
        filmManager.add(intouchables);
        filmManager.add(cash);
        filmManager.add(blitz);
        filmManager.add(avengers);
        filmManager.add(safeHouse);
        filmManager.getAll();
        FilmItem[] actual = filmManager.getAll();
        FilmItem[] expected = new FilmItem[]{
                safeHouse,avengers, blitz, cash, intouchables, safeHouse, sing, hangover, frozen
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldTenLastAddFilmNotLimit() {
        FilmManager filmManager = new FilmManager(11);
        filmManager.add(frozen);
        filmManager.add(hangover);
        filmManager.add(sing);
        filmManager.add(safeHouse);
        filmManager.add(intouchables);
        filmManager.add(cash);
        filmManager.add(blitz);
        filmManager.add(avengers);
        filmManager.add(safeHouse);
        filmManager.add(help);
        filmManager.add(theEnd);
        filmManager.getAll();
        FilmItem[] actual = filmManager.getAll();
        FilmItem[] expected = new FilmItem[]{
                theEnd, help, safeHouse, avengers, blitz, cash, intouchables, safeHouse, sing, hangover
        };
        assertArrayEquals(actual, expected);
    }
}