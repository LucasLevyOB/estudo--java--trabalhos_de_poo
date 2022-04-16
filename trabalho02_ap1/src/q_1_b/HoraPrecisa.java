/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item B da 1ª questão
 */

package q_1_b;

class HoraPrecisa {
  byte horas, minutos, segundos, centesimosSegundos;

  boolean verificaHoras(byte horas) {
    if (horas >= 0 && horas < 24)
      return true;
    return false;
  }

  /**
   * Pode verificar segundos e minutos
   * @param minutos
   * @return
   */
  boolean verificaMinutos(byte minutos) {
    if (minutos >= 0 && minutos < 60)
      return true;
    return false;
  }

  boolean verificaCentesimosSegundos(byte centesimosSegundos) {
    if (centesimosSegundos >= 0 && centesimosSegundos < 100)
      return true;
    return false;
  }

  /**
   * Verifica se o formato está correto para o formato 24 horas
   * @param horas
   * @param minutos
   * @param segundos
   * @param centesimosSegundos
   * @return
   */
  boolean verificaFormatoValido(byte horas, byte minutos, byte segundos, byte centesimosSegundos) {
    boolean ehValida = verificaHoras(horas) && verificaMinutos(minutos) && verificaMinutos(segundos)
        && verificaCentesimosSegundos(centesimosSegundos);
    if (ehValida)
      return true;
    return false;
  }

  void inicializaHorario(byte horas, byte minutos, byte segundos, byte centesimosSegundos) { 
    if (verificaFormatoValido(horas, minutos, segundos, centesimosSegundos)) {
      this.horas = horas;
      this.minutos = minutos;
      this.segundos = segundos;
      this.centesimosSegundos = centesimosSegundos;
    } else {
      this.horas = 9;
      this.minutos = 0;
      this.segundos = 0;
      this.centesimosSegundos = 0;
    }
  }

  void escreverHorarioFormatado() {
    System.out.printf("%02d:%02d:%02d:%03d", this.horas, this.minutos, this.segundos, this.centesimosSegundos);
  }

  public static void main(String[] args) throws Exception {
    HoraPrecisa hP = new HoraPrecisa();
    hP.inicializaHorario((byte) 10, (byte) 57, (byte) 32, (byte) 96);
    hP.escreverHorarioFormatado();
    System.out.println();
  }

}
