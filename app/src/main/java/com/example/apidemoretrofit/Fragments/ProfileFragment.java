package com.example.apidemoretrofit.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apidemoretrofit.R;
import com.example.apidemoretrofit.RetroDemo.Result;
import com.example.apidemoretrofit.RetroDemo.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }


    ListView nameListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        nameListView=view.findViewById(R.id.realListView);
        getSuperHeroNames();
        return view;
    }

    private void getSuperHeroNames() {
        Call<List<Result>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Result>>() {
            @Override

            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                List<Result> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getRealname();
                }

                nameListView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}