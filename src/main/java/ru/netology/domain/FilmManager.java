package ru.netology.domain;

public class FilmManager {
    private int currentCountFilm = 10;

    private PurchaseItem[] items = new PurchaseItem[0];

    public FilmManager(int currentCountFilm) {
          this.currentCountFilm = currentCountFilm;
    }

    public FilmManager() {
    }

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public PurchaseItem[] getAll() {

        int resultLength;
         if (currentCountFilm < 10) {
             resultLength = currentCountFilm;
         }
         else {
             resultLength = 10;
         }
        PurchaseItem[] result = new PurchaseItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }



}


