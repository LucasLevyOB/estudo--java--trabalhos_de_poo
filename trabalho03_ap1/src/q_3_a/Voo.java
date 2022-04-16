package q_3_a;

import q_2_a.Data;

public class Voo {
  private short numeroVoo;
  private Data data;
  private boolean[] cadeirasVoo;

  public short getVoo() {
    return this.numeroVoo;
  }

  public Data getData() {
    return this.data;
  }

  public Voo(short numeroVoo, Data data) {
    this.numeroVoo = numeroVoo;
    this.data = data;
    this.cadeirasVoo = new boolean[100];
  }

  public Voo(short numeroVoo, Data data, boolean[] cadeirasVoo) {
    this.numeroVoo = numeroVoo;
    this.data = data;
    this.cadeirasVoo = cadeirasVoo;
  }

  public byte proximoLivre(byte cadeiraAtual) {
    int numCadeirasVoo = this.cadeirasVoo.length;
    for (byte i = cadeiraAtual; i < numCadeirasVoo; i++) {
      if (this.cadeirasVoo[i] != true)
        return (byte) (i + 1);
    }
    return -1;
  }

  public boolean verifica(byte numCadeira) {
    if (this.cadeirasVoo[numCadeira - 1] == true)
      return true;
    return false;
  }

  public boolean ocupa(byte numCadeira) {
    if (this.verifica(numCadeira))
      return false;
    this.cadeirasVoo[numCadeira - 1] = true;
    return true;
  }

  public byte vagas() {
    int numCadeirasVoo = this.cadeirasVoo.length;
    byte numVagas = 0;
    for (int i = 0; i < numCadeirasVoo; i++) {
      if (this.cadeirasVoo[i] != true)
        numVagas++;
    }
    return numVagas;
  }

  public Voo clone() {
    return new Voo(this.getVoo(), this.getData(), this.cadeirasVoo);
  }
}
