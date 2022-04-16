/**
 * @author Lucas Levy de Oliveira Barros 
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10 
 * QXD0007 — Programação Orientada a Objetos — 2021.2 
 * Item A da 1ª questão
 */

package q_1_a;

// Essa classe é pública porque precisa ser instanciada em outra classe que está fora do pacote
public class HoraAproximada {
  byte horas, minutos;

  boolean verificaMinutos(byte minutos) {
    if (minutos >= 0 && minutos < 60)
      return true;
    return false;
  }

  boolean verificaHoras(byte horas) {
    if (horas >= 0 && horas < 24)
      return true;
    return false;
  }

  /**
   * Verifica se um horário no formato 24 horas está bem formado
   * @param horas
   * @param minutos
   * @return
   */
  boolean verificaFormato(byte horas, byte minutos) {
    if (verificaHoras(horas) && verificaMinutos(minutos))
      return true;
    return false;
  }

  /**
   * Inicializa um objeto, antes chama a função de verificação de formato
   * @param horas
   * @param minutos
   */
  public void inicializaHorario(byte horas, byte minutos) {
    if (verificaFormato(horas, minutos)) {
      this.horas = horas;
      this.minutos = minutos;
    } else {
      this.horas = 9;
      this.minutos = 0;
    }
  }

  public void escreverHorarioFormatado() {
    System.out.printf("%02d:%02d", this.horas, this.minutos);
  }

  public static void main(String[] args) throws Exception {
    HoraAproximada hA = new HoraAproximada();
    hA.inicializaHorario((byte) 10, (byte) 57);
    hA.escreverHorarioFormatado();
    System.out.println();
  }

}
