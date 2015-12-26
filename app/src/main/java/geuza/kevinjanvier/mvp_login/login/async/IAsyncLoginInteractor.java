package geuza.kevinjanvier.mvp_login.login.async;

import geuza.kevinjanvier.mvp_login.login.OnLoginFinishedListener;

/**
 * Created by kevinjanvier on 26/12/15.
 */
public interface IAsyncLoginInteractor {
    void validateCredentialsAsync(OnLoginFinishedListener listener, String user, String pass);
}
