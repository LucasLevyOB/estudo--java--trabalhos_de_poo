package q_1_a;

public class NumeroComplexo {
  private double a, b;

  public double getA() {
    return this.a;
  }

  public double getB() {
    return this.b;
  }

  public void inicializaNumero(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public void imprimeNumero() {
    System.out.printf("%.2f + %.2fi", this.a, this.b);
  }

  public boolean ehIgual(NumeroComplexo numeroComplexo) {
    return this.a == numeroComplexo.getA() && this.b == numeroComplexo.getB();
  }

  public void soma(NumeroComplexo numeroComplexo) {
    this.a += numeroComplexo.getA();
    this.b += numeroComplexo.getB();
  }

  public void subtrai(NumeroComplexo numeroComplexo) {
    this.a -= numeroComplexo.getA();
    this.b -= numeroComplexo.getB();
  }

  public void multiplica(NumeroComplexo numeroComplexo) {
    this.a = this.a * numeroComplexo.getA() - this.b * numeroComplexo.getB();
    this.b = this.a * numeroComplexo.getB() + this.b * numeroComplexo.getA();
  }

  public void divide(NumeroComplexo numeroComplexo) {
    this.a = (this.a * numeroComplexo.getA() + this.b * numeroComplexo.getB()) / (Math.pow(numeroComplexo.getA(), 2) + Math.pow(numeroComplexo.getB(), 2));
    this.b = (this.b * numeroComplexo.getA() - this.a * numeroComplexo.getB()) / (Math.pow(numeroComplexo.getA(), 2) + Math.pow(numeroComplexo.getB(), 2));
  }
  
}