package cinema;

import java.util.ArrayList;

public class Sala {
  private ArrayList<Client> cadeiras;

  public ArrayList<Client> getCadeiras() {
    return cadeiras;
  }

  public Sala(int capacidade) {
    this.cadeiras = new ArrayList<Client>(capacidade);
    for (int i = 0; i < capacidade; i++)
      this.cadeiras.add(i, null);
  }

  // recebe um id e verifica se já esta no arrayList, se sim retorna a posicao, se nao retorna -1
  private int buscarCliente(String id) {
    for (int i = 0; i < this.cadeiras.size(); i++)
      if (this.cadeiras.get(i) != null && this.cadeiras.get(i).getId().equals(id))
        return i;
    return -1;
  }

  public boolean reservar(String id, String fone, int ind) {
    if (ind < 0 || ind >= this.cadeiras.size()) {
      return false;
    } else if (this.buscarCliente(id) != -1) {
      System.out.println("fail: cliente ja esta no cinema");
      return false;
    } else if (this.cadeiras.get(ind) != null) {
      System.out.println("fail: cadeira ja esta ocupada");
      return false;
    }
    this.cadeiras.set(ind, new Client(id, fone));
    return true;
  }

  public void cancelar(String id) {
    int index = this.buscarCliente(id);
    if (index != -1)
      cadeiras.set(index, null);
    else 
      System.out.println("fail: cliente nao esta no cinema");
  }

  public String toString() {
    String resul = "[ ";
    for (Client cliente : this.cadeiras) {
      if (cliente == null)
        resul += "- ";
      else
        resul += cliente + " ";
    }
    resul += "]";
    return resul;
  }
}