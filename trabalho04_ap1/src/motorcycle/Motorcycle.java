package motorcycle;

public class Motorcycle {
    private Person person; //agregacao
    private int power;
    private int time;
    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power) {
      this.person = null;
      this.power = power;
      this.time = 0;
    }

    //Comprar mais tempo
    public void buy(int time) {
      if (time > 0)
        this.time += time;
    }

    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean in(Person person) {
      if (this.person == null) {
        this.person = person;
        return true;
      }
      System.out.println("fail: moto ocupada");
      return false;
    }

    //Se houver uma person, retira e retorna
    //Se não, retorna null
    public Person out() {
      if (this.person != null) {
        Person pessoaRetirada = this.person;
        this.person = null;
        return pessoaRetirada;
      }
      System.out.println("fail: moto vazia");
      return null;
    }

    public void drive(int time) {
      if (this.person == null)
        System.out.println("fail: moto vazia");
      else if (this.person.getAge() > 10)
        System.out.println("fail: muito grande para andar de moto");
      else if (this.time == 0)
        System.out.println("fail: tempo zerado");
      else if ((this.time - time) <= 0) {
        System.out.printf("fail: andou %d min e acabou o tempo", this.time);
        this.time = 0;
      }
      else
        this.time -= time;

    }

    //buzinar
    public void honk() {
      if (this.person != null) {
        String texto = "P";
        for (int i = 0; i < power; i++)
          texto += "e";
        texto += "m";
        System.out.println(texto);
      } else 
        System.out.println("fail: moto vazia");
    }

    public String toString() {
      String texto = "potencia: ";
      texto += this.power;
      texto += ", minutos: ";
      texto += this.time;
      texto += ", pessoa: ";
      texto += person;
      return texto;
    }
}