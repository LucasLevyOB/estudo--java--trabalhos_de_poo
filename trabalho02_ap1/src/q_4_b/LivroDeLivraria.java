package q_4_b;

class LivroDeLivraria {
  String titulo, autor, editora, idioma, genero;
  byte edicao;
  short numeroPaginas;
  float preco;
  short qtdeEstoque;
  short qtdeVendidas;
  String descricao;

  void inicializa(String titulo, String autor, String editora, String idioma, String genero, byte edicao,
      short numeroPaginas, float preco, short qtdeEstoque, String descricao) {
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
    this.idioma = idioma;
    this.genero = genero;
    this.edicao = edicao;
    this.numeroPaginas = numeroPaginas;
    this.preco = preco;
    this.qtdeEstoque = qtdeEstoque;
    this.qtdeVendidas = 0;
    this.descricao = descricao;
  }

  /**
   * Verifica se a quantidade solitada de livros ainda consta em estoque, se sim, decrementa da quantidade
   * @param qtde
   */
  void comprar(short qtde) {
    System.out.println("Preparando a compra.");
    if (qtdeEstoque - qtde >= 0) {
      this.qtdeEstoque -= qtde;
      this.qtdeVendidas += qtde;
      System.out.println("Compra realizada com sucesso. ;)");
    } else {
      System.out.println("A quantidade solitada excede o estoque. :/");
    }
  }

  /**
   * Escreve as informações básicas do livro
   */
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
    System.out.printf("Preço: %.2f R$%n", this.preco);
    System.out.println("Quantidade em estoque: " + this.qtdeEstoque);
    System.out.println("Quantidade vendidas: " + this.qtdeVendidas);
  }

  public static void main(String[] args) throws Exception {
    String descricao = "The #1 Java Guide for Serious Programmers: Fully Updated for Java SE 9, 10 & 11\nFor serious programmers, Core Java, Volume I--Fundamentals, Eleventh Edition, is the definitive guide to writing robust, maintainable code. Whether you're using Java SE 9, 10, or 11, it will help you achieve a deep and practical understanding of the language and API, and its hundreds of realistic examples reveal the most powerful and effective ways to get the job done.";
    LivroDeLivraria livro = new LivroDeLivraria();
    livro.inicializa("Core Java Volume I--Fundamentals: 1", "Cay Horstmann",
        "Pearson; 11th ed. edição (6 setembro 2018)", "Inglês", "Não-Ficção", (byte) 11, (short) 928, (float) 303.14,
        (short) 400, descricao);
    livro.escreve();
    System.out.println();
    System.out.println("### Compras ###");
    livro.comprar((short) 2);
    livro.comprar((short) 500);
  }
}
