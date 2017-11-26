package lbr.com.br.booklist.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lbr.com.br.booklist.contract.BookListContract;
import lbr.com.br.booklist.presenter.BookListPresenter;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.adapter.BookListAdapter;

public class MainActivity extends AppCompatActivity implements BookListContract.View {

    @BindView(R.id.recycler_view_id)
    public RecyclerView mRecyclerView;

    @BindView(R.id.button_add_id)
    public FloatingActionButton mButton;

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

    @OnClick(R.id.button_add_id)
    public void addBookList()
    {
        Intent intent = new Intent(MainActivity.this, FormBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Adicionar novo livro", Toast.LENGTH_LONG).show();
    }
}
