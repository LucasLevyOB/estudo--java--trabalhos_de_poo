package agenda1;

import java.util.ArrayList;

class Contact {
  private String name;
  private ArrayList<Fone> fones;
  protected String prefix = "-"; //utilizado no toString

  //Crie um ArrayList para o ATRIBUTO fones
  //Se a variável fones não for null, adicione todos os fones usando o método addFone
  public Contact(String name, ArrayList<Fone> fones) {
    this.name = name;
    this.fones = new ArrayList<Fone>();
    if (fones != null) {
      for (Fone fone : fones) {
        addFone(fone);
      }
    }
  }
  //Se fone for válido, insira no atributo fones
  //Se não, informe o erro
  public void addFone(Fone fone) {
    if (Fone.validate(fone.getNumber())) {
      fones.add(fone);
    } else
      System.out.println("fail: invalid number");
  }
  
  //Se o índice existir no ArrayList, remova o telefone com esse índice
  public void rmFone(int index) {
    if (index >= 0 && index < fones.size())
      fones.remove(index);
  }

  //Use um contador para mostrar o índice do telefone
  //Use o toString do fone para adicioná-lo à saída
  //O resultado dever ficar assim:
  //- david [0:oi:123] [1:tim:9081] [2:claro:5431]
  public String toString() {
    String formated = this.prefix + " " + this.name + " ";
    for (int i = 0; i < fones.size(); i++)
      formated += "[" + i + ":" + this.fones.get(i) + "] ";
    return formated;
  }

  //GETS e SETS
  public String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  public ArrayList<Fone> getFones() {
    return this.fones;
  }
}
