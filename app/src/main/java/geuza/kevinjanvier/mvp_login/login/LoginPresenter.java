package geuza.kevinjanvier.mvp_login.login;

import geuza.kevinjanvier.mvp_login.login.async.AsyncLoginInteractor;

/**
 * Created by kevinjanvier on 26/12/15.
 */
public class LoginPresenter implements ILoginPresenter, OnLoginFinishedListener {

    private ILoginView view;
    private AsyncLoginInteractor interactor;


    public LoginPresenter(ILoginView loginView){
        this.view = loginView;
        //interactive model
        this.interactor = new AsyncLoginInteractor();

    }
    public void attemptLogin(String user, String pass){
        interactor.validateCredentialsAsync(this, user, pass);
    }

    @Override
    public void onError() {
        view.loginFailed();
    }

    @Override
    public void onSuccess() {
        view.navigateToListActivity();
    }
}
