package q_5_a;

public class Empregado {
  String nome, departamento, cargo;
  boolean ativo;
  short horasTrabalhadasNoMes;
  float salarioPorHora;

  void inicializa(String nome, String departamento, String cargo, boolean ativo, short horasTrabalhadasNoMes, float salarioPorHora) {
    this.nome = nome;
    this.departamento = departamento;
    this.cargo = cargo;
    this.ativo = ativo;
    this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
    this.salarioPorHora = salarioPorHora;
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
   * Calcula o pagamento e zera as horas trabalhadas
   * @return
   */
  float realizarPagamento() {
    float pagamento = this.horasTrabalhadasNoMes * this.salarioPorHora;
    this.horasTrabalhadasNoMes = 0;
    return pagamento;
  }

  float verTotalReceber() {
    return this.horasTrabalhadasNoMes * this.salarioPorHora;
  }

  void mostraDados() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Departamento: " + this.departamento);
    System.out.println("Cargo: " + this.cargo);
    String status = ativo ? "Ativo" : "Desligado";
    System.out.println("Situação: " + status);
    System.out.println("Horas trabalhadas nesse mês: " + this.horasTrabalhadasNoMes);
    System.out.printf("Salário por hora: %.2f R$%n", this.salarioPorHora);
  }

  float calculaSalarioMensal() {
    return this.horasTrabalhadasNoMes * this.salarioPorHora;
  }

  public static void main(String[] args) throws Exception {
    Empregado empregado1 = new Empregado();
    empregado1.inicializa("Francisco Silva", "Setor Operacional", "Desenvolvedor Front-End", true, (short) 0,
        (float) 22.45);
    empregado1.adicionarRemoverHorasTrabalhadas((short) 130);
    empregado1.mostraDados();
    System.out.println("##### ---- #####");
    System.out.printf("Quanto ele já ganhou: %.2f%n", empregado1.verTotalReceber());
    empregado1.adicionarRemoverHorasTrabalhadas((short) 30);
    System.out.printf("Pagamento do salário: %.2f%n", empregado1.realizarPagamento());

  }

}
