package lbr.com.br.booklist;

import android.content.Context;

/**
 * Created by Leandro on 24/11/2017.
 */

public class BookListPresenter implements BookListContract.Presenter{

    private Context context;

    private BookListContract.View view;

    public BookListPresenter(Context context, BookListContract.View view) {
        this.context = context;
        this.view = view;
    }


}
