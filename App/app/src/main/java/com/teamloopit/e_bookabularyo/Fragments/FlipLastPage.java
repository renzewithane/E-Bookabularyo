package com.teamloopit.e_bookabularyo.Fragments;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.Activity.FlipActivity;
import com.teamloopit.e_bookabularyo.Activity.Mabangis;
import com.teamloopit.e_bookabularyo.Activity.Sarrangola;
import com.teamloopit.e_bookabularyo.R;

import java.util.List;


public class FlipLastPage extends Fragment {

    private static final String TITLE_KEY = "title_key";
    private static final String AUTHOR_KEY = "author_key";
    private static final String IMAGE_RESOURCE_ID_KEY = "image_resource_id_key";

    private LinearLayout homeback;
    private TextView bookTitle, bookAuthor;
    private Button basahinUlit, Pagsusulit;
    private ImageView imageViewBG;
    public static FlipLastPage newInstance(String title, String author, int imageResourceId) {
        FlipLastPage fragment = new FlipLastPage();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        args.putString(AUTHOR_KEY, author);
        args.putInt(IMAGE_RESOURCE_ID_KEY, imageResourceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_flip_last_page, container, false);

        imageViewBG = view.findViewById(R.id.imageViewBGlast);
        bookTitle = view.findViewById(R.id.bookTitleLast);
        bookAuthor = view.findViewById(R.id.bookAuthorLast);
        basahinUlit = view.findViewById(R.id.basahinUlit);
        Pagsusulit = view.findViewById(R.id.Pagsusulit);
        homeback = view.findViewById(R.id.homeback);

        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlipActivity hostingActivity = (FlipActivity) getActivity();
                if (hostingActivity != null) {
                    hostingActivity.navigateToHome();

                }
            }
        });


        bookTitle.setText(getArguments().getString(TITLE_KEY));
        bookAuthor.setText(getArguments().getString(AUTHOR_KEY));
        imageViewBG.setImageResource(getArguments().getInt(IMAGE_RESOURCE_ID_KEY));


        basahinUlit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlipActivity hostingActivity = (FlipActivity) getActivity();
                if (hostingActivity != null) {
                    hostingActivity.navigateToFirstPage();
                }
            }
        });

        Pagsusulit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (getArguments().getString(TITLE_KEY))
                {
                    case "Saranggola":
                        Intent intent = new Intent(getContext(), Sarrangola.class);

                        intent.putExtra("storyTitleData", getArguments().getString(TITLE_KEY));

                        startActivity(intent);

                        break;
                    case "Mabangis na Lungsod":
                        Intent intent2 = new Intent(getContext(), Mabangis.class);

                        intent2.putExtra("storyTitleData", getArguments().getString(TITLE_KEY));

                        startActivity(intent2);

                        break;
                }
            }
        });

        return view;
    }

}
