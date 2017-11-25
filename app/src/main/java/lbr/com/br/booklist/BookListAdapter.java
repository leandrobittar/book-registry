package lbr.com.br.booklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Leandro on 24/11/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListViewHolder>{
    private Context context;

    public BookListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BookListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
