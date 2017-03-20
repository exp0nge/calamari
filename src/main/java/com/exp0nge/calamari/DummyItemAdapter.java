package com.exp0nge.calamari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exp0nge.calamari.dummy.DummyContent;

import java.util.ArrayList;

public class DummyItemAdapter extends ArrayAdapter<DummyContent.DummyItem> {
    public DummyItemAdapter(Context context, ArrayList<DummyContent.DummyItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        DummyContent.DummyItem item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_list_item,
                    parent,
                    false
            );
        }

        TextView updateTitleView = (TextView) convertView.findViewById(R.id.update_title);
        TextView updateChapterView = (TextView) convertView.findViewById(R.id.update_chapter);
        ImageView coverImageView = (ImageView) convertView.findViewById(R.id.cover_image);

        updateChapterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BrowseActivity) parent.getContext()).startNovelScrollFragment();
            }
        });

        updateTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BrowseActivity) parent.getContext()).startNovelScrollFragment();
            }
        });

        updateTitleView.setText(item.details);
        updateChapterView.setText(item.id);

        return convertView;
    }
}
