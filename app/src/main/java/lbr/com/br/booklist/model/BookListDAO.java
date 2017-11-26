package lbr.com.br.booklist.model;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lbr.com.br.booklist.R;

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

    private  static final  String TABELA = "Books";
    private  static final int VERSAO = 1;

    public BookListDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BookListDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
