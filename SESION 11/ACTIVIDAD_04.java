public class Goodies implements Contenedora {
    private int id;
    private String description;
    private float price;

    public Goodies(int id, String description, float price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean contiene(Object objeto) {
        if (objeto instanceof Integer) {
            int idObjeto = (Integer) objeto;
            return this.id == idObjeto;
        }
        return false;
    }
}

public class Biscuits extends Goodies {
    public Biscuits(int id, String description, float price) {
        super(id, description, price);
    }
}

public class Chocolates extends Goodies {
    public Chocolates(int id, String description, float price) {
        super(id, description, price);
    }
}

public class Soda extends Goodies {
    public Soda(int id, String description, float price) {
        super(id, description, price);
    }
}

public class Sweet extends Goodies {
    public Sweet(int id, String description, float price) {
        super(id, description, price);
    }
}

import java.util.Arrays;


public class Bag<T> {
    private T[] list;
    private int count;

    public Bag(int n) {
        this.list = (T[]) new Object[n];
        this.count = 0;
    }

    public void add(T obj) {
        if (count < list.length) {
            list[count++] = obj;
        }
    }

    public T[] getObjects() {
        return Arrays.copyOf(list, count);
    }

    public T remove(T obj) {
        int index = getIndex(obj);
        if (index != -1) {
            T removedItem = list[index];
            System.arraycopy(list, index + 1, list, index, count - index - 1);
            count--;
            return removedItem;
        }
        return null;
    }

    public int getIndex(T obj) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Contenido de la bolsa:\n");
        for (T item : getObjects()) {
            result.append(item).append("\n");
        }
        return result.toString();
    }
}

public interface Contenedora {
    boolean contiene(Object objeto);
}


public class App {
    public static void main(String[] args) {
        try {
            Biscuits biscuits = new Biscuits(1, "Delicioso Biscuits", 5.0f);
            Chocolates chocolates = new Chocolates(2, "Sweet Chocolates", 8.0f);
            Soda soda = new Soda(3, "Soda Stereo", 2.5f);
            Sweet sweet = new Sweet(4, "Sweet", 3.0f);

            Bag<Goodies> goodiesBag = new Bag<>(5);
            goodiesBag.add(biscuits);
            goodiesBag.add(chocolates);
            goodiesBag.add(soda);
            goodiesBag.add(sweet);

            System.out.println(goodiesBag);

            goodiesBag.remove(chocolates);

            System.out.println("\nContenido de la bolsa despues de la eliminacien:");
            System.out.println(goodiesBag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
