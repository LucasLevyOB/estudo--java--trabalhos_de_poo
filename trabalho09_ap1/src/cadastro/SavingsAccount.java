package cadastro;

public class SavingsAccount extends Account {
  private static final float PERCENTAGE_INCREASE = (float) 0.01;

  public SavingsAccount(int id, String idClient) {
    super(id, idClient);
    super.type = "CP";
  }
  
  //aumenta saldo em 1%
  public void monthlyUpdate() {
    float result = super.getBalance() * PERCENTAGE_INCREASE;
    super.deposit(result);
  }
}
