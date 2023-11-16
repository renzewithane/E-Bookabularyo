package com.teamloopit.e_bookabularyo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamloopit.e_bookabularyo.R;
import com.teamloopit.e_bookabularyo.Utilities;

import org.w3c.dom.Text;

public class Home extends Fragment {

    private TextView txtView_UserName;
    public Home() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Initialize(view);

        return view;
    }

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