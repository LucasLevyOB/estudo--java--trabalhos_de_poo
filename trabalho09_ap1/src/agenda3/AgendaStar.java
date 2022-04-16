package agenda3;

import java.util.ArrayList;
import java.util.List;

public class AgendaStar extends Agenda {
  //SE o contato existir e for do tipo ContatoStar altere o atributo star dele
  public void star(String name, boolean value) {
    Contact contact = super.findContact(name);
    // Object contatoStarComp = (ContactStar) new Object();
    if (contact != null && contact instanceof ContactStar) {
      ContactStar contactStar = (ContactStar) contact;
      contactStar.setStar(!contactStar.getStar());
    } else if (contact == null)
      System.out.printf("fail: contato %s nao existe%n", name);
  }
  //filtre em uma nova lista apenas os contatos que forem do tipo ContatoStar e que estão favoritados
  public List<Contact> getStarred() {
    ArrayList<Contact> filteredList = new ArrayList<Contact>();
    // List<Contact> contatos = 
    super.getContacts().forEach(contact -> {
      if (contact instanceof ContactStar) {
        ContactStar contactStar = (ContactStar) contact;
        if (contactStar.getStar() == true)
          filteredList.add(contactStar);
      }
    });

    return filteredList;
  }
}
