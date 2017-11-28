package lbr.com.br.booklist.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.adapter.BookListAdapter;
import lbr.com.br.booklist.contract.BookListContract;
import lbr.com.br.booklist.entity.Book;
import lbr.com.br.booklist.model.BookListDAO;
import lbr.com.br.booklist.presenter.BookListPresenter;

public class MainActivity extends AppCompatActivity implements BookListContract.View {

    @BindView(R.id.recycler_view_id)
    public RecyclerView mRecyclerView;

    @BindView(R.id.button_add_id)
    public FloatingActionButton mButton;

    private BookListContract.View view;

    private BookListContract.Presenter presenter;

    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        this.presenter = new BookListPresenter(this, this);

        setRecyclerView();

        /*
        BookListDAO bookListDAO = new BookListDAO(this);
        books = bookListDAO.getListValue();
        bookListDAO.close();

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, books);
*/
    }

    private void setRecyclerView() {

        BookListDAO bookListDAO = new BookListDAO(this);
        books = bookListDAO.getListValue();
        bookListDAO.close();

        BookListAdapter bookListAdapter = new BookListAdapter(books, this);
        mRecyclerView.setAdapter(bookListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        registerForContextMenu(mRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadList();
    }

    private void loadList() {
        BookListDAO bookListDAO = new BookListDAO(this);
        books = bookListDAO.getListValue();
        bookListDAO.close();

        this.setRecyclerView();

        BookListAdapter bookListAdapter = new BookListAdapter(books, this);
    }

    @OnClick(R.id.button_add_id)
    public void addBookList() {
        Intent intent = new Intent(MainActivity.this, FormBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Adicionar novo livro", Toast.LENGTH_SHORT).show();
    }


}
