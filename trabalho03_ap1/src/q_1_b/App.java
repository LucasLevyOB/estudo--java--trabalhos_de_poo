package q_1_b;

import q_1_a.NumeroComplexo;

public class App {
  public static void main(String[] args) {
    System.out.println();
    System.out.println("Inicializar nC1");
    NumeroComplexo nC1 = new NumeroComplexo();
    nC1.inicializaNumero(4, 7);
    System.out.print("O número complexo de nC1 é: ");
    nC1.imprimeNumero();
    System.out.println();

    // soma
    System.out.println();
    System.out.println("Operação soma.");
    NumeroComplexo somarAoNC1 = new NumeroComplexo();
    somarAoNC1.inicializaNumero(8, 3);
    System.out.println("Ao somar somarAoNC1, com nC1, temos: ");
    nC1.soma(somarAoNC1);
    nC1.imprimeNumero();
    System.out.println();

    // subtracao
    System.out.println();
    System.out.println("Operação subtrair.");
    NumeroComplexo subtrairDoNC1 = new NumeroComplexo();
    subtrairDoNC1.inicializaNumero(2, 1);
    System.out.println("Ao subtrair subtrairDoNC1, de nC1, temos: ");
    nC1.subtrai(subtrairDoNC1);
    nC1.imprimeNumero();
    System.out.println();

    // multiplicar
    System.out.println();
    System.out.println("Operação multiplicar.");
    NumeroComplexo multiplicarNC1 = new NumeroComplexo();
    multiplicarNC1.inicializaNumero(3, 4);
    System.out.println("Ao multiplicar nC1 por multiplicarNC1, temos: ");
    nC1.multiplica(multiplicarNC1);
    nC1.imprimeNumero();
    System.out.println();

    // multiplicar
    System.out.println();
    System.out.println("Operação dividir.");
    NumeroComplexo dividirNC1 = new NumeroComplexo();
    dividirNC1.inicializaNumero(2, 3);
    System.out.println("Ao dividir nC1 por dividirNC1, temos: ");
    nC1.divide(dividirNC1);
    nC1.imprimeNumero();
    System.out.println();

  }
}
