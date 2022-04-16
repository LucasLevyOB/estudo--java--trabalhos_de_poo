package q_5_c;

public class Empregado {
  String nome, departamento, cargo;
  boolean ativo;
  short horasTrabalhadasNoMes;
  short horasExtrasTrabalhadasNoMes;
  float salarioPorHora;
  float porcentagemHoraExtra;
  float bonusAdmistracao = (float) 1.1;

  void inicializa(String nome, String departamento, String cargo, boolean ativo, short horasTrabalhadasNoMes, short horasExtrasTrabalhadasNoMes, float salarioPorHora, float porcentagemHoraExtra) {
    this.nome = nome;
    this.departamento = departamento;
    this.cargo = cargo;
    this.ativo = ativo;
    this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
    this.horasExtrasTrabalhadasNoMes = horasExtrasTrabalhadasNoMes;
    this.salarioPorHora = salarioPorHora;
    this.porcentagemHoraExtra = porcentagemHoraExtra;
  }

  void mudarCargo(String novoCargo) {
    this.cargo = novoCargo;
  }

  void mudarDepartamento(String novoDepartamento) {
    this.departamento = novoDepartamento;
  }

  void ativarEmpregado() {
    this.ativo = true;
  }

  void desativarEmpregado() {
    this.ativo = false;
  }

  /**
   * Para adicionar horas trabalhadas passe um positivo, para remover passe um negativo
   * @param horas
   */
  void adicionarRemoverHorasTrabalhadas(short horas) {
    this.horasTrabalhadasNoMes += horas;
  }

  /**
   * Para adicionar horas trabalhadas passe um positivo, para remover passe um negativo
   * @param horas
   */
  void adicionarRemoverHorasExtrasTrabalhadas(short horas) {
    this.horasExtrasTrabalhadasNoMes += horas;
  }

  /**
   * Calcula o valor da hora extra com base na porcentagem
   * @return
   */
  float valorHoraExtra() {
    return this.salarioPorHora  * (1 + this.porcentagemHoraExtra);
  }

  /**
   * Calcula o pagamento das horas extras
   * @return
   */
  float calcularPagamentoHorasExtras() {
    return this.horasExtrasTrabalhadasNoMes * valorHoraExtra();
  }

  /**
   * Calcula o pagamento sem horas extras
   * @return
   */
  float calcularPagamentoSemHorasExtras() {
    return this.horasTrabalhadasNoMes * this.salarioPorHora;
  }

  /**
   * Calcula o pagamento de horas normais e horas extras
   * @return
   */
  float calcularPagamentoTotal() {
    if (this.departamento.equals("Diretoria")) {
      return (this.calcularPagamentoSemHorasExtras() + this.calcularPagamentoHorasExtras()) * this.bonusAdmistracao;
    }
    return this.calcularPagamentoSemHorasExtras() + this.calcularPagamentoHorasExtras();
  }

  /**
   * Retorna o pagamento e zera as horas trabalhadas e horas extras
   * @return
   */
  float realizarPagamento() {
    float pagamento = calcularPagamentoTotal();
    this.horasTrabalhadasNoMes = 0;
    this.horasExtrasTrabalhadasNoMes = 0;
    return pagamento;
  }

  void mostraDados() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Departamento: " + this.departamento);
    System.out.println("Cargo: " + this.cargo);
    String status = ativo ? "Ativo" : "Desligado";
    System.out.println("Situação: " + status);
    System.out.println("Horas trabalhadas nesse mês: " + this.horasTrabalhadasNoMes);
    System.out.printf("Salário por hora: %.2f R$%n", this.salarioPorHora);
    System.out.println("Horas extras trabalhadas nesse mês: " + this.horasExtrasTrabalhadasNoMes);
    System.out.printf("Valor da hora extra: %.2f R$%n", this.valorHoraExtra());
  }

  float calculaSalarioMensal() {
    return this.horasTrabalhadasNoMes * this.salarioPorHora;
  }

  public static void main(String[] args) throws Exception {
    Empregado empregado1 = new Empregado();
    empregado1.inicializa("Francisco Silva", "Setor Operacional", "Desenvolvedor Front-End", true, (short) 0, (short) 0,
        (float) 22.45, (float) 0.7);
    empregado1.adicionarRemoverHorasTrabalhadas((short) 130);
    empregado1.adicionarRemoverHorasExtrasTrabalhadas((short) 15);
    empregado1.mostraDados();
    System.out.println("##### ---- #####");
    System.out.printf("Quanto ele já ganhou: %.2f%n", empregado1.calcularPagamentoTotal());
    System.out.println("Trabalhou mais um pouco.");
    empregado1.adicionarRemoverHorasExtrasTrabalhadas((short) 5);
    empregado1.adicionarRemoverHorasTrabalhadas((short) 30);
    System.out.printf(
        "Pagamento do salário:%n\t=> Horas normais: %.2f R$%n\t=> Horas extras: %.2f R$%n\t=> *Total: %.2f R$%n",
        empregado1.calcularPagamentoSemHorasExtras(), empregado1.calcularPagamentoHorasExtras(),
        empregado1.realizarPagamento());
    System.out.println();
    System.out.println("### Diretoria ###");
    System.out.println();
    Empregado empregado2 = new Empregado();
    empregado2.inicializa("Emanuel Rosa", "Diretoria", "Gestão de Tarefas - Junior", true, (short) 0, (short) 0,
        (float) 22.45, (float) 0.7);
    empregado2.adicionarRemoverHorasTrabalhadas((short) 160);
    empregado2.adicionarRemoverHorasExtrasTrabalhadas((short) 20);
    System.out.printf("Pagamento do salário:%n\t=> Horas normais: %.2f R$%n\t=> Horas extras: %.2f R$%n\t=> *Total: %.2f R$%n", empregado2.calcularPagamentoSemHorasExtras(), empregado2.calcularPagamentoHorasExtras(), empregado2.realizarPagamento());
  }

}
