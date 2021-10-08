package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AudioPlayer extends AppCompatActivity {
    private TextView tvAudioTitle;
    private TextView tvAudioCategory;
    private String AudioUri;
    private Button btnPlay;
    MediaPlayer player;
    private static final String AUDIO_DETAIL_KEY = "id.ac.umn.uts_mobileappprog_34182.audio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        tvAudioTitle = findViewById(R.id.tv_audio_title_detail);
        tvAudioCategory = findViewById(R.id.tv_audio_category_detail);
        btnPlay = findViewById(R.id.btn_play);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        AudioObject audio = (AudioObject) bundle.getSerializable(AUDIO_DETAIL_KEY);

        this.getSupportActionBar().setTitle(audio.getTitle());

        tvAudioTitle.setText(audio.getTitle());
        tvAudioCategory.setText(audio.getCategory());
        AudioUri = audio.getAudioURI();

        btnPlay.setOnClickListener((v)->{
            play(v, AudioUri);
        });
    }

    public void play(View v, String AudioUri){
        if(player == null){
            player = MediaPlayer.create(this, Uri.parse(AudioUri));
        }
        player.start();
    }

    @Override
    public void onBackPressed() {
        if(player != null){
            if(player.isPlaying()){
                player.stop();
            }
            player.release();
            player = null;
        }
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(player != null){
                    if(player.isPlaying()){
                        player.stop();
                    }
                    player.release();
                    player = null;
                }
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}