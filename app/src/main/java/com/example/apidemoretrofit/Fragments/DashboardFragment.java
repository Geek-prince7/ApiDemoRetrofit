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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {



    public DashboardFragment() {
        // Required empty public constructor
    }



    ListView superListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        getSuperHeroes();
        superListView = view.findViewById(R.id.superListView);

        return view;
    }
    private void getSuperHeroes() {
        Call<List<Result>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Result>>() {
            @Override

            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                List<Result> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getSuperName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}