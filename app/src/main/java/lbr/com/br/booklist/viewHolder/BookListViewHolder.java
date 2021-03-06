package lbr.com.br.booklist.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lbr.com.br.booklist.R;

/**
 * Created by Leandro on 24/11/2017.
 */

public class BookListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.layout_item_list_id)
    public LinearLayout mLayoutItemList;

    @BindView(R.id.image_view_photo_id)
    public ImageView mImageView;

    @BindView(R.id.text_view_name_id)
    public TextView mNametext;

    @BindView(R.id.text_view_number_id)
    public TextView mNumberText;

    public BookListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
