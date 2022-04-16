/**
 * @author Lucas Levy de Oliveira Barros
 * Atividade 02 (Parte da AP1) — Semana 14/10 a 21/10
 * QXD0007 — Programação Orientada a Objetos — 2021.2
 * Item C da 1ª questão
 */

package q_1_c;

import q_1_a.HoraAproximada;
import q_1_e.Data;

class DataHora {
  Data data = new Data();
  HoraAproximada hora = new HoraAproximada();

  void inicializaDataHora(byte dia, byte mes, short ano, byte horas, byte minutos) {
    data.inicializaData(dia, mes, ano);
    hora.inicializaHorario(horas, minutos);
  }

  void escreverDataHora() {
    data.escreverDataFormatada();
    System.out.print(" - ");
    hora.escreverHorarioFormatado();
  }

  public static void main(String[] args) throws Exception {
    DataHora hP = new DataHora();
    hP.inicializaDataHora((byte) 10, (byte) 12, (byte) 2020, (byte) 13, (byte) 58);
    hP.escreverDataHora();
    System.out.println();
  }

}
