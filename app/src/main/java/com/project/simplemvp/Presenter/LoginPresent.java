package com.project.simplemvp.Presenter;

import com.project.simplemvp.ImpPresenter.LoginImpPresenter;
import com.project.simplemvp.View.LoginView;


public class LoginPresent implements LoginImpPresenter.OnLoginFinishedListener{

    private LoginView loginView;
    private LoginImpPresenter loginImpPresenter;

    public LoginPresent(LoginView loginView, LoginImpPresenter loginImpPresenter){
        this.loginView = loginView;
        this.loginImpPresenter = loginImpPresenter;
    }

    public void validateCredentials(String username, String password)
    {
        if (loginView != null)
        {
            loginImpPresenter.canLogin(username,password,this);
        }
    }



    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
        }

    }

    @Override
    public void onLoginSuccess(String username) {
        if (loginView != null) {
            loginView.onLoginSuccess(username);
        }
    }

    @Override
    public void onLoginError() {
        if (loginView!=null){
            loginView.onLoginError();
        }

    }
}
