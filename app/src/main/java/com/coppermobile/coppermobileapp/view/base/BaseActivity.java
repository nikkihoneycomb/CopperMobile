package com.coppermobile.coppermobileapp.view.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
 /*
    Name: BaseActivity
    Purpose: base activity to handle reusable methods like hide keyboard and other UI related validations
     */

public abstract class BaseActivity extends AppCompatActivity {

    //method to hide keyboard
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
