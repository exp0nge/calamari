package com.exp0nge.calamari;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class NovelsDetailScrollingNovelDetailFragment extends Fragment implements
        NovelDetailFragment.OnNovelDetailFragmentInteractionListener {
    private static List<String> PageTitles = Arrays.asList(
            "Details",
            "Chapters",
            "Reviews");

    private NovelsDetailScrollingNovelDetailFragment.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novel_detail_scrolling, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.novel_detail_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.novel_detail_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Create the adapter that will return a fragment for each tabs
        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.novel_detail_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.detail_tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSmoothScrollingEnabled(true);
    }

    @Override
    public void onNovelDetailFragmentInteraction(Uri uri) {

    }

    public static NovelsDetailScrollingNovelDetailFragment newInstance() {
        return new NovelsDetailScrollingNovelDetailFragment();
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return NovelDetailFragment.newInstance();
                default:
                    return NovelCardListFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return PageTitles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PageTitles.get(position);
        }
    }
}
