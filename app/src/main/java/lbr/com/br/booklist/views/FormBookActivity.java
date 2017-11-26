package lbr.com.br.booklist.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.contract.FormBookContract;
import lbr.com.br.booklist.presenter.FormBookPresenter;

public class FormBookActivity extends AppCompatActivity implements FormBookContract.View {

    private FormBookContract.View view;

    private FormBookContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_book);
        ButterKnife.bind(this);

        this.presenter = new FormBookPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_form_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_btn_salvar){
            Toast.makeText(FormBookActivity.this, "Livro cadastrado", Toast.LENGTH_SHORT).show();
            finish();
        } else if (item.getItemId() == android.R.id.home){ //Comportamento botão voltar
            finish();
        }
        return true;
    }
}
