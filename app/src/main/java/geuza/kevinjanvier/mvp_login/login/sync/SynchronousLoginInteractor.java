package geuza.kevinjanvier.mvp_login.login.sync;

/**
 * Created by kevinjanvier on 26/12/15.
 */
public class SynchronousLoginInteractor implements ISynchronousLoginInteractor {

    public SynchronousLoginInteractor(){}

    boolean validatedCredentials(String user, String pass){
        return user.contains("gmail");
    }
}
