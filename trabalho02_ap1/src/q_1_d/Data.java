/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item D da 1ª questão
 */

package q_1_d;

class Data {
  byte dia, mes;
  short ano;

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

  /**
   * Verifica se dia, mes e ano, receberam valores adequados
   * @param dia
   * @param mes
   * @param ano
   * @return
   */
  boolean verificaData(byte dia, byte mes, short ano) {
    if (!verificaMes(mes))
      return false;
    
    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
      return verificaDia(dia, (byte) 30);
    else if (mes == 2) {
      return verificaDia(dia, (byte) 28);
    } else
      return verificaDia(dia, (byte) 31);
  }

  void inicializaData(byte dia, byte mes, short ano) { 
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

  void escreverDataFormatada() {
    if (this.dia == 0 || this.mes == 0 || this.ano == 0)
      System.out.println("Data Inválida");
    else
      System.out.printf("%02d/%02d/%d", this.dia, this.mes, this.ano);
  }

  public static void main(String[] args) throws Exception {
    Data data1 = new Data();
    data1.inicializaData((byte) 31, (byte) 11, (short) 2020);
    data1.escreverDataFormatada();
    System.out.println();
  }

}
