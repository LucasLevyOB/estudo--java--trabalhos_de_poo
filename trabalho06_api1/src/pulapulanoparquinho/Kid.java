package pulapulanoparquinho;

public class Kid {
  private int age;
  private String name;
  private float balance;

  public Kid(String name, int age) {
    this.name = name;
    this.age = age;
    this.balance = 0;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  public float getBalance() {
    return this.balance;
  }

  private void setBalance(float balance) {
    this.balance = balance;
  }

  public void increaseBalance(float balance) {
    if (balance > 0)
      this.setBalance(this.balance + balance);
  }

  public String toString() {
    return this.name + ":" + this.age;
  }
}

