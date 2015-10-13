package stockapp.jaianedantas.com.br.stockapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import stockapp.jaianedantas.com.br.stockapp.activities.MainActivity;


public class Splash extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler tela = new Handler();
        tela.postDelayed((Runnable) this, Integer.parseInt(getString(R.string.tempoSplash)));
    }

    @Override
    public void run(){
        startActivity(new Intent(this, MainActivity.class) );
        finish();
    }

}
