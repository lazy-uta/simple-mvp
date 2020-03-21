package com.project.simplemvp.View;

public interface LoginView {

    void setUsernameError();
    void setPasswordError();
    void showProgressBar();
    void hideProgressBar();
    void onLoginSuccess(String username);
    void onLoginError ();
}
