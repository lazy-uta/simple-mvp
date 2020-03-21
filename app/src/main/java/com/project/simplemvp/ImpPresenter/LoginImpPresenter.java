package com.project.simplemvp.ImpPresenter;

import android.os.Handler;
import android.text.TextUtils;


public class LoginImpPresenter {
    public interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onLoginSuccess(String username);
        void onLoginError();

    }


    public void canLogin(final String username, final String password, final OnLoginFinishedListener listener) {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               if (TextUtils.isEmpty(username)){
                   listener.onUsernameError();
                   return;
               }
               if (TextUtils.isEmpty(password)){
                   listener.onPasswordError();
                   return;
               }
               if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")){
                   listener.onLoginSuccess(username);
                   return;
               }
           }
       },2000);
    }
}
