
/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item B da 2ª questão
 */

package q_2_b;

import q_2_a.Ponto2D;

class Retangulo {
  Ponto2D pontoInicial = new Ponto2D();
  Ponto2D pontoOposto = new Ponto2D();
  float altura;

  void inicializaRetangulo(float x1, float y1, float x2, float y2, float altura) {
    pontoInicial.inicializaPonto(x1, y1);
    pontoOposto.inicializaPonto(x2, y2);
    this.altura = altura;
  }

  /**
   * Calcula a distância entre os pontos opostos do retangulo em um plano cartesiano imaginário, usado para calcular a hipotenusa
   * @return
   */
  double calcularDistanciaOpostos() {
    double somaQuadrados = Math.pow(this.pontoOposto.pegarX() - this.pontoInicial.pegarX(), 2)
        + Math.pow(this.pontoOposto.pegarY() - this.pontoInicial.pegarY(), 2);
    return Math.sqrt(somaQuadrados);
  }
  
  /**
   * Retorna a base do retangulo
   * @param hipotenusa Pode ser o resultado de calcularDistanciaOpostos
   * @return
   */
  double pegarBaseRetangulo(double hipotenusa) {
    return Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(this.altura, 2));
    
  }

  double calcularArea() {
    // Nesse caso, calcularDistanciaOpostos será usado como a hipotenusa
    double hipotenusa = calcularDistanciaOpostos();
    double catetoOposto = pegarBaseRetangulo(hipotenusa);
    double areaRetangulo = catetoOposto * this.altura;
    return areaRetangulo;
  }

  double calcularPerimetro() {
    double hipotenusa = calcularDistanciaOpostos();
    double catetoOposto = pegarBaseRetangulo(hipotenusa);
    double perimetroRetangulo = 2 * (catetoOposto + this.altura);
    return perimetroRetangulo;
  }
  
  public static void main(String[] args) throws Exception {
    Retangulo r1 = new Retangulo();
    r1.inicializaRetangulo(1, 1, 7, 7, 7);
    System.out.printf("A área do retangulo é: %.2f%n", r1.calcularArea());
    System.out.printf("O perimetro do retangulo é: %.2f%n", r1.calcularPerimetro());
  }
    
}
