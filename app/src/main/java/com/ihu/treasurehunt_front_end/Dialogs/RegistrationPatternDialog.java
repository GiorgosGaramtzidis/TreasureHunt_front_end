package com.ihu.treasurehunt_front_end.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;



public class RegistrationPatternDialog extends AppCompatDialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Registration Rules")
                .setMessage("Password Rules : \n" +"1.At least 8 chars  \n"+
                        "2.Contains at least one digit \n"+"3.Contains at least one lower alpha char and one upper alpha char\n"
                        +"4.Contains at least one char within a set of special chars\n"
                        +"5.Contains at least one Upper alpha char and one upper alpha char"
                        +"6.no whitespace allowed in the entire string"
                        +"\n"+
                        "UserName Rules\n"+
                        "1.Contains at least one digit \n"+
                        "2.Contains at least one lower alpha char and one upper alpha char\n"+
                        "3.Contains at least one Upper alpha char and one upper alpha char\n"+
                        "4.At least 6 chars");
        return builder.create();
    }
}
