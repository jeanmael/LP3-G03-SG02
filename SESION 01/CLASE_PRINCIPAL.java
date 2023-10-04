import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int vida, rp;
        boolean fl = false;
        vida = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            vida++;
            System.out.println("Vida:" + vida + "\t¿Cuál es el número secreto?");
            rp = sc.nextInt();
            if (rp == 1234)
                fl = true;
        } while (vida < 3 && !fl);
        
        if (fl) {
            System.out.println("¡Adivinaste!");
            
            String premio = "";
            switch (vida) {
                case 1:
                    premio = "Un pasaje al caribe";
                    break;
                case 2:
                    premio = "Una visita al museo más cercano a tu casa";
                    break;
                case 3:
                    premio = "Una entrada al cine";
                    break;
            }
            
            System.out.println("Premio ganado: " + premio);
        } else {
            System.out.println("¡Ups, perdiste!");
        }
    }
}
