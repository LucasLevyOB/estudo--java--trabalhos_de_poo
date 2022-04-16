package lapiseiragrafites;

import java.util.Locale;

public class Manual {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    // __case inserindo grafites
    System.out.println("__case inserindo grafites:");
    Lapiseira lapiseira = new Lapiseira(0.5f);
    System.out.println(lapiseira);
    // calibre: 0.5, bico: [], tambor: {}
    lapiseira.inserir(new Grafite(0.7f, "2B", 50));
    // fail: calibre incompatível
    lapiseira.inserir(new Grafite(0.5f, "2B", 50));
    System.out.println(lapiseira);
    // calibre: 0.5, bico: [], tambor: {[0.5:2B:50]}
    lapiseira.inserir(new Grafite(0.5f, "2B", 30));
    System.out.println(lapiseira);
    // calibre: 0.5, bico: [], tambor: {[0.5:2B:50][0.5:2B:30]}
    lapiseira.puxar();
    System.out.println(lapiseira);
    // calibre: 0.5, bico: [0.5:2B:50], tambor: {[0.5:2B:30]}
    lapiseira.puxar();
    // fail: ja existe grafite no bico
    lapiseira.remover();
    System.out.println(lapiseira);
    // calibre: 0.5, bico: [], tambor: {[0.5:2B:30]}

    // __case escrevendo 1
    System.out.println();
    System.out.println("__case escrevendo 1:");
    Lapiseira lapiseira2 = new Lapiseira(0.9f);
    lapiseira2.inserir(new Grafite(0.9f, "4B", 14));
    lapiseira2.inserir(new Grafite(0.9f, "4B", 16));
    lapiseira2.escrever();
    // fail: nao existe grafite no bico
    lapiseira2.puxar();
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [0.9:4B:14], tambor: {[0.9:4B:16]}
    lapiseira2.escrever();
    // warning: grafite acabou
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [0.9:4B:10], tambor: {[0.9:4B:16]}
    lapiseira2.remover();
    lapiseira2.puxar();
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [0.9:4B:16], tambor: {}
    lapiseira2.escrever();
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [0.9:4B:12], tambor: {}
    lapiseira2.escrever();
    // fail: folha incompleta
    // warning: grafite acabou
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [0.9:4B:10], tambor: {}
    lapiseira2.escrever();
    // fail: grafite acabou
    lapiseira2.remover();
    System.out.println(lapiseira2);
    // calibre: 0.9, bico: [], tambor: {}
    lapiseira2.puxar();
    // fail: nao existe grafite no tambor
    
  }
}
