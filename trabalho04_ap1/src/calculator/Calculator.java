package calculator;

import java.text.DecimalFormat;
import java.util.Locale;

public class Calculator {
    private int batteryMax;
    private int battery;
    private float display;

    //Inicia os atributos, battery e display começam com o zero.
    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0;
    }

    //Aumenta a bateria, porém não além do máximo.
    public void chargeBattery(int value) {
        if (value <= 0)
            this.battery += 0;
        if ((this.battery + value) >= this.batteryMax)
            this.battery = this.batteryMax;
        else
            this.battery += value;
    }

    //Tenta gastar uma unidade da bateria e emite um erro se não conseguir.
    public boolean useBattery() {
        if (this.battery < 1) {
            System.out.println("fail: bateria insuficiente");
            return false;
        }
        this.battery--;
        return true;
    }

    //Se conseguir gastar bateria, armazene a soma no atributo display.
    public void sum(int a, int b) {
        if (useBattery())
            this.display = a + b;
    }

    public void subtract(int a, int b) {
        if (useBattery())
            this.display = a - b;
    }
    
    //Se conseguir gastar bateria e não for divisão por 0.
    public void division(int num, int den) {
        if (den == 0)
            System.out.println("fail: divisao por zero");
        else if (useBattery())
            this.display = num / (den * 1.0f);
    }

    public void multiply(int a, int b) {
        if (useBattery())
            this.display = a * b;
    }

    //Retorna o conteúdo do display com duas casas decimais.
    public String toString() {
        Locale.setDefault(Locale.US);
        DecimalFormat displayFormatado = new DecimalFormat("0.00");
        String texto = "display = ";
        texto += displayFormatado.format(this.display);
        texto += ", battery = ";
        texto += this.battery;
        return texto;
    }
}