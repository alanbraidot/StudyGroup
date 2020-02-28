package com.example.studygroup.activities.fragments.account;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studygroup.R;
import com.example.studygroup.activities.LoginActivity;
import com.example.studygroup.activities.MainActivity;
import com.example.studygroup.activities.MyGroupsActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountFragment extends Fragment {

    private AccountViewModel mViewModel;

    private CircleImageView fotoPerfil;
    private TextView nombre;
    private TextView pais;
    private TextView ciudadProvincia;
    private TextView universidad;
    private TextView facultad;
    private TextView carrera;
    private TextView email;
    private Button btnMisGrupos;
    private Button btnCerrarSesion;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        context = root.getContext();

        fotoPerfil = (CircleImageView) root.findViewById(R.id.image_foto_perfil);
        nombre = (TextView) root.findViewById(R.id.tv_nombre_perfil);
        pais = (TextView) root.findViewById(R.id.tv_pais_perfil);
        ciudadProvincia = (TextView) root.findViewById(R.id.tv_ciudad_perfil);
        universidad = (TextView) root.findViewById(R.id.tv_universidad_perfil);
        facultad = (TextView) root.findViewById(R.id.tv_facultad_perfil);
        carrera = (TextView) root.findViewById(R.id.tv_carrera_perfil);
        email = (TextView) root.findViewById(R.id.tv_email_perfil);
        btnMisGrupos = (Button) root.findViewById(R.id.btn_misgrupos_perfil);
        btnCerrarSesion = (Button) root.findViewById(R.id.btn_cerrar_sesion_perfil);

        //TODO Descomentar carga de foto.
        //fotoPerfil.setImageBitmap(MainActivity.usuarioActivo.getPhoto());
        nombre.setText(MainActivity.usuarioActivo.getNombre());
        pais.setText(MainActivity.usuarioActivo.getCountryEnum().toString());
        ciudadProvincia.setText((MainActivity.usuarioActivo.getCityEnum().toString()+", "+MainActivity.usuarioActivo.getProvinceEnum().toString()));
        if(!MainActivity.usuarioActivo.isTeacher()){
            facultad.setText(MainActivity.usuarioActivo.getFacultyEnum().toString());
            universidad.setText(MainActivity.usuarioActivo.getUniversityEnum().toString());
            carrera.setText(MainActivity.usuarioActivo.getCareerEnum().toString());
        }
        else{
            facultad.setVisibility(View.GONE);
            universidad.setVisibility(View.GONE);
            carrera.setVisibility(View.GONE);
        }
        email.setText(MainActivity.usuarioActivo.getEmail());

        btnMisGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, MyGroupsActivity.class);
                startActivity(i);
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(R.string.dialog_cerrar_sesion)
                        .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.usuarioActivo = null;
                                Intent i = new Intent(context, LoginActivity.class);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return root;
    }
}
