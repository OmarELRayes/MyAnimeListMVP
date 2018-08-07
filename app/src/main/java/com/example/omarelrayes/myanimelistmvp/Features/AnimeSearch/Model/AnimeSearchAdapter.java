package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.R;

import java.util.List;

public class AnimeSearchAdapter extends PagedListAdapter<Anime, AnimeSearchAdapter.AnimeViewHolder> {

    public static final DiffUtil.ItemCallback<Anime> DIFF_CALLBACK = new DiffUtil.ItemCallback<Anime>() {
        @Override
        public boolean areItemsTheSame(@NonNull Anime oldItem, @NonNull Anime newItem) {
            return oldItem.getMal_id() == newItem.getMal_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Anime oldItem, @NonNull Anime newItem) {
            return oldItem.equals(newItem);
        }
    };
    private Context context;
    private List<Anime> list;

    public AnimeSearchAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @Override
    public AnimeSearchAdapter.AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_item, parent, false);
        return new AnimeViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime item = getItem(position);
        if (item != null) {
            holder.title.setText(item.getTitle());
            Glide.with(context)
                    .load(item.getImage_url())
                    .into(holder.img);
        }
    }

    public void updateItems(List<Anime> items) {
        this.list = items;
        notifyDataSetChanged();
    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.anime_img);
            title = itemView.findViewById(R.id.anime_title);
        }
    }

}
