package com.exp0nge.calamari;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exp0nge.calamari.LatestUpdatesListFragment.OnListFragmentInteractionListener;
import com.exp0nge.calamari.dummy.DummyContent;
import com.exp0nge.calamari.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUpdatesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public MyUpdatesRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_updates_item, parent, false);
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_HEADER){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_updates_header, parent, false);
            return new SectionViewHolder(view);
        }

        throw new RuntimeException("Cannot match viewType " + viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).mItem = mValues.get(position);
            ((ItemViewHolder) holder).updateTitleView.setText(mValues.get(position).details);
            ((ItemViewHolder) holder).updateChapterView.setText(mValues.get(position).id);

            ((ItemViewHolder) holder).mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(((ItemViewHolder) holder).mItem);
                    }
                }
            });
        } else if (holder instanceof SectionViewHolder){
            ((SectionViewHolder) holder).sectionHeaderView.setText(DummyContent.DATE_MAP.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (DummyContent.DATE_MAP.containsKey(position)){
            return TYPE_HEADER;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView updateTitleView;
        public final TextView updateChapterView;
        public final ImageView coverImageView;

        public DummyItem mItem;

        public ItemViewHolder(View view) {
            super(view);
            mView = view;
            updateTitleView = (TextView) view.findViewById(R.id.update_title);
            updateChapterView = (TextView) view.findViewById(R.id.update_chapter);
            coverImageView = (ImageView) view.findViewById(R.id.cover_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + updateChapterView.getText() + "'";
        }
    }
    class SectionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView sectionHeaderView;

        public SectionViewHolder(View view) {
            super(view);
            mView = view;
            sectionHeaderView = (TextView) view.findViewById(R.id.section_header);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + sectionHeaderView.getText() + "'";
        }
    }
}
