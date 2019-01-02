package ua.anif.oe.oe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;

public class VvidPokaz extends AppCompatActivity {
    TextView viewosob;

    SharedPreferences perevirka_info_uzer;
    String SAVED_TEXT = "saved_text";
    String perevirka_info="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vvid_pokaz);
        loadText_info();
        viewosob=findViewById(R.id.viewosob);
        viewosob.setText(perevirka_info);
    }
    private void loadText_info() {
        perevirka_info_uzer= getSharedPreferences("pasword1234",MODE_PRIVATE);
        perevirka_info = perevirka_info_uzer.getString(SAVED_TEXT,"");
    }
}
