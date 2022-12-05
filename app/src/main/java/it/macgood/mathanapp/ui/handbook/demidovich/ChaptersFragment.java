package it.macgood.mathanapp.ui.handbook.demidovich;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import it.macgood.mathanapp.ui.MainActivity;
import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.FragmentChaptersBinding;
import it.macgood.mathanapp.ui.handbook.demidovich.search.SearchFragment;

public class ChaptersFragment extends Fragment {

    FragmentChaptersBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChaptersBinding.inflate(inflater);


        List<Chapter> chapters = Arrays.asList(
                new Chapter(
                        1,
                        "Глава I",
                        "Введение в анализ",
                        "Страницы: 9 - 39",
                        "Задачи: 1 - 340"
                ),
                new Chapter(
                        2,
                        "Глава II",
                        "Дифферинцирование функции",
                        "Страницы: 40 - 79",
                        "Задачи: 341 - 810"
                ),
                new Chapter(
                        3,
                        "Глава III",
                        "Экстремумы функции и геометрические приложения производной",
                        "Страницы: 80 - 101",
                        "Задачи: 811 - 1030"
                ),
                new Chapter(
                        4,
                        "Глава IV",
                        "Неопределённый интеграл",
                        "Страницы: 102 - 132",
                        "Задачи: 1031 - 1500"
                ),
                new Chapter(
                        5,
                        "Глава V",
                        "Определённый интеграл",
                        "Страницы: 133 - 171",
                        "Задачи: 1501 - 1781"
                ),
                new Chapter(
                        6,
                        "Глава VI",
                        "Функции нескольких переменных",
                        "Страницы: 172 - 232",
                        "Задачи: 1782 - 2112"
                ),
                new Chapter(
                        7,
                        "Глава VII",
                        "Кратные и криволинейные интегралы",
                        "Страницы: 233 - 276",
                        "Задачи: 2113 - 2400"
                ),
                new Chapter(
                        8,
                        "Глава VIII",
                        "Ряды",
                        "Страницы: 277 - 305",
                        "Задачи: 2401 - 2703"
                ),
                new Chapter(
                        9,
                        "Глава IX",
                        "Дифференциальные уравнения",
                        "Страницы: 306 - 349",
                        "Задачи: 2704 - 3107"
                ),
                new Chapter(
                        10,
                        "Глава X",
                        "Приближенные вычисления",
                        "Страницы: 350 - 377",
                        "Задачи: 3108 - 3193"
                )
        );

        binding.recyclerView.setAdapter(new ChaptersAdapter(chapters));

        MainActivity activity = (MainActivity) getContext();
        NavController navController = Navigation.findNavController(activity, R.id.app_placeholder);

        binding.buttonBack.setOnClickListener(view -> {
            navController.navigate(R.id.get_handbooks_from_demidovich_chapters);
        });

        binding.fabSearch.setOnClickListener(view -> {
            SearchFragment searchFragment = new SearchFragment();
            searchFragment.show(getFragmentManager(), "TAG");
        });




        return binding.getRoot();
    }
}