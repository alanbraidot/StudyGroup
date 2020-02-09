package com.example.studygroup.activities.fragments.search;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.studygroup.R;
import com.example.studygroup.adapters.SearchFragmentAdapter;
import com.example.studygroup.controllers.GroupController;
import com.example.studygroup.domain.Grupo;

public class SearchFragment extends Fragment {

    private SearchView searchView;
    private Spinner spinner;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private SearchViewModel mViewModel;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        context = root.getContext();
        searchView = root.findViewById(R.id.searchView_search_fragment);
        spinner = root.findViewById(R.id.spinner_filter_search_fragment);
        mRecyclerView = root.findViewById(R.id.recyclerView_search_fragment);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SearchFragmentAdapter(GroupController.getInstance().getGrupoList());
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

}
