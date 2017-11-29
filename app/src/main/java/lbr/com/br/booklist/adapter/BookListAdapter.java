package lbr.com.br.booklist.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.List;

import butterknife.OnItemClick;
import lbr.com.br.booklist.entity.Book;
import lbr.com.br.booklist.helper.FormHelper;
import lbr.com.br.booklist.viewHolder.BookListViewHolder;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.model.BookListDAO;
import lbr.com.br.booklist.views.FormBookActivity;
import lbr.com.br.booklist.views.MainActivity;

/**
 * Created by Leandro on 24/11/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListViewHolder> {

    private MainActivity activity;

    private List<Book> books;

    private FormHelper helper;


    public BookListAdapter(List<Book> books, MainActivity activity) {
        this.activity = activity;
        this.books = books;
        this.helper = helper;
    }


    @Override
    public BookListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new BookListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {
        final Book book = books.get(position);
        holder.mNametext.setText(book.getNameBook());
        holder.mNumberText.setText(book.getNumberPages().toString());

        Bitmap bitmap;

        if (book.getPhotoPath() != null) {
            bitmap = BitmapFactory.decodeFile(book.getPhotoPath());
            bitmap = Bitmap.createScaledBitmap(bitmap, 56, 56, true);
        } else {
            bitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_book);
        }

        holder.mImageView.setImageBitmap(bitmap);

        holder.mLayoutItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity.deleteItemList(book);
                Toast.makeText(activity, "teste", Toast.LENGTH_LONG).show();

            }
        });

        holder.mLayoutItemList.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // activity.alterItemList(book);
                Toast.makeText(activity, "teste longo", Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }


}
