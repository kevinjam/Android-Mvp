package geuza.kevinjanvier.mvp_login.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import geuza.kevinjanvier.mvp_login.BuildConfig;
import geuza.kevinjanvier.mvp_login.R;
import geuza.kevinjanvier.mvp_login.login.ILoginView;
import geuza.kevinjanvier.mvp_login.login.LoginPresenter;
import geuza.kevinjanvier.mvp_login.main.Welcome;

public class Login extends AppCompatActivity implements ILoginView{


    @Bind(R.id.usernametxt)
    EditText username;
    @Bind(R.id.passwordtxt)
    EditText password;
    @Bind(R.id.loginbtn)
    Button login;

    ProgressDialog progressDialog;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this)  ;

        if (BuildConfig.DEBUG){
            username.setText("kevin@gmail.com");
            password.setText("kevin12345");
        }

        //Give yout Presenter a refenrende to the view

        presenter= new LoginPresenter(this);

    }

    @OnClick(R.id.loginbtn)
    public void loginTapped(View view){
        progressDialog = ProgressDialog.show(this, "Authenticating", null);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        //pass User evnt straighn to Presenter
        presenter.attemptLogin(user, pass);
    }

    @Override
    public void navigateToListActivity() {
        progressDialog.dismiss();

        Toast.makeText(this, "LoginSuccess", Toast.LENGTH_SHORT).show();
        Intent loginact = new Intent(this, Welcome.class);
        startActivity(loginact);

    }

    @Override
    public void loginFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "login Invalid:user gmail address", Toast.LENGTH_SHORT).show();

    }
}
