package pulapulanoparquinho;

import java.util.Locale;

class Manual {
  public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      //case unico
      Trampoline trampoline = new Trampoline();
      trampoline.arrive(new Kid("mario", 5));
      trampoline.arrive(new Kid("livia", 4));
      trampoline.arrive(new Kid("luana", 3));
      System.out.println(trampoline);
      //=> luana:3 livia:4 mario:5 => [ ]

      //case entrando
      trampoline.in();
      System.out.println(trampoline);
      //=> luana:3 livia:4 => [ mario:5 ]
      trampoline.in();
      System.out.println(trampoline);
      //=> luana:3 => [ livia:4 mario:5 ]

      //case saindo e ver caixa do trampolim
      trampoline.out();
      System.out.println(trampoline);
      //=> mario:5 luana:3 => [ livia:4 ]
      System.out.println(trampoline.remove("mario"));
      // mario:5
      System.out.println(trampoline);
      //=> luana:3 => [ livia:4 ]
      System.out.printf("%.2f%n", trampoline.getCash());
      // 5.50
      
      // case mover crianca estando vazio
      trampoline.in();
      System.out.println(trampoline);
      // =>  => [ luana:3 livia:4 ]
      trampoline.in();
      // fail: nao ha criancas na lista de espera

      // case remover direto de playing e pagar
      trampoline.out();
      System.out.println(trampoline);
      // => livia:4  => [ luana:3 ]
      trampoline.in();
      System.out.println(trampoline);
      // =>  => [ livia:4 luana:3 ]
      System.out.println(trampoline.remove("livia"));
      // livia:4
      System.out.println(trampoline);
      // =>  => [ luana:3 ]
      System.out.printf("%.2f%n", trampoline.getCash());
      // 16.50

      // case ver saldo de uma crianca
      trampoline.out();
      System.out.printf("%.2f%n", trampoline.kidBalance("luana"));
      // 5.5

      // case fechar
      trampoline.arrive(new Kid("chico", 6));
      trampoline.arrive(new Kid("maria", 3));
      trampoline.in();
      trampoline.in();
      // => maria:3  => [ chico:6 luana:3 ]
      System.out.println(trampoline);
      System.out.printf("%.2f%n", trampoline.getCash());
      // 16.50
      trampoline.close();
      // trampolim fechado => caixa: 33.00
  }
}