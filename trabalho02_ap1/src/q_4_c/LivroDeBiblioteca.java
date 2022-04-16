package q_4_c;

import q_1_e.Data;

class LivroDeBiblioteca {
  String titulo, autor, editora, idioma, genero;
  byte edicao;
  short numeroPaginas;
  Data dataEmprestimo, dataDevolucao;
  short qtdeEstoque;
  String descricao;

  void inicializa(String titulo, String autor, String editora, String idioma, String genero, byte edicao,
      short numeroPaginas, short qtdeEstoque, String descricao) {
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
    this.idioma = idioma;
    this.genero = genero;
    this.edicao = edicao;
    this.numeroPaginas = numeroPaginas;
    this.qtdeEstoque = qtdeEstoque;
    this.descricao = descricao;
  }

  /**
   * Seta a data de emprestimo e de devolução do livro
   * @param dataEmprestimo
   * @param dataDevolucao
   */
  void setarDatasEmprestimo(Data dataEmprestimo, Data dataDevolucao) {
    this.dataEmprestimo = new Data();
    this.dataDevolucao = new Data();
    this.dataEmprestimo.inicializaData(dataEmprestimo.pegarDia(), dataEmprestimo.pegarMes(), dataEmprestimo.pegarAno());
    this.dataDevolucao.inicializaData(dataDevolucao.pegarDia(), dataDevolucao.pegarMes(), dataDevolucao.pegarAno());
    System.out.printf("Pegou emprestado em: %02d/%02d/%d%n", this.dataEmprestimo.pegarDia(), this.dataEmprestimo.pegarMes(), this.dataEmprestimo.pegarAno());
    System.out.printf("Deverá devolver em: %02d/%02d/%d%n", this.dataDevolucao.pegarDia(), this.dataDevolucao.pegarMes(), this.dataDevolucao.pegarAno());
  }

  /**
   * Verifica se o livro tem estoque, decrementa a quantidade e chama setarDatas
   * @param dataEmprestimo
   * @param dataDevolucao
   */
  void pegarEmprestado(Data dataEmprestimo, Data dataDevolucao) {
    System.out.println("Preparando o emprestimo.");
    if (qtdeEstoque > 0) {
      this.qtdeEstoque--;
      System.out.println("Empréstimo realizado com sucesso.");
      setarDatasEmprestimo(dataEmprestimo, dataDevolucao);
      System.out.println("Tenha uma boa leitura! ;)");
    } else {
      System.out.println("Não temos mais esse livro, entre em contato após alguns dias. :/");
    }
  }

  void escreve() {
    System.out.println("Título: " + this.titulo);
    System.out.println("Autor: " + this.autor);
    System.out.println("Editora: " + this.editora);
    System.out.println("Idioma: " + this.idioma);
    System.out.println("Gênero: " + this.genero);
    System.out.printf("Edição: %dª edição%n", this.edicao);
    System.out.println("Número de páginas: " + this.numeroPaginas);
    System.out.printf("Descrição:%n\t %s%n", this.descricao);
    System.out.println();
    System.out.println("### Administrativo ###");
    System.out.println("Quantidade em estoque: " + this.qtdeEstoque);
  }

  public static void main(String[] args) throws Exception {
    String descricao = "The #1 Java Guide for Serious Programmers: Fully Updated for Java SE 9, 10 & 11\nFor serious programmers, Core Java, Volume I--Fundamentals, Eleventh Edition, is the definitive guide to writing robust, maintainable code. Whether you're using Java SE 9, 10, or 11, it will help you achieve a deep and practical understanding of the language and API, and its hundreds of realistic examples reveal the most powerful and effective ways to get the job done.";
    LivroDeBiblioteca livro = new LivroDeBiblioteca();
    livro.inicializa("Core Java Volume I--Fundamentals: 1", "Cay Horstmann",
        "Pearson; 11th ed. edição (6 setembro 2018)", "Inglês", "Não-Ficção", (byte) 11, (short) 928, (short) 400, descricao);
    livro.escreve();
    System.out.println();
    System.out.println("### Empréstimo ###");
    Data dataEmprestimo = new Data();
    dataEmprestimo.inicializaData((byte) 15, (byte) 3, (short) 2021);
    Data dataDevolucao = new Data();
    dataDevolucao.inicializaData((byte) 16, (byte) 4, (short) 2021);
    livro.pegarEmprestado(dataEmprestimo, dataDevolucao);
  }
}
