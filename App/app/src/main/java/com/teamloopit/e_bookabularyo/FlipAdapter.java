package com.teamloopit.e_bookabularyo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.teamloopit.e_bookabularyo.Fragments.FlipFragment;
import com.teamloopit.e_bookabularyo.Fragments.FlipLastPage;

import java.util.List;

public class FlipAdapter extends FragmentPagerAdapter {

    private List<Integer> textArguments;
    private int imageResourceId, imgCoverId;
    private String title, author;

    public FlipAdapter(@NonNull FragmentManager fm,List<Integer> textArguments, int imageResourceId, String title, String author, int imgCoverId) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.textArguments = textArguments;
        this.imageResourceId = imageResourceId;
        this.imgCoverId = imgCoverId;
        this.title = title;
        this.author = author;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // If it's the last position, return the custom fragment
        if (position == getCount() - 1) {
            return FlipLastPage.newInstance(title, author, imgCoverId);
        } else {
            // Return a regular fragment for other positions
            return FlipFragment.newInstance(position, textArguments.get(position), imageResourceId, title, author);
        }
    }

    @Override
    public int getCount() {
        // Add 1 to the count for the custom fragment at the end
        return textArguments.size() + 1;
    }
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}