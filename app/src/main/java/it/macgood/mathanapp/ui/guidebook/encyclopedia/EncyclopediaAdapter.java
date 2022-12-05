package it.macgood.mathanapp.ui.guidebook.encyclopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.ItemAlphabetBinding;

public class EncyclopediaAdapter extends RecyclerView.Adapter<EncyclopediaAdapter.ViewHolder> {

    private List<String> mAlphabets;

    public EncyclopediaAdapter(List<String> mAlphabets) {
        this.mAlphabets = mAlphabets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alphabet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mLetter.setText(mAlphabets.get(position));
    }

    @Override
    public int getItemCount() {
        return mAlphabets != null ? mAlphabets.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mLetter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemAlphabetBinding binding = ItemAlphabetBinding.bind(itemView);
            mLetter = binding.letter;
        }
    }
}
