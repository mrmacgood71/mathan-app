package it.macgood.mathanapp.ui.handbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.FragmentHandbookBinding;

public class HandbookFragment extends Fragment {

    FragmentHandbookBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHandbookBinding.inflate(inflater);

        List<Handbook> handbooks = Arrays.asList(
                new Handbook(1L,
                        R.drawable.demidovich,
                        "Задачи и упражнения по математическому анализу",
                        "Б. П. Демидович"),
                new Handbook(2L,
                        R.drawable.berman,
                        "Сборник задач по курсу математического анализа",
                        "Г. Н. Берман"),
                new Handbook(3L,
                        R.drawable.minorskiy,
                        "Сборник задач по высшей математике",
                        "В. П. Минорский")
        );

        binding.recyclerView.setAdapter(new HandbookAdapter(handbooks));
        return binding.getRoot();
    }
}