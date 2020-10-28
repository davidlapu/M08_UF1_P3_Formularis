package cat.itb.m08_uf1_p3_formularis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private String radioOpcio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SeekBar seekBar = findViewById(R.id.seek_bar);
        TextView textViewBar = findViewById(R.id.text_view_bar);
        Button button = findViewById(R.id.button_show);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewBar.setText(String.valueOf(progress));
                if (validAge(progress)) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                if (!validAge(progress)) {
                    sout(R.string.minAge);
                }
            }
        });

        button.setOnClickListener(v -> {
            int age = seekBar.getProgress();
            if (validAge(age) && !(radioOpcio == null)) {
                openAct3(age);
            } else {
                sout(R.string.minAge);
            }
        });

    }

    public boolean validAge(int age) {
        boolean valid;

        valid = age >= 18 && age <= 60;
        return valid;
    }

    public void sout(int text) {
        Toast.makeText(Activity2.this, text, Toast.LENGTH_SHORT).show();
    }

    public void openAct3(int age) {
        Bundle bundle = getIntent().getExtras();
        Intent intent = new Intent(Activity2.this, Activity3.class);

        intent.putExtra("name", bundle.getString("name"));
        intent.putExtra("age", age);
        intent.putExtra("radioOption", radioOpcio);

        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_button_hola:
                if (checked)
                    radioOpcio = "hola";
                    break;
            case R.id.radio_button_adeu:
                if (checked)
                    radioOpcio = "adeu";
                    break;
        }
    }
}
