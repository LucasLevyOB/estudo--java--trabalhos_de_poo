package agenda3;

import java.util.ArrayList;
import java.util.List;

public class ContactStar extends Contact {
  private boolean star;
  //contrutor default
  public ContactStar(String name, ArrayList<Fone> fones, boolean star) {
    super(name, fones);
    this.star = star;
  }
  //muda o prefixo e o valor de star
  public void setStar(boolean value) {
    this.star = value;
  }

  public boolean getStar() {
    return this.star;
  }

  @Override
  public String toString() {
    List<Fone> fones = super.getFones();
    String formated = this.star ? "@" : super.prefix;
    formated += " " + super.getName() + " ";
    for (int i = 0; i < fones.size(); i++)
      formated += "[" + i + ":" + fones.get(i) + "] ";
    return formated;
  }
}