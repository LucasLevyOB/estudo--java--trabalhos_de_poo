package lapiseiragrafites;

public class Grafite {
  private float calibre;
  private String dureza;
  private int tamanho;

  public float getCalibre() {
    return this.calibre;
  }

  public int getTamanho() {
    return this.tamanho;
  }

  public Grafite(float calibre, String dureza, int tamanho) {
    this.calibre = calibre;
    this.dureza = dureza;
    this.tamanho = tamanho;
  }

  public String toString() {
    return "[" + this.calibre + ":" + this.dureza + ":" + this.tamanho + "]";
  }

  public int desgastePorFolha() {
    if (this.dureza.equals("HB"))
      return 1;
    else if (this.dureza.equals("2B"))
      return 2;
    else if (this.dureza.equals("4B"))
      return 4;
    return 6;
  }

  public void desgastarGrafite(int desgaste) {
    if (desgaste > 0)
      this.tamanho = desgaste;
  }
}
