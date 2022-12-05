package it.macgood.mathanapp.ui.handbook.demidovich;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.ItemChaptersBinding;
import it.macgood.mathanapp.ui.MainActivity;


public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ViewHolder> {

    private List<Chapter> chapters;


    public ChaptersAdapter(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chapters, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mChapter.setText(chapters.get(position).getChapter());
        holder.mName.setText(chapters.get(position).getName());
        holder.mPages.setText(chapters.get(position).getPages());
        holder.mExercises.setText(chapters.get(position).getExercises());

    }

    @Override
    public int getItemCount() {
        return chapters != null ? chapters.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemChaptersBinding binding;

        private CardView mItem;
        private TextView mChapter;
        private TextView mName;
        private TextView mPages;
        private TextView mExercises;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemChaptersBinding.bind(itemView);

            mItem = binding.item;
            mChapter = binding.textChapter;
            mName = binding.textName;
            mPages = binding.textPages;
            mExercises = binding.textExercises;


            mItem.setOnClickListener(view -> {
                String range = getRange();

                MainActivity activity = (MainActivity) itemView.getContext();
                NavController navController
                        = Navigation.findNavController(activity, R.id.app_placeholder);
                Bundle bundle = new Bundle();
                bundle.putString("exercises", range);

                navController.navigate(R.id.get_exercises_from_chapters_fragment, bundle);
            });

        }

        @NonNull
        private String getRange() {
            Matcher matcher = Pattern.compile("\\d+")
                    .matcher(mExercises.getText());
            String range = "";
            while (matcher.find()) {
                range += matcher.group() + " ";
            }
            return range;
        }
    }
}
