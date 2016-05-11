package cl.aiep.login;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)    TextView    btn1;
    @BindView(R.id.btn2)    TextView    btn2;
    @BindView(R.id.btn3)    TextView    btn3;
    @BindView(R.id.btn4)    TextView    btn4;
    @BindView(R.id.btn5)    TextView    btn5;
    @BindView(R.id.btn6)    TextView    btn6;
    @BindView(R.id.btn7)    TextView    btn7;
    @BindView(R.id.btn8)    TextView    btn8;
    @BindView(R.id.btn9)    TextView    btn9;
    @BindView(R.id.pantalla)TextView       pantalla;
    @BindView(R.id.progressBar)ProgressBar progressBar;
    @BindView(R.id.usuario) EditText        textoUsuario;
    @BindView(R.id.cordinatorLayout) CoordinatorLayout cordinatorLayout;

    private final int RANDOM_1 = 1;
    private final int RANDOM_2 = 2;
    private final int RANDOM_3 = 3;
    private final int RANDOM_4 = 4;
    private final int RANDOM_5 = 5;
    private final int RANDOM_6 = 6;
    private final int RANDOM_7 = 7;
    private final int RANDOM_8 = 8;
    private final int RANDOM_9 = 9;

    private final int CLAVE_ABDON = 10;
    private final int CLAVE_SEBA = 12;
    private final int CLAVE_YALE = 14;
    private final int CLAVE_ROBER = 16;
    private final int CLAVE_GRIN = 18;

    private int     passwordUsuario;
    private int     passwordSistema;
    private boolean trampa;
    private String  usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        desbloquearBotonera(false);
    }

    private void desbloquearBotonera(boolean estado){
        btn1.setEnabled(estado);
        btn2.setEnabled(estado);
        btn3.setEnabled(estado);
        btn4.setEnabled(estado);
        btn5.setEnabled(estado);
        btn6.setEnabled(estado);
        btn7.setEnabled(estado);
        btn8.setEnabled(estado);
        btn9.setEnabled(estado);
    }

    @OnClick({ R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 })
    public void pulsarBoton(View view) {
        switch (view.getId()){
            case R.id.btn1:
                obtenerValorVerificar(btn1, RANDOM_1);
                break;
            case R.id.btn2:
                obtenerValorVerificar(btn2, RANDOM_2);
                break;
            case R.id.btn3:
                obtenerValorVerificar(btn3, RANDOM_3);
                break;
            case R.id.btn4:
                obtenerValorVerificar(btn4, RANDOM_4);
                break;
            case R.id.btn5:
                obtenerValorVerificar(btn5, RANDOM_5);
                break;
            case R.id.btn6:
                obtenerValorVerificar(btn6, RANDOM_6);
                break;
            case R.id.btn7:
                obtenerValorVerificar(btn7, RANDOM_7);
                break;
            case R.id.btn8:
                obtenerValorVerificar(btn8, RANDOM_8);
                break;
            case R.id.btn9:
                obtenerValorVerificar(btn9, RANDOM_9);
                break;
        }
    }

    private void obtenerUsuario(){
        usuario = textoUsuario.getText().toString();
    }

    private void obtenerValorVerificar(TextView view, int randomer) {
        escribirNumerosPantalla(view);
        passwordUsuario = passwordUsuario + Integer.parseInt(view.getText().toString());
        if (passwordUsuario == passwordSistema) loguear();
        else if (passwordUsuario > passwordSistema) cerrar();
        else randomizer(2 * randomer);
    }

    private void escribirNumerosPantalla(TextView view){
        String textoPantalla = "";
        textoPantalla = pantalla.getText().toString() + view.getText().toString();
        pantalla.setText(textoPantalla);
    }

    private void loguear() {
        Logueado logueado = new Logueado();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.container, logueado);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void cerrar() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                finish();
            }
        };
        Snackbar.make(cordinatorLayout, "ACCESO DENEGADO", Snackbar.LENGTH_LONG)
                .show();
        handler.postDelayed(r, 1000);
    }

    private void randomizer(int opcionRandom){
        switch (opcionRandom){
            case 2:
                Random.random1(armarArrayBotones());
                break;
            case 4:
                Random.random2(armarArrayBotones());
                break;
            case 6:
                Random.random3(armarArrayBotones());
                break;
            case 8:
                Random.random4(armarArrayBotones());
                break;
            case 10:
                Random.random5(armarArrayBotones());
                break;
            case 12:
                Random.random6(armarArrayBotones());
                break;
            case 14:
                Random.random7(armarArrayBotones());
                break;
            case 16:
                Random.random8(armarArrayBotones());
                break;
            case 18:
                Random.random9(armarArrayBotones());
                break;
        }
    }

    public void salir(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void reiniciarAcceso(View view) {
        passwordUsuario = 0;
        pantalla.setText("");
    }

    public void leerHuella(View view) {
        obtenerUsuario();
        if (!trampa) desbloquearUsuario("SISTEMA BLOQUEADO", 0);
        else {
            switch (usuario){
                case "abdon":
                    desbloquearUsuario("Bienvenido Abdon, ingrese codigo acceso", CLAVE_ABDON);
                    break;
                case "sebastian":
                    desbloquearUsuario("Bienvenido Sebastian, ingrese codigo acceso", CLAVE_SEBA);
                    break;
                case "yaleni":
                    desbloquearUsuario("Bienvenida Yaleni, ingrese codigo acceso", CLAVE_YALE);
                    break;
                case "roberto":
                    desbloquearUsuario("Bienvenido Roberto, ingrese codigo acceso", CLAVE_ROBER);
                    break;
                case "":
                    desbloquearUsuario("SISTEMA DESBLOQUEADO", CLAVE_GRIN);
                    break;
                default:
                    desbloquearUsuario("Usuario no existe", -1);
                    break;
            }
        }
    }

    private void desbloquearUsuario(final String mensaje, final int claveUsuarioSistema){
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(cordinatorLayout, mensaje, Snackbar.LENGTH_SHORT);
                View sbView = snackbar.getView();
                TextView textoSnackBar = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                if (mensaje.contains("SISTEMA BLOQUEADO")) textoSnackBar.setTextColor(Color.RED);
                else textoSnackBar.setTextColor(Color.GREEN);
                snackbar.show();
                passwordSistema = claveUsuarioSistema;
                desbloquearBotonera(true);
            }
        };
        progressBar.setVisibility(View.VISIBLE);
        handler.postDelayed(r, 1000);
    }

    public void trampita(View view) {
        trampa = true;
    }

    private ArrayList<TextView> armarArrayBotones(){
        ArrayList<TextView> botones =  new ArrayList<>();
        botones.add(btn1);
        botones.add(btn2);
        botones.add(btn3);
        botones.add(btn4);
        botones.add(btn5);
        botones.add(btn6);
        botones.add(btn7);
        botones.add(btn8);
        botones.add(btn9);
        return botones;
    }
}