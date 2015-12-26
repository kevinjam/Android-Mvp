package geuza.kevinjanvier.mvp_login.login.async;

import android.os.Handler;
import geuza.kevinjanvier.mvp_login.login.OnLoginFinishedListener;

/**
 * Created by kevinjanvier on 26/12/15.
 */
public class AsyncLoginInteractor implements IAsyncLoginInteractor{

    public void validateCredentialsAsync(final OnLoginFinishedListener listener, final String user, final String pass){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (user.contains("gmail")) {

                    listener.onSuccess();
                }else {
                    listener.onError();
                }
            }
        }, 2000);

    }
}
