package com.teamloopit.e_bookabularyo.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teamloopit.e_bookabularyo.Activity.Mabangis;
import com.teamloopit.e_bookabularyo.Activity.MabangisQA;
import com.teamloopit.e_bookabularyo.Activity.QuizActivity;
import com.teamloopit.e_bookabularyo.KwentoAdapter;
import com.teamloopit.e_bookabularyo.KwentoModel;
import com.teamloopit.e_bookabularyo.R;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends Fragment {


    public Quiz() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

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

                Toast.makeText(getContext(), "This is "+ kwentoModel.getKwentoTitle() + " Quiz ", Toast.LENGTH_SHORT).show();

                if (kwentoModel.getKwentoTitle()=="Sarranggola"){
                    Intent intent = new Intent(getContext(), QuizActivity.class);

                    intent.putExtra("storyTitleData", kwentoModel.getKwentoTitle());

                    startActivity(intent);
                    Toast.makeText(getContext(), "This is "+ kwentoModel.getKwentoTitle() + " Quiz ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getContext(), Mabangis.class);

                    intent.putExtra("storyTitleData", kwentoModel.getKwentoTitle());

                    startActivity(intent);
                    Toast.makeText(getContext(), "This is "+ kwentoModel.getKwentoTitle() + " Quiz ", Toast.LENGTH_SHORT).show();

                }
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
        list.add(new KwentoModel(R.drawable.book_pic_one, "Sarranggola"));
        list.add(new KwentoModel(R.drawable.book_pic_two, "Mabangis Na Lungsod"));
        list.add(new KwentoModel(R.drawable.watdahill, "What the Duck is this"));

        return list;
    }
}