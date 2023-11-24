package com.teamloopit.e_bookabularyo.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.teamloopit.e_bookabularyo.Activity.StoryActivity;
import com.teamloopit.e_bookabularyo.KwentoAdapter;
import com.teamloopit.e_bookabularyo.KwentoModel;
import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.teamloopit.e_bookabularyo.KwentoAdapter.OnItemClickListener;
public class Home extends Fragment {

    private TextView txtView_UserName;

    private SharedPreferences mPreferences;

    private String sharedPrefFile = "com.teamloopit.e_bookabularyo";


    private String pogressBookTitle;
    private int progressCurrentPosition;
    private int totalFrag;
    ImageView bg;
    private ProgressBar pBar;

    private TextView t;
    public Home() {}
    public LinearLayout ipagpatuloy1, ipagpatuloy2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Initialize(view);


        mPreferences = getContext().getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        pogressBookTitle = mPreferences.getString("currentTitle", "");
        progressCurrentPosition = mPreferences.getInt("currentPage", 0);
        totalFrag = mPreferences.getInt("currentTotalFragment", 0);

        t = view.findViewById(R.id.progressBookTitle);
        pBar = view.findViewById(R.id.progressBarProgress);

        t.setText(pogressBookTitle);
        pBar.setMax(totalFrag);
        pBar.setProgress(progressCurrentPosition);

        bg = view.findViewById(R.id.kwentoBgProgress);


        ipagpatuloy1 = view.findViewById(R.id.main);
        ipagpatuloy2 = view.findViewById(R.id.ituloyKwentoLayout);

        if ("Saranggola".equals(t.getText())) {
            ipagpatuloy1.setVisibility(View.VISIBLE);
            ipagpatuloy2.setVisibility(View.VISIBLE);


            bg.setImageResource(R.drawable.book_pic_one);
        } else if ("Mabangis Na Lungsod".equals(t.getText())) {
            bg.setImageResource(R.drawable.book_pic_two);
            ipagpatuloy1.setVisibility(View.VISIBLE);
            ipagpatuloy2.setVisibility(View.VISIBLE);

        } else {
            ipagpatuloy1.setVisibility(View.INVISIBLE);
            ipagpatuloy2.setVisibility(View.INVISIBLE);
        }

        // Recyclerview for the list view of the kwentos
        RecyclerView kwentoRecyclerView = view.findViewById(R.id.kwentoRecyclerView);

        List<KwentoModel> dataList = new ArrayList<>();
        dataList = KwentoPopulator();

        KwentoAdapter adapter = new KwentoAdapter(dataList);
        kwentoRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        kwentoRecyclerView.setLayoutManager(layoutManager);

        // Listens for item click then start the activity with the title of the kwento
        adapter.setOnItemClickListener(new KwentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(KwentoModel kwentoModel) {

                Intent intent = new Intent(getContext(), StoryActivity.class);

                intent.putExtra("storyTitleData", kwentoModel.getKwentoTitle());

                startActivity(intent);

                Toast.makeText(getContext(), "This is "+kwentoModel.getKwentoTitle(), Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });

        return view;
    }
    /**
     * Method for populating kwento
     */
    private List<KwentoModel> KwentoPopulator()
    {
        List<KwentoModel> list = new ArrayList<>();
        list.add(new KwentoModel(R.drawable.book_pic_one, "Saranggola"));
        list.add(new KwentoModel(R.drawable.book_pic_two, "Mabangis Na Lungsod"));


        return list;
    }

    /**
     * Method for initializing activity data
     */
    private void Initialize(View view)
    {
        Bundle args = getArguments();

        if (args == null) {
            Utilities.ShowCriticalErrorDialog(getContext(), "Failed Argument", "The app failed to get Argument");
            return;
        }

        String data = args.getString("userData", "%ERROR%");

        if(data.isEmpty())
        {
            Utilities.ShowCriticalErrorDialog(getContext(), "Failed Argument", "The argument seems to be empty.");
            return;
        }

        txtView_UserName = view.findViewById(R.id.userName);
        txtView_UserName.setText("Kamusta, " + data);
    }
}