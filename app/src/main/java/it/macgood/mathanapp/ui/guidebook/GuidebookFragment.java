package it.macgood.mathanapp.ui.guidebook;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import it.macgood.mathanapp.databinding.FragmentGuidebookBinding;

public class GuidebookFragment extends Fragment {

    private static final int REQUEST_CODE = 100;
    public static final String imageURL = "";
    String imageName = "demoImage.pdf";

    FragmentGuidebookBinding binding;
    List<Guide> list = Arrays.asList(
            new Guide(1, "Энциклопедия", "Сборник математических определений, теорем и приложений"),
            new Guide(2, "Тесты", "Интерактивные экзамены и тесты по темам"),
            new Guide(3, "Desmos", "Веб-приложение, строющее график функции и помогающее постичь математику"),
            new Guide(4, "Сопроводительные материалы", "Подготовка к экзаменам и дополнения к текущим лекциям"),
            new Guide(5, "Конвертер изображений", "Конвертация изображения в формат pdf"),
            new Guide(6, "Примечания", "Примечания, литература, использование, авторское право, отказ от ответственности"),
            new Guide(7, "Авторы", "Управление проектами и авторы"),
            new Guide(8, "Контакты", "Контакты с авторами проекта")
    );

    public GuidebookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGuidebookBinding.inflate(inflater, container, false);

        GuidebookAdapter adapter = new GuidebookAdapter(getContext(), list);

        binding.recyclerView.setAdapter(adapter);
        try {
            if (checkSelfPermission(inflater.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PermissionChecker.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }

        }catch (RuntimeException e) {

        }


        return binding.getRoot();
    }
}