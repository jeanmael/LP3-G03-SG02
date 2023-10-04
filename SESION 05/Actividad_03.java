//03 CLASES JUNTAS
//CLASE PERSONAS
package com.mycompany.mavenproject1;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;

    public Persona(int id, String nombre, String apellido, int numeroCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCuenta: ";
    }

    char getTipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

//CLASE BANCO
package com.mycompany.mavenproject1;

public class Banco {
    private String nombre;
    private Persona clientes[];

    public Banco(String nombre) {
        this(nombre, 20);
    }

    public Banco(String nombre, int numCli) {
        this.nombre = nombre;
        this.clientes = new Persona[numCli];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona[] getClientes() {
        return clientes;
    }

    public void setClientes(Persona[] clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Persona persona) {
        boolean espacioDisponible = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = persona;
                espacioDisponible = true;
                break;
            }
        }
        if (espacioDisponible) {
            System.out.println("Cliente agregado correctamente.");
        } else {
            System.out.println("No hay espacio disponible para agregar al cliente.");
        }
    }

    public Persona darBajaCliente(Persona persona) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].equals(persona)) {
                Persona clienteDadoDeBaja = clientes[i];
                clientes[i] = null;
                System.out.println("Cliente dado de baja correctamente.");
                return clienteDadoDeBaja;
            }
        }
        System.out.println("Cliente no encontrado en la lista.");
        return null;
    }

    public boolean buscarCliente(Persona persona) {
        for (Persona cliente : clientes) {
            if (cliente != null && cliente.equals(persona)) {
                System.out.println("Cliente encontrado: " + cliente);
                return true;
            }
        }
        System.out.println("Cliente no encontrado.");
        return false;
    }

    public void clientesTipo(char tipo) {
        System.out.println("Clientes de tipo '" + tipo + "':");
        for (Persona cliente : clientes) {
            if (cliente != null && cliente.getTipo() == tipo) {
                System.out.println(cliente);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nombre del Banco: ").append(nombre).append("\n");
        builder.append("Clientes:\n");
        for (Persona cliente : clientes) {
            if (cliente != null) {
                builder.append(cliente.toString()).append("\n");
            }
        }
        return builder.toString();
    }
}

//CLASE TEST ASOCIACION
package com.mycompany.mavenproject1;

public class TestAsociacion {
    public static void main(String[] args) {
        Banco bcp = new Banco("BCP");
        Banco bbva = new Banco("BBVA");

        Persona cliente1 = new Persona(1, "Juan", "Perez", 123456);
        Persona cliente2 = new Persona(2, "Maria", "Gomez", 789012);
        Persona cliente3 = new Persona(3, "Carlos", "Lopez", 456789);

        bcp.agregarCliente(cliente1);
        bcp.agregarCliente(cliente2);
        bbva.agregarCliente(cliente2);
        bbva.agregarCliente(cliente3);

        char tipoBuscado = 'A';
        bcp.clientesTipo(tipoBuscado);
        bbva.clientesTipo(tipoBuscado);

        Persona clienteBuscado = new Persona(1, "Juan", "Perez", 123456);
        boolean encontrado = bcp.buscarCliente(clienteBuscado);
        if (encontrado) {
            System.out.println("Cliente encontrado en BCP.");
        } else {
            System.out.println("Cliente no encontrado en BCP.");
        }

        encontrado = bbva.buscarCliente(clienteBuscado);
        if (encontrado) {
            System.out.println("Cliente encontrado en BBVA.");
        } else {
            System.out.println("Cliente no encontrado en BBVA.");
        }

        Persona clienteDadoDeBaja = bcp.darBajaCliente(cliente1);
        if (clienteDadoDeBaja != null) {
            System.out.println("Cliente dado de baja en BCP: " + clienteDadoDeBaja.getNombre());
        } else {
            System.out.println("Cliente no encontrado en BCP para dar de baja.");
        }

        System.out.println("Información del Banco BCP:\n" + bcp.toString());
        System.out.println("Información del Banco BBVA:\n" + bbva.toString());
    }
}

