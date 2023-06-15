package com.example.fragmentos_059_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentos_059_0.databinding.ActivityMainBinding;
import com.example.fragmentos_059_0.databinding.FragmentFragmento2Binding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private boolean isFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFragmentShow){
                    closeFragment();
                } else{
                    openFragment();
                }
            }
        });


        mBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment2("Mario", "Canedo");
            }
        });
    }


    private void openFragment() {
        // 1primer paso es instanciar el fragmento
        QuestionFragment questionFragment = new QuestionFragment();
        //2 instancia del fragment manager
        FragmentManager manager = getSupportFragmentManager();

        //3 crear la transaccion

        FragmentTransaction transaction = manager.beginTransaction().replace(mBinding.contenedor2.getId(),
                questionFragment, QuestionFragment.class.getSimpleName());

        transaction.commit();
        mBinding.open.setText("cerrar");
        isFragmentShow= true;

    }

    private void closeFragment() {
        // GENERAR INSTANCIA DEL MANAGER
        FragmentManager manager = getSupportFragmentManager();
        QuestionFragment questionFragment= (QuestionFragment)  manager.findFragmentById(mBinding.contenedor2.getId());

        if( questionFragment != null){

            FragmentTransaction transaction= manager.beginTransaction();
            transaction.remove(questionFragment).commit();
            mBinding.open.setText("Abrir");
            isFragmentShow= false;

        }

    }


    private void openFragment2(String name ,String lastname) {
        // 1primer paso es instanciar el fragmento
        Fragmento2 fragmento2 = Fragmento2.newInstance(name, lastname);
        //2 instancia del fragment manager
        FragmentManager manager = getSupportFragmentManager();

        //3 verificar si el contenedor esta ocupado o no

        if( fragmento2 != null){

            FragmentTransaction transaction= manager.beginTransaction().replace(mBinding.contenedor.getId(),fragmento2,
            Fragmento2.class.getSimpleName());
            mBinding.open.setText("cerrar");
            isFragmentShow= false;
            transaction.commit();

        }



    }

}