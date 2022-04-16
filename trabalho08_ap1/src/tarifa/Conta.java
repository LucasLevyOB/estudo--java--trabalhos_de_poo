package tarifa;

import java.util.List;

public class Conta {
  //O número da conta
  private int id;
  private Financas financas;

  public Conta(int id) {
    this.id = id;
    this.financas = new Financas(0);
    this.financas.addOperacao(Label.abertura, 0);
  }

  // se o valor for menor ou igual a 0, retorna true
  private boolean verificaValor(int valor) {
    if (valor > 0)
      return false;
    return true;
  }

  //só realiza a operação se houver dinheiro suficiente na conta
  public boolean sacar(int value) {
    if (this.verificaValor(value)) {
      System.out.println("fail: valor invalido");
      return false;
    }
    if (this.financas.getSaldo() - value < 0) {
      System.out.println("fail: saldo insuficiente");
      return false;
    }
    this.financas.addOperacao(Label.saque, -value);
    return true;
  }
  //retira o dinheiro, mesmo que o saldo fique negativo
  public boolean tarifar(int value) {
    if (this.verificaValor(value)) {
      System.out.println("fail: valor invalido");
      return false;
    }
    this.financas.addOperacao(Label.tarifa, -value);
    return true;
  }

  //se o índice for válido e representar uma operação de tarifa
  //adicione o mesmo valor tarifado, mas com label de extorno
  public boolean extornar(int indice) {
    if (this.verificaValor(indice) || indice > this.financas.getNextId()) {
      System.out.printf("fail: indice %d invalido%n", indice);
      return false;
    }
    List<Operacao> extrato = this.financas.getExtrato();
    if (extrato.get(indice).getLabel() != Label.tarifa) {
      System.out.printf("fail: indice %d nao e tarifa%n", indice);
      return false;
    }
    this.financas.addOperacao(Label.extorno, -extrato.get(indice).getValue());
    return true;
  }
  
  //adiciona valor à conta
  public boolean creditar(Label label, int value) {
    if (this.verificaValor(value)) {
      System.out.println("fail: valor invalido");
      return false;
    }
    this.financas.addOperacao(Label.deposito, value);
    return true;
  }

  public String toString() {
    return "conta:" + this.id + " saldo:" + this.financas.getSaldo();
  }

  public Financas getFinancas() {
    return this.financas;
  }
}