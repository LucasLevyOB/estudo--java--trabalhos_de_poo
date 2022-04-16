package agenda3;

import java.util.ArrayList;
import java.util.List;

class Agenda {
  private List<Contact> contacts;

  public Agenda() {
    contacts = new ArrayList<Contact>();
  }
  //retorna a posição do contato com esse nome no vetor ou -1 se não existir.
  private int findPosByName(String name) {
    for (int i = 0; i < contacts.size(); i++)
      if (contacts.get(i).getName().equals(name))
        return i;
    return -1;
  }

  //retorna o objeto contato com esse nome ou null se não existir
  //utilize o método findPosByName
  public Contact findContact(String name) {
    int pos = findPosByName(name);
    if (pos == -1)
      return null;
    return contacts.get(pos);
  }

  //se nenhum contato existir com esse nome, adicione
  //se ja existir, faça o merge adicionando os telefones
  //por fim, ordene a lista para ficar em ordem alfabética
  public void addContact(Contact contact) {
    if (contact != null) {
      int index = findPosByName(contact.getName());
      if (index == -1) {
        contacts.add(contact);
        // O código para a ordenação da lista já está feito logo abaixo
        // esta é a última linha de código da função
        this.contacts.sort((Contact c1, Contact c2) -> (c1.getName().compareTo(c2.getName())));
      } else {
        Contact editedContact = contacts.get(index);
        contact.getFones().forEach(fone -> editedContact.addFone(fone));
        contacts.set(index, editedContact);
      }
    }
  }
  //Utilize o método findPosByName
  public void rmContact(String name) {
    int pos = findPosByName(name);
    if (pos != -1)
      contacts.remove(pos);
  }

  //Monte uma lista auxiliar procurando no .toString() de cada contato
  //se ele possui a substring procurada.
  //dica: reveja os métodos da classe String e procure algum que ajude aqui
  public List<Contact> search(String pattern) {
    if (pattern.equals("") || pattern.equals(" "))
      return new ArrayList<Contact>();
    List<Contact> aux = new ArrayList<Contact>();
    contacts.forEach(contact -> {
      if (contact.toString().contains(pattern))
        aux.add(contact);
    });
    return aux;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public Contact getContact(String name) {
    return findContact(name);
  }

  public String toString() {
    String formatada = "";
    int size = contacts.size();
    for (int i = 0; i < size; i++) {
      formatada += contacts.get(i).toString();
      if (i + 1 <  size)
        formatada += "\n";
    }
    return formatada;
  }
}
