package q_2_a;

public class Data {
  public static final String[] mesesAno = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
      "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
  
  private byte dia, mes;
  private short ano;

  public byte getDia() {
    return dia;
  }

  public byte getMes() {
    return mes;
  }

  public short getAno() {
    return ano;
  }
  
  public String getMesExtenso() {
    return mesesAno[this.getMes() - 1];
  }

  private boolean verificaMes(byte mes) {
    if (mes >= 1 && mes <= 12)
      return true;
    return false;
  }

  private boolean verificaDia(byte dia, byte limite) {
    if (dia >= 1 && dia <= limite)
      return true;
    return false;
  }

  public static boolean verificaAnoBissexto(short ano) {
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
  private boolean verificaData(byte dia, byte mes, short ano) {
    // Se o mês estiver errado, para aqui
    if (!this.verificaMes(mes))
      return false;
    // Aqui são feitas as demais veficações
    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
      return this.verificaDia(dia, (byte) 30);
    else if (mes == 2) {
      byte limite = 28;
      limite += verificaAnoBissexto(ano) ? (byte) 1 : (byte) 0 ;
      return this.verificaDia(dia, limite);
    } else
      return this.verificaDia(dia, (byte) 31);
  }

  public Data(byte dia, byte mes, short ano) {
    if (verificaData(dia, mes, ano)) {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
    } else {
      this.dia = 1;
      this.mes = 1;
      this.ano = 1;
    }
  }

  public byte compara(Data compData) {
    if (this.getAno() == compData.getAno() && this.getDia() == compData.getDia() && this.getAno() == compData.getAno())
      return 0;
    else if (this.ano > compData.getAno() || (this.ano >= compData.getAno() && this.getMes() > compData.getMes()) || (this.ano >= compData.getAno() && this.getMes() >= compData.getMes() && this.getDia() > compData.getDia()))
      return 1;
    else
      return -1;
  }

  public boolean isBissexto() {
    return verificaAnoBissexto(this.getAno());
  }

  public Data clone() {
    return new Data(this.getDia(), this.getMes(), this.getAno());
  }

}