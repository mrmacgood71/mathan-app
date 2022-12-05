package it.macgood.mathanapp.ui.guidebook.encyclopedia;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import it.macgood.mathanapp.databinding.FragmentEncyclopediaBinding;
import it.macgood.mathanapp.ui.MainActivity;
import it.macgood.mathanapp.R;

public class EncyclopediaFragment extends Fragment {

    FragmentEncyclopediaBinding binding;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEncyclopediaBinding.inflate(inflater);

        EncyclopediaAdapter adapter = new EncyclopediaAdapter(Arrays.asList(
           "A", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "К", "Л", "М", "Н", "О", "П",
           "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю",
           "Я"
        ));

        binding.recyclerView.setAdapter(adapter);
        context = container.getContext();
        MainActivity activity = (MainActivity) container.getContext();
        NavController controller = Navigation.findNavController(activity, R.id.app_placeholder);
        binding.buttonBack.setOnClickListener(view -> {

            controller.navigate(R.id.get_guides_from_encyclopedia);

        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}