package com.example.studygroup.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.studygroup.R;
import com.example.studygroup.controllers.GeneralController;
import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;
import com.example.studygroup.receivers.MyReceiver;
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

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
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

        initializeDomain();

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
        btnLogin.setVisibility(View.INVISIBLE);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        apiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        createNotificationChannel();

    }

    private void initializeDomain() {
        University utn = new University(University.UniversityEnum.UTN);
        utn.getFacultyEnumList().add(Faculty.FacultyEnum.FRSF);

        University unl = new University(University.UniversityEnum.UNL);
        unl.getFacultyEnumList().add(Faculty.FacultyEnum.FICH);

        GeneralController.getInstance().getUniversityList().add(utn);
        GeneralController.getInstance().getUniversityList().add(unl);

        Faculty utn_frsf = new Faculty(Faculty.FacultyEnum.FRSF);
        utn_frsf.getCareerEnumList().add(Career.CareerEnum.IMUTN);
        utn_frsf.getCareerEnumList().add(Career.CareerEnum.ISIUTN);

        Faculty unl_fich = new Faculty(Faculty.FacultyEnum.FICH);
        unl_fich.getCareerEnumList().add(Career.CareerEnum.IINFUNL);
        unl_fich.getCareerEnumList().add(Career.CareerEnum.IQUNL);

        GeneralController.getInstance().getFacultyList().add(utn_frsf);
        GeneralController.getInstance().getFacultyList().add(unl_fich);

        Career isi_frsf = new Career(Career.CareerEnum.ISIUTN);
        isi_frsf.getSubjectEnumList().add(Subject.SubjectEnum.AMI);
        isi_frsf.getSubjectEnumList().add(Subject.SubjectEnum.FISI);

        Career im_frsf = new Career(Career.CareerEnum.IMUTN);
        im_frsf.getSubjectEnumList().add(Subject.SubjectEnum.AMI);
        im_frsf.getSubjectEnumList().add(Subject.SubjectEnum.FISI);

        Career ii_fich = new Career(Career.CareerEnum.IINFUNL);
        ii_fich.getSubjectEnumList().add(Subject.SubjectEnum.AMI);
        ii_fich.getSubjectEnumList().add(Subject.SubjectEnum.FISI);

        Career iq_fich = new Career(Career.CareerEnum.IQUNL);
        iq_fich.getSubjectEnumList().add(Subject.SubjectEnum.AMI);
        iq_fich.getSubjectEnumList().add(Subject.SubjectEnum.FISI);

        GeneralController.getInstance().getCareerList().add(isi_frsf);
        GeneralController.getInstance().getCareerList().add(im_frsf);
        GeneralController.getInstance().getCareerList().add(ii_fich);
        GeneralController.getInstance().getCareerList().add(iq_fich);
    }

    @Override
    protected void onStart(){
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        actualizarUI(account);
    }

    private void actualizarUI(GoogleSignInAccount account){
        if(account !=null){
            btnLogin.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            MainActivity.usuarioActivo = PersonController.findPerson(account.getEmail(), getApplicationContext());
            welcomeNotification();
            startActivity(i);
            finish();
        }
        else {
            btnLogin.setVisibility(View.VISIBLE);
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
            MainActivity.usuarioActivo = new Person();
            MainActivity.usuarioActivo.setNombre(account.getDisplayName());
            MainActivity.usuarioActivo.setApellido(account.getFamilyName());
            MainActivity.usuarioActivo.setEmail(account.getEmail());
            //TODO Terminar de cargar los datos del usuario que se registro.
            actualizarUI(account);
        }
        if(requestCode==REQUEST_COMPLETAR_REGISTRO && resultCode!=RESULT_OK)
            account=null;
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

    private void welcomeNotification(){
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent();
                i.putExtra("Name",account.getDisplayName());
                i.setAction(MyReceiver.LOGIN_SUCCESSFULLY);
                sendBroadcast(i);
            }
        };
        Thread hilo = new Thread(myRunnable);
        hilo.start();
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = String.valueOf(R.string.channel_notification_login);
            String description = String.valueOf(R.string.channel_notification_login_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(MyReceiver.CHANNEL_ID_NOTIFICATION_LOGIN, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Error de conexion!", Toast.LENGTH_SHORT).show();
        Log.e("GoogleSignIn", "OnConnectionFailed: " + connectionResult);
    }
}
