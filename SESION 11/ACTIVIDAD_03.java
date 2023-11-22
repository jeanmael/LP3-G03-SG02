import java.util.Arrays;

public class Bag<T> {
    private T[] list;
    private int count; 
    private int capacity;

    public Bag(int n) {
        this.list = (T[]) new Object[n];
        this.count = 0;
        this.capacity = n;
    }

    public void add(T obj) throws IsFull {
        if (count < capacity) {
            list[count] = obj;
            count++;
        } else {
            throw new IsFull("La bolsa está llena.");
        }
    }

    public T[] getObjects() throws IsEmpty {
        if (count > 0) {
            return Arrays.copyOf(list, count);
        } else {
            throw new IsEmpty("La bolsa está vacía.");
        }
    }

    public T remove(T obj) throws ObjectNoExist {
        int index = getIndex(obj);
        if (index != -1) {
            T removedObject = list[index];
            System.arraycopy(list, index + 1, list, index, count - index - 1);
            list[count - 1] = null;
            count--;
            return removedObject;
        } else {
            throw new ObjectNoExist("El objeto no existe en la bolsa.");
        }
    }

    public int getIndex(T obj) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Contenido de la bolsa:\n");
        for (int i = 0; i < count; i++) {
            result.append(list[i]).append("\n");
        }
        return result.toString();
    }
}  
