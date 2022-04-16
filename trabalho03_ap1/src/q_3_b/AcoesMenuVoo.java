package q_3_b;

import java.util.Scanner;

import q_2_a.Data;
import q_3_a.Voo;

public class AcoesMenuVoo {
  private static Scanner input = new Scanner(System.in);

  static void verificarCadeiraVaga(Voo voo) {
    System.out.println("Verificar se uma cadeira está vaga.");
    System.err.print("\bDigite o número da cadeira: ");
    byte numCadeira = input.nextByte();
    if (voo.verifica(numCadeira))
      System.out.println("Está cadeira está ocupada.");
    else
      System.out.println("Está cadeira está livre.");
  }

  static void escreveData(Data data) {
    System.out.printf("Data do voo é: %d/%d/%d%n", data.getDia(), data.getMes(), data.getAno());
  }

  static void ocuparCadeira(Voo voo) {
    System.out.println("Ocupar cadeira.");
    System.err.print("\bDigite o número da cadeira: ");
    byte numCadeira = input.nextByte();
    if (voo.ocupa(numCadeira))
      System.out.println("Cadeira ocupada com sucesso.");
    else {
      System.out.printf("A cadeira %d já está ocupada, tente outra.%n", numCadeira);
      proximaCadeiraLivre(voo, numCadeira);
    }
  }

  static void proximaCadeiraLivre(Voo voo) {
    System.out.println("Próxima cadeira livre.");
    System.err.print("\bA partir de qual cadeira você quer verificar: ");
    byte numCadeira = input.nextByte();
    byte resultadoBusca = voo.proximoLivre(numCadeira);
    if (resultadoBusca == -1)
      System.out.println("Não temos cadeiras vagas a partir desse assento.");
    else
      System.out.println("A cadeira mais próxima é a de número: " + resultadoBusca);
  }

  static void proximaCadeiraLivre(Voo voo, byte numCadeira) {
    byte resultadoBusca = voo.proximoLivre(numCadeira);
    if (resultadoBusca == -1)
      System.out.println("Não temos mais cadeiras vagas a partir desse assento.");
    else
      System.out.println("A cadeira livre mais próxima, é a: " + resultadoBusca);
      System.out.println("Tente ela da próxima.");
  }
  
  static void escreveMenuVoo() {
    System.out.println("Digite:");
    System.out.println("\t1 -> Para ver o número do voo.");
    System.out.println("\t2 -> Para ver a data do voo.");
    System.out.println("\t3 -> Para ver a quantidade de cadeiras vagas.");
    System.out.println("\t4 -> Para ver se uma cadeira específica está vaga.");
    System.out.println("\t5 -> Para ocupar uma cadeira específica.");
    System.out.println("\t6 -> Para ver a próxima cadeira livre.");
    System.out.println("\t0 -> Para voltar ao menu principal.");
  }
}
