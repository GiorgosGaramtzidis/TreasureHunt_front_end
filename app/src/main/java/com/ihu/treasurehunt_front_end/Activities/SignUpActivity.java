package com.ihu.treasurehunt_front_end.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Dialogs.RegistrationPatternDialog;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.RegisterService;

public class SignUpActivity extends AppCompatActivity {

    private TextView passwordText;
    private TextView passwordText2;
    private TextView userNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userNameText = findViewById(R.id.txtUserName);
        passwordText = findViewById(R.id.txtPassword);
        passwordText2 = findViewById(R.id.txtPassword2);

        TextView btnRegister = findViewById(R.id.btnRegister);
        TextView registrationPattern = findViewById(R.id.btnRegistrationPattern);

        RetroFitCreate retroFitCreate = new RetroFitCreate();
        RegisterService registerService = new RegisterService();
        RegistrationPatternDialog registrationPatternDialog = new RegistrationPatternDialog();

        Intent intent = new Intent(this,SignInActivity.class);

        btnRegister.setOnClickListener(v ->{
                registerService.RegisterUserPost(retroFitCreate
                                .getJsonPlaceHolderAPI()
                                , userNameText.getText().toString()
                                , passwordText.getText().toString(),
                                passwordText2.getText().toString());
                new Handler().postDelayed(() ->
                        Snackbar.make(v,
                                registerService.getAnswer()
                                ,Snackbar.LENGTH_LONG).setAction("Go back", v1 ->
                                startActivity(intent)).show(),1000);
        });

        registrationPattern.setOnClickListener(v ->
                registrationPatternDialog.show(getSupportFragmentManager(),"Registration Rules"));
    }


}