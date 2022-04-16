package q_4_a;

class Livro {
  String titulo, autor, editora, idioma, genero;
  byte edicao;
  short numeroPaginas;

  void inicializa(String titulo, String autor, String editora, String idioma, String genero, byte edicao,
      short numeroPaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
    this.idioma = idioma;
    this.genero = genero;
    this.edicao = edicao;
    this.numeroPaginas = numeroPaginas;
  }

  public static void main(String[] args) throws Exception {
    Livro livro = new Livro();
    livro.inicializa("Core Java Volume I--Fundamentals: 1", "Cay Horstmann", "Pearson; 11th ed. edição (6 setembro 2018)", "Inglês", "Não-Ficção", (byte) 11, (short) 928);
  }
}
