package lbr.com.br.booklist.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.ButterKnife;
import lbr.com.br.booklist.R;
import lbr.com.br.booklist.entity.Book;
import lbr.com.br.booklist.views.FormBookActivity;

/**
 * Created by Leandro on 24/11/2017.
 */

public class FormHelper {

    private EditText mNameText;
    private TextInputLayout mNameLabel;
    public EditText mNumberPageText;
    public ImageView mPhotoFormImage;

    private FormHelper helper;

    private Book book;


    public FormHelper(FormBookActivity activity) {
        this.book = new Book();
        ButterKnife.bind(activity);

        this.mNameText = (EditText) activity.findViewById(R.id.edit_text_name_id);
        this.mNumberPageText = (EditText) activity.findViewById(R.id.edit_text_number_page_id);
        this.mNameLabel = (TextInputLayout) activity.findViewById(R.id.label_form_name_id);
        this.mPhotoFormImage = (ImageView) activity.findViewById(R.id.image_photo_form_id);

    }

    public Book getBookForm() {
        book.setNameBook(mNameText.getText().toString());
        book.setNumberPages(Integer.getInteger(mNumberPageText.getText().toString()));
        book.setPhotoPath((String) mPhotoFormImage.getTag());
        return book;
    }

    public boolean isValidName() {
        boolean isNull = mNameText.getText().toString().isEmpty();
        return !isNull;
    }

    public void showError() {
        this.mNameLabel.setError("Nome não pode estar vazio!");
    }

    public void loadBookForm(Book book) {
        this.mNameText.setText(book.getNameBook());
        this.mNumberPageText.setText(book.getNumberPages().toString());

        if (book.getPhotoPath() != null) {
            loadImage(book.getPhotoPath());
        }
    }

    public void loadImage(String photoPath) {
        Bitmap imagePhoto = BitmapFactory.decodeFile(photoPath);
        imagePhoto = Bitmap.createScaledBitmap(imagePhoto, 300, 300, true);
        mPhotoFormImage.setImageBitmap(imagePhoto);
        mPhotoFormImage.setScaleType(ImageView.ScaleType.FIT_XY);
        mPhotoFormImage.setTag(photoPath);
    }

}
