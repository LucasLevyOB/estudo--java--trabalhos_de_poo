package car;

public class Car {
    private int pass; // Passageiros
    private int passMax; // limite de Passageiros
    private int gas; // tanque
    private int gasMax; // limite do tanque
    private int km; // quantidade de quilometragem

    public Car() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }

    public String toString() {
        String texto = "pass: ";
        texto += this.pass;
        texto += ", gas: ";
        texto += this.gas;
        texto += ", km: ";
        texto += this.km;
        return texto;
    }

    public void in() {
        if (this.pass < this.passMax)
            this.pass++;
        else 
            System.out.println("fail: limite de pessoas atingido");
    }

    public void out() {
        if (this.pass > 0)
            this.pass--;
        else 
            System.out.println("fail: nao ha ninguem no carro");
    }

    public void fuel(int gas) {
        if (gas <= 0)
            this.gas += 0;
        else if ((this.gas + gas) >= this.gasMax)
            this.gas = this.gasMax;
        else
            this.gas += gas;
    }

    public void drive(int km) {
        if (this.pass == 0)
            System.out.println("fail: nao ha ninguem no carro");
        else if (this.gas == 0)
            System.out.println("fail: tanque vazio");
        else if (km > this.gas) {
            System.out.printf("fail: tanque vazio apos andar %d km%n", this.gas);
            this.km += this.gas;
            this.gas = 0;
        } else {
            this.km += km;
            this.gas -= km;
        }
    }
};
