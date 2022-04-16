/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item C da 2ª questão
 */

package q_2_c;

import java.util.Locale;

import q_2_a.Ponto2D;

class Linha {
  Ponto2D pontoInicial = new Ponto2D();
  Ponto2D pontoFinal = new Ponto2D();

  void inicializaLinha(float x1, float y1, float x2, float y2) {
    pontoInicial.inicializaPonto(x1, y1);
    pontoFinal.inicializaPonto(x2, y2);
  }

  /**
   * Calcula o tamanho da linha e retorna
   * @return
   */
  double calcularTamanhoLinha() {
    double somaQuadrados = Math.pow(this.pontoFinal.pegarX() - this.pontoInicial.pegarX(), 2)
        + Math.pow(this.pontoFinal.pegarY() - this.pontoInicial.pegarY(), 2);
    return Math.sqrt(somaQuadrados);
  }

  void escrevePosicao() {
    System.out.printf("(%.2f, %.2f) : (%.2f, %.2f)", this.pontoInicial.pegarX(), this.pontoInicial.pegarY(), this.pontoFinal.pegarX(), this.pontoFinal.pegarY());
  }
  
  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Linha l1 = new Linha();
    l1.inicializaLinha(1, 1, 7, 7);
    System.out.printf("A o tamanho da linha é: %.2f%n", l1.calcularTamanhoLinha());
    l1.escrevePosicao();
    System.out.println();
  }
 
}
