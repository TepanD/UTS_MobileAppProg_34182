package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

public class ProfilePage extends AppCompatActivity {

    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        this.getSupportActionBar().setTitle("Profile");
    }
}