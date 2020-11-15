package com.example.tourisminukraine;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Collections;
import java.util.List;

public class SignInEmail extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7878;
    List<AuthUI.IdpConfig> providers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email);

        providers = Collections.singletonList(new AuthUI.IdpConfig.EmailBuilder().build());

        showSignInOptions();
    }

    private void showSignInOptions() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.logo_eat_it)
                        .setTheme(R.style.MyTheme)
                        .build(), MY_REQUEST_CODE
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE)
        {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK)
            {
                //Get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //show email on Toast
                Toast.makeText(this, "Вітаємо "+user.getEmail(), Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(SignInEmail.this, HomeActivity.class);
                startActivity(homeIntent);
            }
            else
            {
                if (resultCode == RESULT_OK){
                    Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();

                }
                else
                {
                    showSignInOptions();
                }

            }
        }
    }
}