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
        StringBuilder sb = new StringBuilder();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        if (bundle.getString("radioOption").equals("hola")) {
            sb.append(getText(R.string.hola)).append(" ");
            sb.append(name).append(", ");
            sb.append(getText(R.string.com_portes)).append(" ");
            sb.append(age).append(" ");
            sb.append(getText(R.string.anys)).append("?");
        } else {
            sb.append(getText(R.string.tornar_veure)).append(" ");
            sb.append(name).append(", ");
            sb.append(getText(R.string.abans_que)).append(" ");
            sb.append(age + 1).append(" ");
            sb.append(getText(R.string.anys));
        }

        message = sb.toString();
        sout(sb.toString());
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