package agenda1;

class Fone {
  private static char[] allowedCharacters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '.' };

  private String id;
  private String number;

  public Fone(String id, String number) {
    this.id = id;
    this.number = number;
  }

  //verifica se o número é um número de telefone válido
  public static boolean validate(String number) {
    char[] arrayNumber = number.toCharArray();
    for (int i = 0; i < arrayNumber.length; i++) {
      boolean notAllowed = true;
      for (int j = 0; j < allowedCharacters.length; j++)
        if (arrayNumber[i] == allowedCharacters[j])
          notAllowed = false;
      if (notAllowed)
        return false;
    }
    return true;
  }

  //O resultado deve ficar assim
  //oi:1234
  public String toString() {
    return this.id + ":" + this.number;
  }
  //GETS e SETS
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}