package com.teamloopit.e_bookabularyo.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.FlipAdapter;
import com.teamloopit.e_bookabularyo.R;


public class FlipFragment extends Fragment {
    private static final String TEXT_ARGUMENT_KEY = "text_argument";
    private static final String IMAGE_RESOURCE_ID_ARGUMENT_KEY = "image_resource_id_argument";
    private static final String title = "TITLE";
    private static final String author = "AUTHOR";
    public static FlipFragment newInstance(int position, int textResourceId, int imageResourceId, String _title, String _author) {
        FlipFragment fragment = new FlipFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt(TEXT_ARGUMENT_KEY, textResourceId);
        args.putInt(IMAGE_RESOURCE_ID_ARGUMENT_KEY, imageResourceId);
        args.putString(title, _title);
        args.putString(author, _author);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flip, container, false);

        TextView textViewbody = view.findViewById(R.id.body);
        TextView textViewtitle = view.findViewById(R.id.title);
        TextView textViewauthor = view.findViewById(R.id.author);


        int textResourceId = getArguments().getInt(TEXT_ARGUMENT_KEY);
        int imageResourceId = getArguments().getInt(IMAGE_RESOURCE_ID_ARGUMENT_KEY);

        String t = getArguments().getString(title);
        textViewtitle.setText(t);

        String a = getArguments().getString(author);
        textViewauthor.setText(a);

        // Set text and image
        textViewbody.setText(textResourceId);
        view.setBackgroundResource(imageResourceId);

        int position = getArguments().getInt("position", -1);
        if (position == 0) {
            textViewtitle.setVisibility(View.VISIBLE);
            textViewauthor.setVisibility(View.VISIBLE);
        } else {
            textViewtitle.setVisibility(View.GONE);
            textViewauthor.setVisibility(View.GONE);
        }

        return view;
    }
}