package topic;

class Pass {
  private String name;
  private int age;

  public Pass(String name, int age) {
    this.name = name;
    this.age = age;
  }

  //return true if pass.age >= 65
  public boolean isPriority() {
    if (this.age >= 65)
      return true;
    return false;
  }

  //GETS e SETS
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return this.name + ":" + this.age;
  }
}