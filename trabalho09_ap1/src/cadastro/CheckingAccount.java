package cadastro;

public class CheckingAccount extends Account {
  private static final int DISCOUNT_20 = 20;
  
  //inicializa conta.type com "CC"
  public CheckingAccount(int id, String idClient) {
    super(id, idClient);
    super.type = "CC";
  }
  //retira 20 do saldo
  public void monthlyUpdate() {
    super.balance -= DISCOUNT_20;
  }
}
