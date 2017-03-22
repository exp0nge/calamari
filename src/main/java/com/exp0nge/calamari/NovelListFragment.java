package com.exp0nge.calamari;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.provider.ListCardProvider;
import com.dexafree.materialList.view.MaterialListView;
import com.exp0nge.calamari.dummy.DummyContent;
import com.exp0nge.calamari.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NovelListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private static int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NovelListFragment() {
    }

    @SuppressWarnings("unused")
    public static NovelListFragment newInstance(int columnCount) {
        NovelListFragment fragment = new NovelListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    public static NovelListFragment newInstance() {
        return newInstance(mColumnCount);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novel_list, container, false);

        ArrayList<DummyItem> items = new ArrayList<>(DummyContent.ITEMS);
        DummyItemAdapter adapter = new DummyItemAdapter(getContext(), items);
        MaterialListView materialListView = (MaterialListView) view.findViewById(R.id.updates_list_fragment);

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cards.add(new Card.Builder(getContext())
                    .setTag("LIST_CARD")
                    .withProvider(new ListCardProvider())
                    .setLayout(R.layout.material_list_card_layout)
                    .setTitle(Calendar.getInstance().getTime().toString())
                    .setAdapter(adapter)
                    .endConfig()
                    .build());
        }

        materialListView.getAdapter().addAll(cards);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGenreListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
