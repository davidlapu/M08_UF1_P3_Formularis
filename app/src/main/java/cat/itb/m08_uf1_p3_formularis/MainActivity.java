package cat.itb.m08_uf1_p3_formularis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextNom = findViewById(R.id.editTextNom);
        Button buttonNext = findViewById(R.id.act1_next_step);

        buttonNext.setOnClickListener(v -> {
            String editTextIn = editTextNom.getText().toString();
            if (!editTextIn.isEmpty()) {
                name = editTextIn;
                openAct2();
            } else {
                sout(R.string.inName);
            }
        });
    }

    public void sout(int text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public void openAct2() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}