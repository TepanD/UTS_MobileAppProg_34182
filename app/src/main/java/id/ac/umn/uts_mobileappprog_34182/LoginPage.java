package id.ac.umn.uts_mobileappprog_34182;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    private EditText etLogin;
    private Button btnLogin;
    private static final String INPUT_LOGIN = "id.ac.umn.uts_mobileappprog_34182.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}

        etLogin = findViewById(R.id.et_login);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener((v)->{
            if(etLogin.getText().toString().isEmpty() || etLogin.getText().toString() == " "){
                etLogin.setError("Harap diisi");
            }else{
                Intent intent = new Intent(this, AudioGallery.class);
                String nama_login = etLogin.getText().toString();
                intent.putExtra(INPUT_LOGIN,nama_login);
                startActivity(intent);
            }
        });


    }
}