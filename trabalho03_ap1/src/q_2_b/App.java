package q_2_b;

import q_2_a.Data;

public class App {

  static void anoBissexto(Data data, String nomeData) {
    System.out.printf("O ano %d, que pertence a %s, ", data.getAno(), nomeData);
    if (data.isBissexto())
      System.out.printf("é um ano bissexto.%n");
    else
      System.out.printf("não é um ano bissexto.%n");
  }

  static void compararDatas(Data dataComparada, Data dataParaComparar) {
    System.out.printf("A data(dataComparada): %d/%d/%d é ", dataComparada.getDia(), dataComparada.getMes(), dataComparada.getAno());
    if (dataComparada.compara(dataParaComparar) == 0)
      System.out.print("igual a data(dataParaComparar): ");
    else if (dataComparada.compara(dataParaComparar) == 1)
      System.out.print("maior que a data(dataParaComparar): ");
    else
      System.out.print("menor que a data(dataParaComparar): ");

    System.out.printf("%d/%d/%d.%n", dataParaComparar.getDia(),
          dataParaComparar.getMes(), dataParaComparar.getAno());
  }

  public static void main(String[] args) {
    System.out.println();
    System.out.println("Declarar data1");
    Data data1 = new Data((byte) 26, (byte) 10, (short) 2021);
    System.out.printf("data1 foi criada: %d/%d/%d%n", data1.getDia(), data1.getMes(), data1.getAno());

    System.out.println();
    System.out.println("Operação getMesExtenso.");
    System.out.println("O mês corrente na data1, por extenso, é: " + data1.getMesExtenso());

    // comparar as datas
    System.out.println();
    System.out.println("Operação compara.");
    compararDatas(data1, new Data((byte) 26, (byte) 10, (short) 2021));
    compararDatas(data1, new Data((byte) 27, (byte) 12, (short) 2021));
    compararDatas(data1, new Data((byte) 2, (byte) 1, (short) 2021));
    // fim comparar datas

    System.out.println();
    System.out.println("Operação isBissexto.");
    anoBissexto(new Data((byte) 12, (byte) 2, (short) 2016), "data3");
    anoBissexto(new Data((byte) 12, (byte) 2, (short) 2021), "data4");
    
    System.out.println();
    System.out.println("Operação clone.");
    Data cloneData1 = data1.clone();
    System.out.printf("Esse é um clone(cloneData1) da data1: %d/%d/%d.%n", cloneData1.getDia(), cloneData1.getMes(), cloneData1.getAno());
  }
}
