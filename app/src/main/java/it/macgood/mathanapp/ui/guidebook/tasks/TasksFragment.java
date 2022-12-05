package it.macgood.mathanapp.ui.guidebook.tasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.macgood.mathanapp.ui.MainActivity;
import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.FragmentTasksBinding;

public class TasksFragment extends Fragment {

    FragmentTasksBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTasksBinding.inflate(inflater);

        MainActivity activity = (MainActivity) container.getContext();
        NavController navController = Navigation.findNavController(activity, R.id.app_placeholder);

        binding.buttonBack.setOnClickListener(view -> {
            navController.navigate(R.id.get_guides_from_tasks);
        });

        return binding.getRoot();
    }
}