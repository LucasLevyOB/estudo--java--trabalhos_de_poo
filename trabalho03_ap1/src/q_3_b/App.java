package q_3_b;

import java.util.Scanner;
import q_3_a.Voo;

public class App {
  private static Scanner input = new Scanner(System.in);
  private static byte contadorVoos = 0;
  private static Voo vooAtual;
  private static byte acaoMenuPrincipal = -1;

  static void acoesVoo(byte tipo, Voo voo) {
    switch (tipo) {
    case 0:
      acaoMenuPrincipal = -1;
      System.out.println("Você saiu do menu do voo, até logo!");
      break;
    case 1:
      System.out.println("O número do voo é: " + voo.getVoo());
      break;
    case 2:
      AcoesMenuVoo.escreveData(voo.getData());
      break;
    case 3:
      System.out.println("Existem " + voo.vagas() + " cadeiras vagas nesse voo.");
      break;
    case 4:
      AcoesMenuVoo.verificarCadeiraVaga(voo);
      break;
    case 5:
      AcoesMenuVoo.ocuparCadeira(voo);
      break;
    case 6:
      AcoesMenuVoo.proximaCadeiraLivre(voo);
      break;
    default:
      System.out.println("Por favor, aigite uma ação válida.");
      break;
    }
  }

  static void acoesPrincipal(byte tipo, Voo[] vetorVoos) {
    switch (tipo) {
      case 0:
        System.out.println("Até a próxima! ;)");
        break;
      case 1:
        contadorVoos = AcoesMenuPrincipal.criarVoo(vetorVoos, contadorVoos);
        break;
      case 2:
        contadorVoos = AcoesMenuPrincipal.copiarVoo(vetorVoos, contadorVoos);
        break;
      case 3:
        if (contadorVoos == 0) {
          System.out.println("Ainda não existem voos cadastrados, cadastre alguns e tente novamente.");
          acaoMenuPrincipal = -1;
          break;
        }
        vooAtual = AcoesMenuPrincipal.escolherVoo(vetorVoos, contadorVoos);
        if (vooAtual == null) {
          acaoMenuPrincipal = -1;
          System.out.println("Por favor selecione uma refência válida.");
        }
        break;
      case 4:
        System.out.println("Lista de voos cadastrados:");
        AcoesMenuPrincipal.listarVoos(vetorVoos, contadorVoos);
        break;
      default:
        System.out.println("Por favor, aigite uma ação válida.");
        break;
    }
  }
  
  public static void main(String[] args) {
    byte acaoMenuVoo = -1;
    Voo[] vetorVoos = new Voo[10];
    

    while (acaoMenuPrincipal != 0) {
      System.out.println("########------########");
      if (acaoMenuPrincipal == 3) {
        System.out.printf("Você está editando o voo de número: %d%n", vooAtual.getVoo());
        AcoesMenuVoo.escreveMenuVoo();
        System.out.print("\bDigite o número correspondente: ");
        acaoMenuVoo = input.nextByte();
        System.out.println();
        acoesVoo(acaoMenuVoo, vooAtual);
      } else {
        System.out.println("Menu principal.");
        System.out.println("O limite máximo de voos cadastrados são 10.");
        AcoesMenuPrincipal.escreveMenuPrincipal();
        System.out.print("\bDigite o número correspondente: ");
        acaoMenuPrincipal = input.nextByte();
        System.out.println();
        acoesPrincipal(acaoMenuPrincipal, vetorVoos);
      }
      System.out.println();
    }
  }

}
