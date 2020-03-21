package com.project.simplemvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.simplemvp.ImpPresenter.LoginImpPresenter;
import com.project.simplemvp.Presenter.LoginPresent;
import com.project.simplemvp.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText etName, etPass;
    Button btnLogin;
    ProgressBar progressBar;

    LoginPresent loginPresent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresent = new LoginPresent(this, new LoginImpPresenter());
    }

    private void initView() {
        etName = findViewById(R.id.edt_nama);
        etPass = findViewById(R.id.edt_password);
        progressBar = findViewById(R.id.progresbar);
    }
    public void loginMe(View view) {
        showProgressBar();

        loginPresent.validateCredentials(etName.getText().toString().trim(), etPass.getText().toString().trim());
    }


    @Override
    public void setUsernameError() {
        hideProgressBar();
        etName.setError("Username can't be empty!");

    }


    @Override
    public void setPasswordError() {
        hideProgressBar();
        etPass.setError("password can't be empty!");

    }


    @Override
    public void onLoginSuccess(String username) {

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

    }

    @Override
    public void onLoginError() {
        hideProgressBar();

        Toast.makeText(this, "username or password doesn't match", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

}
