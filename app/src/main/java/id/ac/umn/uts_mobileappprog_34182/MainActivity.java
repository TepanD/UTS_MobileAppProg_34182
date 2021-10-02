package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ProfileButton, LibraryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}

        ProfileButton = findViewById(R.id.btn_profile);
        LibraryButton = findViewById(R.id.btn_library);

        ProfileButton.setOnClickListener((v)->{
            Intent intent = new Intent(this, ProfilePage.class);
            startActivity(intent);
        });
    }

}