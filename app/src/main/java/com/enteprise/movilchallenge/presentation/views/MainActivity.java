package com.enteprise.movilchallenge.presentation.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.enteprise.movilchallenge.frameworks.containers.MyApplication;
import com.enteprise.movilchallenge.presentation.adapters.CitysResultsAdapter;
import com.enteprise.movilchallenge.databinding.ActivityMainBinding;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.presentation.viewmodels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private CitysResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        adapter = new CitysResultsAdapter(((MyApplication) getApplication()).appContainer);
        binding.viewCitys.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.viewCitys.setAdapter(adapter);

        binding.viewInputCity.addTextChangedListener(new TextWatcher() {

            private Handler mHandler = new Handler();
            Editable data;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                afterTextChangedDoPost(editable);
            }

            public void afterTextChangedDoPost(Editable editable) {
                mHandler.removeCallbacks(mFilterTask);
                mHandler.postDelayed(mFilterTask, 100);
                this.data = editable;
            }

            Runnable mFilterTask = new Runnable() {
                @Override
                public void run() {
                    if (data != null) {
                        System.out.println("--->" + data.toString());
                        viewModel.searchCity(data.toString());
                    }
                }
            };

        });

        viewModel.getCitysLiveData().observe(this, new Observer<List<City>>() {
            @Override
            public void onChanged(List<City> citys) {
                if (citys != null) {
                    adapter.setResults(citys);
                }
            }
        });


    }


}