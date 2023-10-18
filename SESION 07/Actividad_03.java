    }

    public static void metodo1() throws Exception {
        try {
            System.out.println("Método 1");
            throw new Exception();
        } catch (Exception excepcion) {
            System.out.println("La excepción se manejó en el método 1");
            throw excepcion;
        } finally {
            System.out.println("Se ejecutó finally en método 1");
        }
    }

    public static void metodo2() {
        try {
            System.out.println("Método metodo2");
        } catch (Exception excepcion) {
            System.out.println(excepcion);
        } finally {
            System.out.println("Se ejecutó finally en método2");
        }
    }
}

