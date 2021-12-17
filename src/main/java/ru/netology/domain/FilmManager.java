package ru.netology.domain;

public class FilmManager {
    private int currentCountFilm = 10;
    private int limitCountFilm = 10;
    private FilmItem[] items = new FilmItem[0];

    public FilmManager(int currentCountFilm) {
          this.currentCountFilm = currentCountFilm;
    }

    public FilmManager() {
    }

    public void add(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] findAll() {
        return items;
    }

    public FilmItem[] getAll() {

        int resultLength;
         if (currentCountFilm >= 0 && currentCountFilm < limitCountFilm) {
             resultLength = currentCountFilm;
         }
         else {
             resultLength = limitCountFilm;
         }
        FilmItem[] result = new FilmItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}


