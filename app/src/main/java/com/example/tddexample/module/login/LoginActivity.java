package com.example.tddexample.module.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tddexample.R;
import com.example.tddexample.data.Api;
import com.example.tddexample.module.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View{


    // UI references.
    private AutoCompleteTextView mUserNameView;
    private EditText mPasswordView;
    private View mProgressView;
    private Button mButton;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this,new Api());
        mUserNameView = (AutoCompleteTextView) findViewById(R.id.username);
        mButton = (Button) findViewById(R.id.sign_in_button);
        mPasswordView = (EditText) findViewById(R.id.password);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickLogin();
            }
        });
    }

    @Override
    public String getInputUsername() {
        Editable username = mUserNameView.getText();
        return username == null ? null : username.toString();
    }

    @Override
    public void showErrorMessage(String erro) {
        Toast.makeText(this,erro,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getInputPwd() {
        Editable pwd = mPasswordView.getText();
        return pwd == null ? null : pwd.toString();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

