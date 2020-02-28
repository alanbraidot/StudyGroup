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
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.studygroup.R;
import com.example.studygroup.adapters.SearchFragmentAdapter;
import com.example.studygroup.controllers.GroupController;

public class SearchFragment extends Fragment {

    private SearchView searchView;
    private Spinner spinner;
    private TextView tvFilter;
    private TextView tvSoon;
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
        searchView.setVisibility(View.GONE);
        spinner = root.findViewById(R.id.spinner_filter_search_fragment);
        spinner.setVisibility(View.GONE);
        tvFilter = root.findViewById(R.id.textView_filter_search_fragment);
        tvFilter.setVisibility(View.GONE);
        tvSoon = root.findViewById(R.id.tv_soon_search_fragment);
        mRecyclerView = root.findViewById(R.id.recyclerView_search_fragment);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.GONE);
        mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SearchFragmentAdapter(GroupController.getInstance().getGroupList(),context);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

}
