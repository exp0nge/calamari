package com.exp0nge.calamari;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exp0nge.calamari.dummy.DummyContent;

import java.util.List;

class GenreRecyclerAdapter extends RecyclerView.Adapter<GenreRecyclerAdapter.ViewHolder> {
    private List<DummyContent.DummyItem> items;

    public GenreRecyclerAdapter(List<DummyContent.DummyItem> items) {
        this.items = items;
    }

    @Override
    public GenreRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenreRecyclerAdapter.ViewHolder holder, int position) {
        holder.genreTextView.setText(items.get(position).id);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView genreTextView;

        public ViewHolder(View view) {
            super(view);
            genreTextView = (TextView) view.findViewById(R.id.genre_item);
        }
    }
}
