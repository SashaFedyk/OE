package ua.anif.oe.oe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Borg extends AppCompatActivity implements OnClickListener {
    Button webBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borg);

        webBtn = (Button) findViewById(R.id.btnWeb);
        webBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWeb:
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.oe.if.ua/"));
                startActivity(webintent);
                break;
            default: break;
        }
    }
}