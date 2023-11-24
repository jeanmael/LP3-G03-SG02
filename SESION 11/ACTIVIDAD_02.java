public interface Pair<K, V> {
    K getKey();
    V getValue();
    void setKey(K key);
    void setValue(V value);

}

public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class App {
    public static void main(String[] args) {
      
        OrderedPair<Integer, Integer> pair1 = new OrderedPair<>(1, 10);
        OrderedPair<Integer, String> pair2 = new OrderedPair<>(2, "Two");
        OrderedPair<String, Persona> pair3 = new OrderedPair<>("Key", new Persona("John", "Direccion", "12345"));

        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);
    }
}

