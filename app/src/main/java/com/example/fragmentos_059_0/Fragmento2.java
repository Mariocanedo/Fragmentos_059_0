package com.example.fragmentos_059_0;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentos_059_0.databinding.FragmentFragmento2Binding;
import com.example.fragmentos_059_0.databinding.FragmentQuestionBinding;


public class Fragmento2 extends Fragment {


    private String name;
    private String  lastname;
    FragmentFragmento2Binding mBinding;
    public Fragmento2() {
        // Required empty public constructor
    }

    public static Fragmento2 newInstance(String name, String lastname) {
        Fragmento2 fragment = new Fragmento2();
        Bundle args = new Bundle();
        args.putString("clave1", name);
        args.putString("clave2", lastname);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name= getArguments().getString("clave1");
            lastname= getArguments().getString("clave2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding= FragmentFragmento2Binding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.name.setText(name);
        mBinding.lastname.setText(lastname);
    }
}