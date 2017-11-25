package lbr.com.br.booklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BookListContract.View{

    @BindView(R.id.recycler_view_id)
    public RecyclerView mRecyclerView;

    private BookListContract.View view;

    private BookListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        this.presenter = new BookListPresenter(this, this);

        setRecyclerView();

    }

    private void setRecyclerView() {

        BookListAdapter bookListAdapter = new BookListAdapter(this);
        mRecyclerView.setAdapter(bookListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }
}
