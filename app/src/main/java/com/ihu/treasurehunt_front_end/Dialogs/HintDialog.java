package com.ihu.treasurehunt_front_end.Dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.ihu.treasurehunt_front_end.Activities.MainActivity;

public class HintDialog extends AppCompatDialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hint")
                .setMessage("The quest is close to: " + MainActivity.game.getLocation().getTitle())
                .setPositiveButton("ok", (dialog, which) -> {

                });
        return builder.create();
    }
}
