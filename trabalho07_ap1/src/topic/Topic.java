package topic;

import java.util.ArrayList;

class Topic {
  private ArrayList<Pass> prioritySeats;
  private ArrayList<Pass> normalSeats;

  // inicializa uma lista com valores nulos
  private void initializeList(ArrayList<Pass> list, int limit) {
    for (int i = 0; i < limit; i++)
      list.add(i, null);
  }

  public Topic(int capacity, int qtdPriority) {
    this.normalSeats = new ArrayList<Pass>(capacity - qtdPriority);
    this.prioritySeats = new ArrayList<Pass>(qtdPriority);
    this.initializeList(normalSeats, capacity - qtdPriority);
    this.initializeList(prioritySeats, qtdPriority);
  }

  //return the first free pos or -1
  private int findFirstFreePos(ArrayList<Pass> list) {
    for (int i = 0; i < list.size(); i++)
      if (list.get(i) == null)
        return i;
    return -1;
  }

  //search in list using name and return position or return -1
  private int findByName(String name, ArrayList<Pass> list) {
    for (int i = 0; i < list.size(); i++)
      if (list.get(i) != null && list.get(i).getName().equals(name))
        return i;
    return -1;
  }
  
  //use the findFirstFreePos to search a free position
  //if exists, insert the pass and return true
  //else return false
  private boolean insertOnList(Pass pass, ArrayList<Pass> list) {
    int firstFreePos = this.findFirstFreePos(list);
    if (firstFreePos == -1)
      return false;
    list.set(firstFreePos, pass);
    return true;
  }

  //use the findByName method to locate pos in list, if found, remore the person
  //setting the pos location to null
  private boolean removeFromList(String name, ArrayList<Pass> list) {
    int positionPass = this.findByName(name, list);
    if (positionPass == -1)
      return false;
    list.set(positionPass, null);
    return true;
  }

  //use findByName to test if the pass is already in the topic
  //use the insertOnList method to insert in the right list based in
  //the pass.isPriority result
  public boolean insert(Pass pass) {
    if (this.findByName(pass.getName(), this.normalSeats) != -1
        || this.findByName(pass.getName(), this.prioritySeats) != -1) {
      System.out.println("fail: pass ja esta na topic");
      return false;
    }
    if (pass.getAge() >= 60) {
      boolean result = this.insertOnList(pass, this.prioritySeats);
      if (result) {
        return true;
      }
      result = this.insertOnList(pass, this.normalSeats);
      if (result)
        return true;
      System.out.println("fail: topic lotada");
      return false;
    }
    boolean result = this.insertOnList(pass, this.normalSeats);
    if (result) {
      return true;
    }
    result = this.insertOnList(pass, this.prioritySeats);
    if (result)
      return true;
    System.out.println("fail: topic lotada");
    return false;

  }

  //use the removeFromList method to try to remove from both lists
  public boolean remove(String name) {
    boolean result = this.removeFromList(name, this.normalSeats);
    if (result)
      return true;
    result = this.removeFromList(name, this.prioritySeats);
    if (result)
      return true;
    System.out.println("fail: pass nao esta na topic");
    return false;
  }

  private String formatSeats(ArrayList<Pass> list, char tipo) {
    String formated = "";
    for (int i = 0; i < list.size(); i++) {
      formated += tipo;
      if (list.get(i) != null)
        formated += list.get(i);
      if (i < list.size() - 1)
        formated += " ";
    }
    return formated;
  }

  public String toString() {
    String formated = "[";
    formated += formatSeats(this.prioritySeats, '@');
    formated += formated.length() > 1 ? " " : "";
    formated += formatSeats(this.normalSeats, '=');
    formated += "]";
    return formated;
  }
}

