package ua.anif.oe.oe;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import static ua.anif.oe.oe.utils.NerworkUtils.generateURL;
import static ua.anif.oe.oe.utils.NerworkUtils.getResonseFromURL;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button borgbtn, vvidbtn, urlbutt;
    EditText pole_vvody;
    TextView result;

    SharedPreferences perevirka_info_uzer;
    String SAVED_TEXT = "saved_text";
    String text="777";

    void inic(){
        pole_vvody=findViewById(R.id.pole_vvody);
    }

    class OEQuerryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls){
            String response = null;
            try {
                response = getResonseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }
        @Override
        protected void onPostExecute(String responce){
            result.setText(responce);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        borgbtn = (Button) findViewById(R.id.borgbtn);
        borgbtn.setOnClickListener(this);

        vvidbtn = (Button) findViewById(R.id.vvidbtn);
        vvidbtn.setOnClickListener(this);

        urlbutt = (Button) findViewById(R.id.show_url_button);
        urlbutt.setOnClickListener(this);

        result = (TextView) findViewById(R.id.show_url);

        inic();

    }

    @Override
    public void onClick (View v){
        switch (v.getId()){
            case R.id.show_url_button:
                URL generatedUrl = generateURL(pole_vvody.getText().toString());
                   new OEQuerryTask().execute(generatedUrl);
                break;
            case R.id.borgbtn:
                Intent borgintent = new Intent(this, Borg.class);
                startActivity(borgintent);
                break;
            case R.id.vvidbtn:
                if (pole_vvody.getText().toString().equals(""))
                {
                }
                else
                {
                    String value = pole_vvody.getText().toString();
                    text=value;
                    saveText_info();
                }
                Intent intent = new Intent(this, VvidPokaz.class);
                startActivity(intent);
                break;
            default: break;
        }

    }
    private void saveText_info() {
        perevirka_info_uzer = getSharedPreferences("pasword1234",MODE_PRIVATE);
        SharedPreferences.Editor ed = perevirka_info_uzer.edit();
        ed.putString(SAVED_TEXT,text);
        ed.commit();
    }
}