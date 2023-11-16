package com.teamloopit.e_bookabularyo;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Utilities {

    private Utilities() {
    }

    public static void ShowCriticalErrorDialog(final Context context, String errorTitle, String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(errorTitle)
                .setMessage(errorMessage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (context instanceof AppCompatActivity) {
                            ((AppCompatActivity) context).finishAffinity();
                        }
                    }
                })
                .show();
    }
}
