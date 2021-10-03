package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class AudioGallery extends AppCompatActivity {

    private static final String INPUT_LOGIN = "id.ac.umn.uts_mobileappprog_34182.name";
    RecyclerView rvAudioGallery;
    AudioGalleryAdapter mAdapter;
    LinkedList<AudioObject> audioGallery = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_gallery);

        Intent loginIntent = getIntent();
        String name_login = loginIntent.getStringExtra(INPUT_LOGIN);
        this.getSupportActionBar().setTitle(name_login);
        Toast.makeText(this, name_login, Toast.LENGTH_SHORT).show();

        inputAudio();
        rvAudioGallery = findViewById(R.id.recyclerView);
        mAdapter = new AudioGalleryAdapter(this, audioGallery);
        rvAudioGallery.setAdapter(mAdapter);
        rvAudioGallery.setLayoutManager(new LinearLayoutManager(this));
    }

    private void inputAudio(){
        audioGallery.add(new AudioObject("Arcade Retro Game", "video game", "android.resource://"+ getPackageName() + "/" + R.raw.arcade_retro_game ));
        audioGallery.add(new AudioObject("Clock Countdown Bleeps", "tv", "android.resource://"+ getPackageName() + "/" + R.raw.clock_countdown_bleeps ));
        audioGallery.add(new AudioObject("Dog Bark Twice", "animal", "android.resource://"+ getPackageName() + "/" + R.raw.dog_barking_twice));
        audioGallery.add(new AudioObject("Man Sneeze", "sound effect", "android.resource://"+ getPackageName() + "/" + R.raw.sick_man_sneeze));
        audioGallery.add(new AudioObject("Small Group Cheering and Applause blablablabla", "sound effect", "android.resource://"+ getPackageName() + "/" + R.raw.small_group_cheer_and_applause ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.opt_home_page:
                Intent intent = new Intent(AudioGallery.this, MainActivity.class);
                intent.putExtra("ParentCheck", "true");
                startActivity(intent);
                return true;
            case R.id.opt_profile_page:
                Intent intentProfile = new Intent(AudioGallery.this, ProfilePage.class);
                startActivity(intentProfile);
                return true;
        }
        return true;
    }
}