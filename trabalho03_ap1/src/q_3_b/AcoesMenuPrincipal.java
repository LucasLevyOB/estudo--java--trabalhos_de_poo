package q_3_b;

import java.util.Scanner;

import q_2_a.Data;
import q_3_a.Voo;

public class AcoesMenuPrincipal {
    private static Scanner input = new Scanner(System.in);

  static void listarVoos(Voo[] vetorVoos, byte contadorVoos) {
    if (contadorVoos == 0)
      System.out.println("Ainda não existem voos cadastrados.");
      
    for (byte i = 0; i < contadorVoos; i++) {
      System.out.printf("\tReferência %d -> Voo número %d%n", (i + 1), vetorVoos[i].getVoo());
    }
  }

  static byte criarVoo(Voo[] vetorVoos, byte contadorVoos) {
    System.out.print("Digite o número do voo: ");
    short numeroVoo = input.nextShort();
    System.out.print("Digite dia do voo: ");
    byte dia = input.nextByte();
    System.out.print("\bDigite mes do voo: ");
    byte mes = input.nextByte();
    System.out.print("\bDigite ano do voo: ");
    short ano = input.nextShort();

    Data dataVoo = new Data(dia, mes, ano);

    vetorVoos[contadorVoos] = new Voo(numeroVoo, dataVoo);
    contadorVoos++;
    return contadorVoos;
  }
  
  static byte copiarVoo(Voo[] vetorVoos, byte contadorVoos) {
    if (contadorVoos <= 0) {
      System.out.println("Não há voos cadastrados.");
      return 0;
    }
    System.out.println("Escolha um dos voos para copiar");
    listarVoos(vetorVoos, contadorVoos);
    System.out.print("Digite o número de referência do voo: ");
    byte posicao = input.nextByte();
    Voo vooCopiado = vetorVoos[posicao - 1].clone();
    
    vetorVoos[contadorVoos] = vooCopiado;
    contadorVoos++;
    return contadorVoos;
  }

  static Voo escolherVoo(Voo[] vetorVoos, byte contadorVoos) {
    System.out.println("Escolha um dos voos para editar:");
    listarVoos(vetorVoos, contadorVoos);
    System.out.print("Digite o número de referência do voo: ");
    byte posicao = input.nextByte();
    return vetorVoos[posicao - 1];
  }

  static void escreveMenuPrincipal() {
    System.out.println("Digite:");
    System.out.println("\t1 -> Para criar um voo.");
    System.out.println("\t2 -> Para copiar um voo.");
    System.out.println("\t3 -> Para editar um voo.");
    System.out.println("\t4 -> Para listar os voos.");
    System.out.println("\t0 -> Para sair da aplicação.");
  }
}
