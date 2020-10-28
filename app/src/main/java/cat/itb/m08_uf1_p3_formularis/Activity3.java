package cat.itb.m08_uf1_p3_formularis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonShow = findViewById(R.id.button_show), buttonShare = findViewById(R.id.button_share);

        buttonShow.setOnClickListener(v -> {
            buttonShow.setVisibility(View.GONE);
            showInfo();
        });

        buttonShare.setOnClickListener(v -> {
            share();
        });
    }

    public void showInfo() {
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        if (bundle.getString("radioOption").equals("hola")) {
            message = getString(R.string.hola_message, name, String.valueOf(age));
        } else {
            message = getString(R.string.adeu_message, name, String.valueOf(age + 1));
        }

        sout(message);
    }

    public void sout(String text) {
        Toast.makeText(Activity3.this, text, Toast.LENGTH_LONG).show();
    }

    public void share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}