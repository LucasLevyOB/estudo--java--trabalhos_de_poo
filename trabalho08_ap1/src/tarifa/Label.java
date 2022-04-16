package tarifa;

//Essa enumeração guarda possíveis labels para as operações.
enum Label {
  saque("saque"), 
  deposito("deposito"), 
  tarifa("tarifa"), 
  extorno("extorno"), 
  abertura("abertura");
  
  private String name;
  //nas enums o Construtor tem que ser privado
  private Label(String name) {
      this.name = name;
  }
  String getName() {
      return this.name;
  }
  public String toString() {
      return this.name;
  }
}