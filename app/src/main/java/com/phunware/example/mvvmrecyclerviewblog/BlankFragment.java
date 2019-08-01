package com.phunware.example.mvvmrecyclerviewblog;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phunware.example.mvvmrecyclerviewblog.databinding.FragmentBlankBinding;
import com.phunware.example.mvvmrecyclerviewblog.viewmodel.DataViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBlankBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        binding.setViewModel(new DataViewModel());

        binding.executePendingBindings();

        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));

        new DataViewModel().setUp();

//       initRecyclerView(binding.getRoot());
        return binding.getRoot();
    }
}
