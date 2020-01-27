package com.example.studygroup.ui.search;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.studygroup.R;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        final SearchView searchView = root.findViewById(R.id.searchView_search_fragment);
        final Spinner spinner = root.findViewById(R.id.spinner_filter_search_fragment);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView_search_fragment);
        return root;
    }

}
