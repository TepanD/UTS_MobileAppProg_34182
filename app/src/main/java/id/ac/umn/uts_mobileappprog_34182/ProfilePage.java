package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toolbar;

public class ProfilePage extends AppCompatActivity {

    private Toolbar mActionBarToolbar;
    private Button btnRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        this.getSupportActionBar().setTitle("Profile");

        btnRepo = findViewById(R.id.btn_repo);
        btnRepo.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/TepanD/UTS_MobileAppProg_34182"));
            startActivity(intent);
        });
    }

    @Override
    public Intent getSupportParentActivityIntent(){
        return getParentActivityIntentImpl();
    }

    @Override
    public Intent getParentActivityIntent() {
        return getParentActivityIntentImpl();
    }

    private Intent getParentActivityIntentImpl() {
        Intent i = null;
        Intent audioGallery = getIntent();

        if (audioGallery.getStringExtra("ParentCheck").equals("true")) {
            i = new Intent(this, AudioGallery.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        } else {
            i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }

        return i;
    }
}