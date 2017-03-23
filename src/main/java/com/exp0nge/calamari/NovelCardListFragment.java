package com.exp0nge.calamari;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;
import com.exp0nge.calamari.dummy.DummyContent;
import com.exp0nge.calamari.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NovelCardListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;

    public NovelCardListFragment() {
    }

    @SuppressWarnings("unused")
    public static NovelCardListFragment newInstance() {
        return new NovelCardListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novel_material_card_list, container, false);

        setUpCardList(view);

        return view;
    }

    private void setUpCardList(View view) {
        MaterialListView materialListView = (MaterialListView) view.findViewById(R.id.material_novel_list_view);
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < DummyContent.ITEMS.size(); i++) {
            cards.add(new Card.Builder(getContext())
                    .withProvider(new CardProvider<>())
                    .setLayout(R.layout.material_basic_image_buttons_card_layout)
                    .setTitle(DummyContent.ITEMS.get(i).id)
                    .setDescription(DummyContent.ITEMS.get(i).details)
                    .setDrawable(R.mipmap.no_cover)
                    .addAction(R.id.left_text_button, new TextViewAction(getContext())
                            .setText("left")
                            .setTextResourceColor(R.color.black_button)
                            .setListener(new OnActionClickListener() {
                                @Override
                                public void onActionClicked(View view, Card card) {
                                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }))
                    .addAction(R.id.right_text_button, new TextViewAction(getContext())
                            .setText("right")
                            .setTextResourceColor(R.color.orange_button)
                            .setListener(new OnActionClickListener() {
                                @Override
                                public void onActionClicked(View view, Card card) {
                                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    card.dismiss();
                                }
                            }))
                    .endConfig()
                    .build());
        }
        materialListView.getAdapter().addAll(cards);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
