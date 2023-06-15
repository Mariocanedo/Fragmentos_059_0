package com.example.fragmentos_059_0;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.fragmentos_059_0.databinding.FragmentQuestionBinding;


public class QuestionFragment extends Fragment {


private FragmentQuestionBinding mBinding;
    public QuestionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     mBinding= FragmentQuestionBinding.inflate(inflater,container,false);
     return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                int index = mBinding.radiogroup.indexOfChild(mBinding.radiogroup.findViewById(i));
                switch (index){

                    case 0:
                        mBinding.textViewRes.setText("Si lo Conozco");
                        break;

                    case 1:
                        mBinding.textViewRes.setText("No lo conozco");
                        break;

                    default:
                        break;

                }

            }
        });
    }
}