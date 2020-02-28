package com.example.studygroup.activities.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studygroup.R;
import com.example.studygroup.activities.MainActivity;
import com.example.studygroup.activities.MyGroupsActivity;
import com.example.studygroup.activities.fragments.search.SearchFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private CardView cardViewMyGroups;
    private CardView cardViewGroups;
    private CardView cardViewPeople;
    private CardView cardViewInstitutes;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        cardViewMyGroups = root.findViewById(R.id.cv_misgrupos_home);
        cardViewGroups = root.findViewById(R.id.cv_grupos_home);
        cardViewPeople = root.findViewById(R.id.cv_buscarpersonas_home);
        cardViewInstitutes = root.findViewById(R.id.cv_instituciones_home);
        cardViewInstitutes.setEnabled(false);

        cardViewMyGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), MyGroupsActivity.class);
                startActivity(i);
            }
        });

        //TODO Estos metodos reemplazan el fragment original, hay que cambiarlo por otro que nos mueva a ese fragment en vez de intercambiar.
        cardViewGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = new SearchFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, searchFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null)
                        .commit();
            }
        });

        cardViewPeople.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SearchFragment searchFragment = new SearchFragment();
               getActivity().getSupportFragmentManager().beginTransaction()
                       .replace(R.id.nav_host_fragment, searchFragment)
                       .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                       .addToBackStack(null)
                       .commit();
           }
        });

        return root;
    }
}