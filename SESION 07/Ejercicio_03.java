import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ExcepcionVocal extends Exception {
    public ExcepcionVocal(String mensaje) {
        super(mensaje);
    }
}

public class ExcepcionNumero extends Exception {
    public ExcepcionNumero(String mensaje) {
        super(mensaje);
    }
}

public class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco(String mensaje) {
        super(mensaje);
    }
}

public class ExcepcionSalida extends Exception {
    public ExcepcionSalida(String mensaje) {
        super(mensaje);
    }
}

public class LeerEntrada {
    private Reader stream;

    public LeerEntrada(InputStream fuente) {
        stream = new InputStreamReader(fuente);
    }

    public char getChar() throws IOException {
        return (char) this.stream.read();
    }

    public void procesar() throws IOException, ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        char caracter = getChar();
        if (Character.isDigit(caracter)) {
            throw new ExcepcionNumero("Excepción: Carácter es un número.");
        } else if (Character.isWhitespace(caracter)) {
            throw new ExcepcionBlanco("Excepción: Carácter es un espacio en blanco.");
        } else if ("aeiouAEIOU".indexOf(caracter) != -1) {
            throw new ExcepcionVocal("Excepción: Carácter es una vocal.");
        } else if (caracter == 'q') {
            throw new ExcepcionSalida("Programa finalizado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada(System.in);
        char caracter;
        try {
            do {
                caracter = lector.getChar();
                try {
                    lector.procesar();
                    System.out.println("Carácter procesado: " + caracter);
                } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco | ExcepcionSalida e) {
                    System.out.println(e.getMessage());
                }
            } while (caracter != 'q');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
