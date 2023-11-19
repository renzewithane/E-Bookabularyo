package com.teamloopit.e_bookabularyo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.teamloopit.e_bookabularyo.Fragments.FlipFragment;

import java.util.List;

public class FlipAdapter extends FragmentPagerAdapter {

    private List<Integer> textArguments;
    private int imageResourceId;
    private String title, author;

    public FlipAdapter(@NonNull FragmentManager fm,List<Integer> textArguments, int imageResourceId, String title, String author) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.textArguments = textArguments;
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.author = author;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FlipFragment.newInstance(position, textArguments.get(position), imageResourceId, title, author);
    }

    @Override
    public int getCount() {
        return textArguments.size();
    }
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}