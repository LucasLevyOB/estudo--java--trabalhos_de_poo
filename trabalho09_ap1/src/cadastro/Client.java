package cadastro;

import java.util.ArrayList;
import java.util.List;

public class Client {
  private String clientId;
  private List<Account> accounts;
  private static final byte ACCOUNT_LIMIT = 2;

  public Client(String clientId) {
    this.clientId = clientId;
    accounts = new ArrayList<Account>();
  }

  public void addAccount(Account account) {
    if (accounts.size() <= ACCOUNT_LIMIT) {
      accounts.add(account);
    }
  }

  public java.lang.String toString() {
    String formated = clientId + " [";
    int size = accounts.size();
    for (int i = 0; i < size; i++)
      formated += accounts.get(i).id + (i < size - 1 ? ", " : "");
    formated += "]";
    return formated;
  }
  
  //GETS and SETS
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
};
