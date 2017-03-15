package com.exp0nge.calamari;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exp0nge.calamari.UpdatesFragment.OnListFragmentInteractionListener;
import com.exp0nge.calamari.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUpdatesRecyclerViewAdapter extends RecyclerView.Adapter<MyUpdatesRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyUpdatesRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_updates, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.updateTitleView.setText(mValues.get(position).details);
        holder.updateChapterView.setText(mValues.get(position).id);
        holder.updateReleaseGroupView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView updateTitleView;
        public final TextView updateChapterView;
        public final TextView updateReleaseGroupView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            updateTitleView = (TextView) view.findViewById(R.id.update_title);
            updateChapterView = (TextView) view.findViewById(R.id.update_chapter);
            updateReleaseGroupView = (TextView) view.findViewById(R.id.update_group);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + updateChapterView.getText() + "'";
        }
    }
}
