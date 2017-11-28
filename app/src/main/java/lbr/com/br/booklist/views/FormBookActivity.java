package lbr.com.br.booklist.views;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.contract.FormBookContract;
import lbr.com.br.booklist.entity.Book;
import lbr.com.br.booklist.helper.FormHelper;
import lbr.com.br.booklist.model.BookListDAO;
import lbr.com.br.booklist.presenter.FormBookPresenter;

public class FormBookActivity extends AppCompatActivity implements FormBookContract.View {

    @BindView(R.id.button_get_photo_id)
    public FloatingActionButton mButton;

    private FormBookContract.View view;

    private FormBookContract.Presenter presenter;

    private FormHelper helper;

    private String photoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_book);
        ButterKnife.bind(this);

        this.presenter = new FormBookPresenter(this, this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.helper = new FormHelper(this);

        Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra("book");
        if (book != null) {
            helper.loadBookForm(book);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_form_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_btn_salvar:
                if (helper.isValidName()) {

                    BookListDAO bookListDAO = new BookListDAO(this);

                    Book book = helper.getBookForm();
                    if (book.getId() != null) {
                        bookListDAO.alterValue(helper.getBookForm());
                    } else {
                        bookListDAO.insertValue(helper.getBookForm());
                    }
                    bookListDAO.close();

                    String nameBook = helper.getBookForm().getNameBook();
                    Toast.makeText(FormBookActivity.this, nameBook, Toast.LENGTH_SHORT).show();
                    finish();
                    return true;
                } else {
                    helper.showError();
                }

            default:
                return true;
        }
    }

    @OnClick(R.id.button_get_photo_id)
    public void addPhoto() {


        photoPath = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        File file = new File(photoPath);
        Uri localPhoto = Uri.fromFile(file);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, localPhoto);
        startActivityForResult(intent, 12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12){
            if (resultCode == RESULT_OK){

                helper.loadImage(photoPath);
                Toast.makeText(FormBookActivity.this, "Testando o retorno", Toast.LENGTH_LONG).show();
            }
        }
    }
}
