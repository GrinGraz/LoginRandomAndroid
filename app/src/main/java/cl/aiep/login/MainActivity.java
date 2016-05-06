package cl.aiep.login;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1) TextView btn1;
    @BindView(R.id.btn2) TextView btn2;
    @BindView(R.id.btn3) TextView btn3;
    @BindView(R.id.btn4) TextView btn4;
    @BindView(R.id.btn5) TextView btn5;
    @BindView(R.id.btn6) TextView btn6;
    @BindView(R.id.btn7) TextView btn7;
    @BindView(R.id.btn8) TextView btn8;
    @BindView(R.id.btn9) TextView btn9;
    @BindView(R.id.pantalla) TextView pantalla;

    int passwordUsuario;
    String textoPantalla = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 })
    public void seleccionado(View view) {
        switch (view.getId()){
            case R.id.btn1:
                btn1.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn1, 1);
                break;
            case R.id.btn2:
                btn2.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn2, 2);
                break;
            case R.id.btn3:
                btn3.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn3, 3);
                break;
            case R.id.btn4:
                btn4.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn4, 3);
                break;
            case R.id.btn5:
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn5, 2);
                break;
            case R.id.btn6:
                btn6.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn6, 1);
                break;
            case R.id.btn7:
                btn7.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn7, 2);
                break;
            case R.id.btn8:
                btn8.setPressed(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn8, 3);
                break;
            case R.id.btn9:
                btn9.setPressed(true);
                btn9.setSelected(true);
                escribirNumerosPantalla((TextView) view);
                obtenerValorVerificar(btn9, 1);
                break;
        }
    }

    private void obtenerValorVerificar(TextView view, int randomer) {
        passwordUsuario = passwordUsuario + Integer.parseInt(view.getText().toString());
        int PASSWORD_SISTEMA = 16;
        if (passwordUsuario == PASSWORD_SISTEMA) logueado();
        else if (passwordUsuario > PASSWORD_SISTEMA) cerrar();
        else random(2 * randomer);
    }

    private void escribirNumerosPantalla(TextView view){
        textoPantalla = "";
        textoPantalla =   pantalla.getText().toString() + view.getText().toString();
        pantalla.setText(textoPantalla);
    }

    private void cerrar() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                finish();
            }
        };
        Toast.makeText(MainActivity.this, "ACCESO DENEGADO", Toast.LENGTH_LONG).show();
        handler.postDelayed(r, 1000);
    }

    private void logueado() {
        Logueado logueado = new Logueado();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.container, logueado);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void random(int numero){
        switch (numero){
            case 2:
                random1();
                break;
            case 4:
                random2();
                break;
            case 6:
                random3();
        }
    }

    private void random3() {
        btn1.setText("3");
        btn2.setText("5");
        btn3.setText("2");
        btn4.setText("9");
        btn5.setText("4");
        btn6.setText("6");
        btn7.setText("8");
        btn8.setText("7");
        btn9.setText("1");
    }

    private void random2() {
        btn1.setText("1");
        btn2.setText("4");
        btn3.setText("5");
        btn4.setText("8");
        btn5.setText("3");
        btn6.setText("6");
        btn7.setText("2");
        btn8.setText("9");
        btn9.setText("7");
    }

    private void random1() {
        btn1.setText("8");
        btn2.setText("6");
        btn3.setText("1");
        btn4.setText("7");
        btn5.setText("9");
        btn6.setText("4");
        btn7.setText("2");
        btn8.setText("5");
        btn9.setText("3");
    }

    public void salir(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void reiniciar(View view) {
        passwordUsuario = 0;
        pantalla.setText("");
    }
}