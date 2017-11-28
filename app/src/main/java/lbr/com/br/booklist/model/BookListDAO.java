package lbr.com.br.booklist.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import lbr.com.br.booklist.R;
import lbr.com.br.booklist.entity.Book;

/**
 * Created by Leandro on 24/11/2017.
 */

public class BookListDAO extends SQLiteOpenHelper {

    public static String[] title = new String[]{
            "Cronicas de hoje",
            "Biografia de alguém",
            "Piada nacional"

    };
    public static int[] pages = new int[]{
            10,
            200,
            10000
    };

    public static int[] image = new int[]{
            R.drawable.ic_book,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground
    };

    private static final String TABELA = "books";
    private static final int VERSAO = 1;

    public BookListDAO(Context context) {
        super(context, "db_book", null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase datebase) {
        String sql = "create table books (id Integer primary key, nameBook Text not null, numberPage Integer, pathPhoto Text); ";
        datebase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova) {
        //Temporary
        String sql = "drop table if exists " + TABELA;
        database.execSQL(sql);
        onCreate(database);
    }

    public void insertValue(Book book) {
        getReadableDatabase().insert(TABELA, null, this.getData(book));
    }

    public void deleteValue(Book book) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("books", "id = ?", new String[]{String.valueOf(book.getId())});
        database.close();
    }

    public void alterValue(Book book) {
        SQLiteDatabase database = getWritableDatabase();
        database.update("books", this.getData(book), "id = ?", new String[]{book.getId().toString()});
    }

    private ContentValues getData(Book book) {
        ContentValues values = new ContentValues();
        values.put("nameBook", book.getNameBook());
        values.put("numberPage", book.getNumberPages());
        values.put("pathPhoto", book.getPhotoPath());
        return values;
    }

    public List<Book> getListValue() {
        List<Book> books = new ArrayList<Book>();

        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from " + TABELA + ";", null);

        while (cursor.moveToNext()) {
            Book book =  new Book();
            book.setId(cursor.getLong(cursor.getColumnIndex("id")));
            book.setNameBook(cursor.getString(cursor.getColumnIndex("nameBook")));
            book.setNumberPages(cursor.getInt(cursor.getColumnIndex("numberPage")));
            book.setPhotoPath(cursor.getString(cursor.getColumnIndex("pathPhoto")));
            books.add(book);
        }
        cursor.close();
        return books;
    }
}
