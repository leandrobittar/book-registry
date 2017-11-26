package lbr.com.br.booklist.presenter;

import android.content.Context;

import lbr.com.br.booklist.contract.FormBookContract;

/**
 * Created by Leandro on 25/11/2017.
 */

public class FormBookPresenter implements FormBookContract.Presenter {

    private Context context;

    private FormBookContract.View view;

    public FormBookPresenter(Context context, FormBookContract.View view) {
        this.context = context;
        this.view = view;
    }
}
