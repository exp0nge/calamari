package com.exp0nge.calamari;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adroitandroid.chipcloud.ChipCloud;
import com.exp0nge.calamari.dummy.DummyContent;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnNovelDetailFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NovelDetailTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NovelDetailTabFragment extends Fragment {

    private OnNovelDetailFragmentInteractionListener mListener;

    public NovelDetailTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NovelDetailTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NovelDetailTabFragment newInstance() {
        return new NovelDetailTabFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novel_detail_tab, container, false);

        ChipCloud genreChipCloud = (ChipCloud) view.findViewById(R.id.genre_chip_cloud);
        ChipCloud tagCloud = (ChipCloud) view.findViewById(R.id.tag_chip_cloud);

        String[] ids = new String[DummyContent.ITEMS.size()];
        for (int i = 0; i < DummyContent.ITEMS.size(); i++) {
            ids[i] = DummyContent.ITEMS.get(i).id;
        }
        genreChipCloud.addChips(ids);
        tagCloud.addChips(ids);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNovelDetailFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNovelDetailFragmentInteractionListener) {
            mListener = (OnNovelDetailFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNovelDetailFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNovelDetailFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNovelDetailFragmentInteraction(Uri uri);
    }

}
