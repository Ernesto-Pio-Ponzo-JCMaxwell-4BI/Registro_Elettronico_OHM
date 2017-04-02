package myclass;

//import util scanner per Input da tastiera
import java.util.Scanner;

public class Sottrazione{
    
    static void Sottrai(){
        int x, y, sottrazione;
        Scanner Input = new Scanner(System.in);
        System.out.println("Inserisci primo numero: ");
        x = Input.nextInt();
        System.out.println("Inserisci secondo numero: ");
        y = Input.nextInt();
        sottrazione = x - y;
        System.out.println("La sottrazione è: " + sottrazione);
    }
}
