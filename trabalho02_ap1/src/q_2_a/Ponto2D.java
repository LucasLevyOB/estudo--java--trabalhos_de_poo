/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item A da 2ª questão
 */

package q_2_a;

import java.util.Locale;

// Essa classe é pública porque precisa ser instanciada em outra classe que está fora do pacote
public class Ponto2D {
  float x, y;

  public void inicializaPonto(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float pegarX() {
    return this.x;
  }

  public float pegarY() {
    return this.y;
  }

  void escreveCoordenadas() {
    System.out.printf("(%.2f, %.2f)", x, y);
  }

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Ponto2D p1 = new Ponto2D();
    p1.inicializaPonto((byte) 10, (byte) 57);
    p1.escreveCoordenadas();
    System.out.println();
  }
 
}
