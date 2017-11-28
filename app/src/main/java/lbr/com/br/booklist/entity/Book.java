package lbr.com.br.booklist.entity;

import java.io.Serializable;

/**
 * Created by Leandro on 26/11/2017.
 */

public class Book implements Serializable{

    private Long id;
    private String nameBook;
    private Integer numberPages;
    private String photoPath;

    @Override
    public String toString() {
        return this.id + " - " + this.nameBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer  getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
