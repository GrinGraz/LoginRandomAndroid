package cl.aiep.login;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Creado por ChristopherR el 06-05-16.
 */
public class Random {

    public static void random1(ArrayList<TextView> botones){
        botones.get(0).setText("3");
        botones.get(1).setText("5");
        botones.get(2).setText("2");
        botones.get(3).setText("9");
        botones.get(4).setText("4");
        botones.get(5).setText("6");
        botones.get(6).setText("8");
        botones.get(7).setText("7");
        botones.get(8).setText("1");
    }

    public static void random2(ArrayList<TextView> botones){
        botones.get(0).setText("1");
        botones.get(1).setText("4");
        botones.get(2).setText("5");
        botones.get(3).setText("8");
        botones.get(4).setText("3");
        botones.get(5).setText("6");
        botones.get(6).setText("2");
        botones.get(7).setText("9");
        botones.get(8).setText("7");
    }

    public static void random3(ArrayList<TextView> botones){
        botones.get(0).setText("8");
        botones.get(1).setText("6");
        botones.get(2).setText("1");
        botones.get(3).setText("7");
        botones.get(4).setText("9");
        botones.get(5).setText("4");
        botones.get(6).setText("2");
        botones.get(7).setText("5");
        botones.get(8).setText("3");
    }
}
