package com.example.studygroup.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.studygroup.R;
import com.example.studygroup.controllers.PersonController;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.shobhitpuri.custombuttons.GoogleSignInButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleSignInButton btnLogin;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInAccount account=null;
    private GoogleApiClient apiClient;

    static final int REQUEST_LOGIN = 1;
    static final int REQUEST_COMPLETAR_REGISTRO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnLogin = (GoogleSignInButton) findViewById(R.id.btn_login_google);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        btnLogin.setVisibility(View.VISIBLE);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        apiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    @Override
    protected void onStart(){
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        actualizarUI(account);
    }

    private void actualizarUI(GoogleSignInAccount account){
        if(account !=null){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            MainActivity.usuarioActivo= PersonController.findPeople(account.getEmail());
            startActivity(i);
            finish();
        }
        else {
            //TODO Configurar boton de login.

        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, REQUEST_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_LOGIN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
        if(requestCode==REQUEST_COMPLETAR_REGISTRO && resultCode==RESULT_OK){
            actualizarUI(account);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            account = task.getResult(ApiException.class);
            completarRegistro();
        } catch (ApiException e) {
            Log.w("APP_MSG", "signInResult:failed code=" + e.getStatusCode());
            actualizarUI(null);
        }
    }

    private void completarRegistro(){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivityForResult(i, REQUEST_COMPLETAR_REGISTRO);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Error de conexion!", Toast.LENGTH_SHORT).show();
        Log.e("GoogleSignIn", "OnConnectionFailed: " + connectionResult);
    }
}
