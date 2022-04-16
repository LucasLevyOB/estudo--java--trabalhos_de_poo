package pulapulanoparquinho;

import java.util.LinkedList;

class Trampoline{
  private LinkedList<Kid> waiting;
  private LinkedList<Kid> playing;
  private float cash;
  private float price;
  private byte maxKidsPlaying;

  public Trampoline() {
    this.waiting = new LinkedList<Kid>();
    this.playing = new LinkedList<Kid>();
    this.cash = 0;
    this.maxKidsPlaying = 5;
    this.price = 5.5f;
  }

  private void setCash(float cash) {
    if (cash > 0)
      this.cash = cash;
  }

  public float getCash() {
    return this.cash;
  }

  //remove and return the Kid with this name or null
  private Kid removeKid(String name, LinkedList<Kid> list) {
    for (Kid kid: list)
      if (kid.getName().equals(name)) {
        // Kid removedKid = kid;
        list.remove(kid);
        return kid;
      }
    return null;
  }

  //insere na lista de espera
  public void arrive(Kid kid) {
    this.waiting.addFirst(kid);
  }

  //remove da lista de espera e insere na lista playing
  public void in() {
    if (this.waiting.size() <= 0)
      System.out.println("fail: nao ha criancas na lista de espera");
    else if (this.playing.size() >= this.maxKidsPlaying)
      System.out.println("fail: o trampolim esta cheio, limite: " + this.maxKidsPlaying);
    else
      this.playing.addFirst(this.waiting.removeLast());
  }

  //remove de playing para wainting
  public void out() {
    if (this.playing.size() > 0) {
      Kid removedKid = this.playing.removeLast();
      removedKid.increaseBalance(this.price);
      this.waiting.addFirst(removedKid);
    } else {
      System.out.println("fail: nao ha criancas brincando");
    }
  }

  // busca em uma lista e retorna a crianca ou null
  private Kid getKid(String name, LinkedList<Kid> list) {
    for (Kid kid: list)
      if (kid.getName().equals(name)) {
        return kid;
      }
    return null;
  }

  // retorna o saldo da crianca, se nao existir uma crianca com o nome retorna -1f
  public float kidBalance(String name) {
    Kid kid = null;
    kid = this.getKid(name, this.waiting);
    if (kid == null) {
      kid = this.removeKid(name, this.playing);
    }
    if (kid == null)
      return -1f;
    return kid.getBalance();
  }

  //remove do parquinho
  public Kid remove(String name) {
    Kid removedKid = null;
    removedKid = this.removeKid(name, this.waiting);
    if (removedKid == null) {
      removedKid = this.removeKid(name, this.playing);
      if (removedKid != null)
        removedKid.increaseBalance(this.price);
    }
    if (removedKid != null)
      this.setCash(removedKid.getBalance() + this.cash);
    return removedKid;
  }

  public void close() {
    while (this.playing.size() > 0)
      this.out();
    for (int i = 0; i < this.waiting.size();) {
      this.setCash(this.waiting.remove(i).getBalance() + this.cash);
    }
    System.out.printf("trampolim fechado => caixa: %.2f%n", this.cash);
  }

  public String toString() {
    String string = "=> ";
    for (Kid kid : this.waiting)
      string += kid + " ";
    string += " => [ ";
    for (Kid kid : this.playing)
      string += kid + " ";
    string += "]";
    return string;
  }
}