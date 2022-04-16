package cadastro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BankAgency {
  private Map<String, Client> clients;
  private Map<Integer, Account> accounts;
  private int nextAccountId = 0;

  //obtém conta ou lança excessão
  private Account getAccount(int id) throws AccountException {
    return accounts.get(id);
  }

  public BankAgency() {
    clients = new HashMap<String, Client>();
    accounts = new HashMap<Integer, Account>();
  }
  
  //se o cliente não existir
  //cria o cliente
  //cria uma conta poupança e uma conta corrent para o cliente
  //adiciona essas contas no vetor de contas e no vetor do cliente
  //adiciona o cliente no mapa de clientes
  public void addClient(String clientId) {
    if (!clients.containsKey(clientId)) {
      Client client = new Client(clientId);
      CheckingAccount ac1 = new CheckingAccount(nextAccountId, clientId);
      accounts.put(nextAccountId, ac1);
      client.addAccount(ac1);
      nextAccountId++;
      SavingsAccount ac2 = new SavingsAccount(nextAccountId, clientId);
      accounts.put(nextAccountId, ac2);
      client.addAccount(ac2);
      nextAccountId++;
      clients.put(clientId, client);
    }
  }

  //obtem o cliente e invoca as ações
  public void withdraw(int idConta, float value) {
    try {
      Account account = getAccount(idConta);
      account.withdraw(value);
    } catch (RuntimeException e) {
      System.out.println("fail: conta nao encontrada");
    }
  }

  public void deposit(int idConta, float value) {
    try {
      Account account = getAccount(idConta);
      account.deposit(value);
    } catch (RuntimeException e) {
      System.out.println("fail: conta nao encontrada");
    }
  }

  public void transfer(int contaDe, int contaPara, float value) {
    try {
      Account account = getAccount(contaDe);
      Account otherAccount = getAccount(contaPara);
      account.transfer(otherAccount, value);
    } catch (RuntimeException e) {
      System.out.println("fail: conta nao encontrada");
    }
  }
  
  public void monthlyUpdate() {
    for (int key : accounts.keySet())
      accounts.get(key).monthlyUpdate();
  }

  public String toString() {
    String formated = "Clients:";
    
    // dessa maneira não estava ficando igual a saída que o professor tinha colocado
    // for (Object key : clients.keySet())
    //   formated += "\n" + "- " + clients.get(key);

    // então fiz dessa outra maneira, para poder mostrar os clientes ordenado pela chave(nome)
    // já que o HashMap, não tem controle sobre a ordem e ficava bem estranho
    String[] keys = (String[]) clients.keySet().toArray(new String[0]);
    Arrays.sort(keys);

    for (int i = 0; i < keys.length; i++)
      formated += "\n" + "- " + clients.get(keys[i]);

    
    formated += "\nAccounts:";
    for (int key : accounts.keySet())
      formated += "\n" + key + ":" + accounts.get(key);
    
    return formated;
  }
};
