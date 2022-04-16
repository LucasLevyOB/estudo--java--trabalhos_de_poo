package lapiseira;

public class Lapiseira {
  private float calibre;
  private Grafite grafite;
  private static final byte TAM_MINIMO = 10;

  public Lapiseira(float calibre) {
    this.calibre = calibre;
    this.grafite = null;
  }

  public String toString() {
    return "calibre: " + this.calibre + ", grafite: " + this.grafite;
  }

  public boolean inserir(Grafite grafite) {
    if (this.grafite != null) {
      System.out.println("fail: ja existe grafite");
      return false;
    } else if (this.calibre != grafite.getCalibre()) {
      System.out.println("fail: calibre incompatível");
      return false;
    }
    this.grafite = grafite;
    return true;
  }

  public Grafite remover() {
    if (this.grafite != null) {
      Grafite grafiteRetirado = this.grafite;
      this.grafite = null;
      return grafiteRetirado;
    }
    return this.grafite;
  }

  public void escrever() {
    if (this.grafite == null)
      System.out.println("fail: nao existe grafite");
    else if (this.grafite.getTamanho() <= TAM_MINIMO)
      System.out.println("fail: grafite acabou");
    else if (this.grafite.getTamanho() - this.grafite.desgastePorFolha() < TAM_MINIMO) {
      this.grafite.desgastarGrafite(TAM_MINIMO);
      System.out.println("fail: folha incompleta");
      System.out.println("warning: grafite acabou");
    }  else if (this.grafite.getTamanho() - this.grafite.desgastePorFolha() == TAM_MINIMO) {
      this.grafite.desgastarGrafite(TAM_MINIMO);
      System.out.println("warning: grafite acabou");
    } else {
      this.grafite.desgastarGrafite(this.grafite.getTamanho() - this.grafite.desgastePorFolha());
    }
  }
}