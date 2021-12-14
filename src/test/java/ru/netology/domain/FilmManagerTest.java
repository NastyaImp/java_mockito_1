package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerTest {
    private FilmManager filmManager = new FilmManager();
    private PurchaseItem avengers = new PurchaseItem(1, "Avengers", "imageAven", "adventure");
    private PurchaseItem frozen = new PurchaseItem(2, "Frozen", "imageSnow", "cartoon");
    private PurchaseItem sing = new PurchaseItem(3, "Sing", "imageSing", "cartoon");
    private PurchaseItem hangover = new PurchaseItem(4, "Hangover", "imageHangover", "comedy");
    private PurchaseItem theEnd = new PurchaseItem(5, "TheEnd", "imageTheEnd", "comedy");
    private PurchaseItem intouchables = new PurchaseItem(6, "Intouchables", "image1", "drama");
    private PurchaseItem safeHouse = new PurchaseItem(7, "SafeHouse", "imageSaveHouse", "action");
    private PurchaseItem lost = new PurchaseItem(8, "Lost", "imageLost", "thriller");
    private PurchaseItem blitz = new PurchaseItem(9, "Blitz", "imageLost", "thriller");
    private PurchaseItem help = new PurchaseItem(10, "Help", "imageHelp", "drama");
    private PurchaseItem cash = new PurchaseItem(11, "Cash", "imageCash", "thriller");

    @Test
    public void shouldAddFilmEmpty() {
        PurchaseItem[] actual = filmManager.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddOneFilm() {
        filmManager.add(sing);
        PurchaseItem[] actual = filmManager.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{sing};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldLastAddFilmNoOne() {
        FilmManager filmManager = new FilmManager(0);
        filmManager.getAll();
        PurchaseItem[] actual = filmManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldLastAddFilmOne() {
        FilmManager filmManager = new FilmManager(1);
        filmManager.add(avengers);
        filmManager.getAll();
        PurchaseItem[] actual = filmManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{avengers};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldTenLastAddFilm() {
       // FilmManager filmManager = new FilmManager(10);
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
        PurchaseItem[] actual = filmManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{
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
        PurchaseItem[] actual = filmManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{
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
        PurchaseItem[] actual = filmManager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{
                theEnd, help, safeHouse, avengers, blitz, cash, intouchables, safeHouse, sing, hangover
        };
        assertArrayEquals(actual, expected);
    }
}