/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item E da 1ª questão
 */

package q_1_e;

// Essa classe é pública porque precisa ser instanciada em outra classe que está fora do pacote
public class Data {
  byte dia, mes;
  short ano;

  // Esses métodos estão públicos para poderem ser chamados em outra classe 
  public byte pegarDia() {
    return this.dia;
  }
  public byte pegarMes() {
    return this.mes;
  }
  public short pegarAno() {
    return this.ano;
  }

  boolean verificaMes(byte mes) {
    if (mes >= 1 && mes <= 12)
      return true;
    return false;
  }

  boolean verificaDia(byte dia, byte limite) {
    if (dia >= 1 && dia <= limite)
      return true;
    return false;
  }

  boolean verificaAnoBissexto(short ano) {
    if (( ano % 4 == 0 && ano % 100 != 0 ) || ano % 400 == 0)
      return true;
    return false;
  }

  /**
   * Verifica o formato da data, considerando anos não-bissextos e bissextos
   * @param dia
   * @param mes
   * @param ano
   * @return
   */
  boolean verificaData(byte dia, byte mes, short ano) {
    // Se o mês estiver errado, para aqui
    if (!this.verificaMes(mes))
      return false;
    // Aqui são feitas as demais veficações
    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
      return this.verificaDia(dia, (byte) 30);
    else if (mes == 2) {
      byte limite = 28;
      limite += this.verificaAnoBissexto(ano) ? (byte) 1 : (byte) 0 ;
      return this.verificaDia(dia, limite);
    } else
      return this.verificaDia(dia, (byte) 31);
  }

  public void inicializaData(byte dia, byte mes, short ano) { 
    if (verificaData(dia, mes, ano)) {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
    } else {
      System.out.println("A data inserida é invalida, tente novamente.");
      this.dia = 31;
      this.mes = 12;
      this.ano = 1999;
    }
  }

  public void escreverDataFormatada() {
    if (this.dia == 0 || this.mes == 0 || this.ano == 0)
      System.out.println("Data Inválida");
    else
      System.out.printf("%02d/%02d/%d", this.dia, this.mes, this.ano);
  }

  public static void main(String[] args) throws Exception {
    Data data1 = new Data();
    data1.inicializaData((byte) 31, (byte) 11, (short) 2020);
    if (data1.verificaData((byte) 29, (byte) 2, (short) 2021))
      System.out.println("Essa data é válida!");
    else
      System.out.println("Essa data não é válida!");
    data1.escreverDataFormatada();
    System.out.println();
  }

}
