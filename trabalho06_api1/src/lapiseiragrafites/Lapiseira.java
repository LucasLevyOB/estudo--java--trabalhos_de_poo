package lapiseiragrafites;

import java.util.ArrayList;

public class Lapiseira {
  private float calibre;
  private Grafite bico;
  private ArrayList<Grafite> tambor;
  private static final byte TAM_MINIMO = 10;

  public Lapiseira(float calibre) {
    this.calibre = calibre;
    this.bico = null;
    this.tambor = new ArrayList<Grafite>();
  }

  public String toString() {
    String stringTambor = "{";
    for (Grafite grafite : tambor)
      stringTambor += grafite;
    stringTambor += "}";
    String stringBico = this.bico == null ? "[]" : this.bico.toString();
    return "calibre: " + this.calibre + ", bico: " + stringBico + ", tambor: " + stringTambor;
  }

  public boolean inserir(Grafite grafite) {
    if (this.calibre != grafite.getCalibre()) {
      System.out.println("fail: calibre incompatível");
      return false;
    }
    this.tambor.add(grafite);
    return true;
  }
  
  public boolean puxar() {
    if (this.bico != null) {
      System.out.println("fail: ja existe grafite no bico");
      return false;
    } else if (this.tambor.size() > 0) {
      this.bico = this.tambor.get(0);
      this.tambor.remove(0);
      return true;
    }
    System.out.println("fail: nao existe grafite no tambor");
    return false;
  }

  public Grafite remover() {
    if (this.bico != null) {
      Grafite grafiteRemovido = this.bico;
      this.bico = null;
      return grafiteRemovido;
    }
    return this.bico;
  }

  public void escrever() {
    if (this.bico == null)
      System.out.println("fail: nao existe grafite no bico");
    else if (this.bico.getTamanho() <= TAM_MINIMO)
      System.out.println("fail: grafite acabou");
    else if (this.bico.getTamanho() - this.bico.desgastePorFolha() < TAM_MINIMO) {
      this.bico.desgastarGrafite(TAM_MINIMO);
      System.out.println("fail: folha incompleta");
      System.out.println("warning: grafite acabou");
    } else if ((this.bico.getTamanho() - this.bico.desgastePorFolha()) == TAM_MINIMO) {
      this.bico.desgastarGrafite(TAM_MINIMO);
      System.out.println("warning: grafite acabou");
    } else {
      this.bico.desgastarGrafite(this.bico.getTamanho() - this.bico.desgastePorFolha());
    }
  }
}