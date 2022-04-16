package tarifa;

import java.util.ArrayList;
import java.util.List;

//Finanças registra o saldo e guarda as movimentações financeiras
public class Financas {
  //O id da próxima operação dessa conta
  private int nextId;
  //A lista de operações realizadas
  private List<Operacao> extrato;
  private int saldo;

  public Financas(int saldo) {
      this.nextId = 0;
      this.saldo = saldo;
      this.extrato = new ArrayList<Operacao>();
  }

  //Adiciona value ao saldo
  //Crie operação e adiciona ao vetor de operações
  //Incrementa o nextId
  public void addOperacao(Label label, int value) {
    this.saldo += value;
    this.extrato.add(new Operacao(this.nextId, label, value, this.saldo));
    this.nextId++;
  }

  public int getSaldo() {
    return this.saldo;
  }

  public int getNextId() {
    return this.nextId;
  }

  public List<Operacao> getExtrato() {
    return this.extrato;
  }

  public List<Operacao> getExtrato(int qtdOp) {
    if (qtdOp < 0 || qtdOp > this.extrato.size())
      return null;
    return this.extrato.subList(this.extrato.size() - qtdOp, this.extrato.size());
  }
}