package temagotchi;

public class Pet {
  private int energyMax, hungryMax, cleanMax;
  private int energy, hungry, shower;
  private int diamonds;
  private int age;
  private boolean alive;

  public Pet(int energy, int hungry, int shower) {
    this.energy = this.energyMax = energy;
    this.hungry = this.hungryMax = hungry;
    this.shower = this.cleanMax = shower;
    this.diamonds = 0;
    this.age = 0;
    this.alive = true;
  }

  // Atribui o valor de energia
  // Se o valor ficar abaixo de 0, o pet morre de fraqueza
  // Garanta que os valores ficarão no interalo 0 - max
  // Use esse modelo para fazer os outros métodos set
  public void setEnergy(int value) {
    if (value <= 0) {
      this.energy = 0;
      System.out.println("fail: pet morreu de fraqueza");
      this.alive = false;
    } else if (value > this.energyMax)
      this.energy = this.energyMax;
    else
      this.energy = value;
  }

  public void setHungry(int value) {
    if (value <= 0) {
      this.hungry = 0;
      System.out.println("fail: pet morreu de fome");
      this.alive = false;
    } else if (value > this.hungryMax)
      this.hungry = this.hungryMax;
    else
      this.hungry = value;
  }

  public void setClean(int value) {
    if (value <= 0) {
      this.shower = 0;
      System.out.println("fail: pet morreu de sujeira");
      this.alive = false;
    } else if (value > this.cleanMax)
      this.shower = this.cleanMax;
    else
      this.shower = value;
  }

  public int getClean() {
    return this.shower;
  }

  public int getHungry() {
    return this.hungry;
  }

  public int getEnergy() {
    return this.energy;
  }

  public int getEnergyMax() {
    return this.energyMax;
  }

  public int getCleanMax() {
    return this.cleanMax;
  }

  public int getHungryMax() {
    return this.hungryMax;
  }

  public String toString() {
    // E:4/10, S:0/3, L:1/10, D:3, I:3
    String texto = "E:" + this.energy + "/" + this.energyMax + ", ";
    texto += "S:" + this.hungry + "/" + this.hungryMax + ", ";
    texto += "L:" + this.shower + "/" + this.cleanMax + ", ";
    texto += "D:" + this.diamonds + ", ";
    texto += "I:" + this.age;
    return texto;
  }

  public boolean testAlive() {
    return this.alive == true;
  }

  // Invoca o método testAlive para verificar se o pet esta vivo
  // Se estiver vivo, altere os atributos utilizando os métodos set e get
  public void play() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 2);
      this.setHungry(this.getHungry() - 1);
      this.setClean(this.getClean() - 3);
      this.diamonds++;
      this.age++;
    } else {
      System.out.println("fail: pet esta morto");
    }
  }

  public void shower() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 3);
      this.setHungry(this.getHungry() - 1);
      this.setClean(this.getCleanMax());
      this.age += 2;
    } else {
      System.out.println("fail: pet esta morto");
    }
  }

  public void eat() {
    if (this.testAlive()) {
      this.setEnergy(this.getEnergy() - 1);
      this.setHungry(this.getHungry() + 4);
      this.setClean(this.getClean() - 2);
      this.age++;
    } else {
      System.out.println("fail: pet esta morto");
    }
  }

  public void sleep() {
    if (!this.testAlive())
      System.out.println("fail: pet esta morto");
    else if (this.testAlive() && (this.getEnergyMax() - this.energy >= 5)) {
      this.age += this.getEnergyMax() - this.getEnergy();
      this.setEnergy(this.getEnergyMax());
      this.setHungry(this.getHungry() - 1);
    } else {
      System.out.println("fail: nao esta com sono");
    }
  }
}
