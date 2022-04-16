package pulapulanoparquinho;

import java.util.Locale;
import java.util.Scanner;

class Solver {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("arrive")) { // name age
                tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2])));
            } else if (ui[0].equals("in")) {
                tramp.in();
            } else if (ui[0].equals("out")) {
                tramp.out();
            } else if (ui[0].equals("remove")) {// name
                tramp.remove(ui[1]);
            } else if (ui[0].equals("show")) {
                System.out.println(tramp);
            } else if (ui[0].equals("dad_arrived")) {// name
                tramp.remove(ui[1]);
            } else if (ui[0].equals("balance")) {// name
                System.out.printf("%.2f%n", tramp.kidBalance(ui[1]));
            } else if (ui[0].equals("cash")) {
                System.out.printf("%.2f%n", tramp.getCash());
            } else if (ui[0].equals("close")) {
                tramp.close();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}