package cadastro;

public abstract class Account {
  protected int id;
  protected float balance;
  protected String clientId;
  protected String type; //CC or CP

  public Account(int id, String clientId) {
    this.id = id;
    this.clientId = clientId;
    balance = 0;
  }
  
  //abstract method
  public abstract void monthlyUpdate();

  //saque
  public void withdraw(float value) {
    if (value > 0 && balance - value >= 0) 
      balance -= value;
    else
      System.out.println("fail: saldo insuficiente");
  }
  //deposito
  public void deposit(float value) {
    if (value > 0)
      balance += value;
  }
  //transferencia para outra conta
  public void transfer(Account other, float value) {
    if (value > 0 && balance - value >= 0) {
      other.deposit(value);
      balance -= value;
    } else 
      System.out.println("fail: saldo insuficiente");
  }

  public String toString() {
    String formatedFloat = String.format("%.2f", balance);
    String formated = clientId + ":" + formatedFloat + ":" + type;
    return formated;
  }
  
  //GETS and SETS
  public int getId() {
    return this.id;
  }

  public float getBalance() {
    return this.balance;
  }

  public String getClientId() {
    return this.clientId;
  }

  public String getType() {
    return this.type;
  }
}
