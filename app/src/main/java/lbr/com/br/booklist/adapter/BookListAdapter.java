package lbr.com.br.booklist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lbr.com.br.booklist.viewHolder.BookListViewHolder;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.model.BookListDAO;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new BookListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {
        holder.mImageView.setImageResource(BookListDAO.image[position]);
        holder.mNametext.setText(BookListDAO.title[position]);
        holder.mNumberText.setText(Integer.toString(BookListDAO.pages[position]));
    }

    @Override
    public int getItemCount() {
        return BookListDAO.title.length;
    }
}
