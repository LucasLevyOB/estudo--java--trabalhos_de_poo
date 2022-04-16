package q_3;

class PoligonoRegular {
  byte numeroLados;
  float tamanhoLado;

  boolean verificaNumeroLados(byte numeroLados) {
    return numeroLados >= 3 && numeroLados <= 10;
  }

  void inicializa(byte numeroLados, float tamanhoLado) {
    if (verificaNumeroLados(numeroLados)) {
      this.numeroLados = numeroLados;
      this.tamanhoLado = tamanhoLado;
    } else {
      System.out.println("O polígono deve possuir de 3 a 10 lados.");
    }
  }

  String pegarNome() {
    switch (numeroLados) {
      case 3:
        return "Triangulo";
      case 4:
        return "Quadrado";
      case 5:
        return "Pentágono";
      case 6:
        return "Hexágono";
      case 7:
        return "Heptógono";
      case 8:
        return "Octógono";
      case 9:
        return "Eneágono";
      case 10:
        return "Decágono";
      default:
        return "Está acima";
    }
  }

  double calcularPerimetro() {
    double perimetro = numeroLados * tamanhoLado;
    return perimetro;
  }

  /**
   * Calcula a area de um poligono seguindo a formula
   * @return
   */
  double calcularArea() {
    return (this.numeroLados * Math.pow(this.tamanhoLado, 2)) / (4 * Math.tan(Math.PI / this.numeroLados));
  }

  int calcularDiagonaisMesmoVertice() {
    return this.numeroLados - 3;
  }

  int calcularNumeroTotalDiagonais() {
    return (this.numeroLados * this.calcularDiagonaisMesmoVertice()) / 2;
  }

  public static void main(String[] args) throws Exception {
    PoligonoRegular pR1 = new PoligonoRegular();
    pR1.inicializa((byte) 7, 4);
    System.out.printf("Esse é um: %s.%n", pR1.pegarNome());
    System.out.printf("De perímetro igual a: %.2f.%n", pR1.calcularPerimetro());
    System.out.printf("De área igual a: %.2f.%n", pR1.calcularArea());
    System.out.printf("Com %d diagonais em um vertice.%n", pR1.calcularDiagonaisMesmoVertice());
    System.out.printf("Com um total de %d diagonais.%n", pR1.calcularNumeroTotalDiagonais());
  }
}
