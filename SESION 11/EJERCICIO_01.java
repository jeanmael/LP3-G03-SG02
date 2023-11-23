//Clase CandyBagsExample
//Clase CandyBagsExample

package com.mycompany.candybagsexample;

public class CandyBagsExample {
    public static void main(String[] args) {
        System.out.println("Ingrese las golosinas para la bolsa:");
        CandyBag candyBag = CandyBag.createCandyBagFromInput();

        System.out.println("\nLista de golosinas en la bolsa:");
        for (Goodie goodie : candyBag.getItems()) {
            System.out.println(goodie);
        }

        System.out.println("\nGolosina más económica:");
        Goodie cheapestGoodie = candyBag.cheapest();
        System.out.println(cheapestGoodie != null ? cheapestGoodie : "No hay golosinas en la bolsa");

        System.out.println("\nLas 2 golosinas más caras:");
        Bag<Goodie> mostExpensiveBag = candyBag.mostExpensive(2);
        for (Goodie goodie : mostExpensiveBag.getItems()) {
            System.out.println(goodie);
        }
    }
}


//Clase CandyBag
//Clase CandyBag

package com.mycompany.candybagsexample;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CandyBag extends Bag<Goodie> {

    @Override
    public void add(Goodie goodie) {
        if (!getItems().contains(goodie)) {
            super.add(goodie);
        }
    }

    public Goodie cheapest() {
        if (getItems().isEmpty()) {
            return null;
        }

        return Collections.min(getItems(), (g1, g2) -> Double.compare(g1.getPrice(), g2.getPrice()));
    }

    public Bag<Goodie> mostExpensive(int n) {
        Bag<Goodie> mostExpensiveBag = new Bag<>();

        List<Goodie> sortedGoodies = getItems();
        sortedGoodies.sort((g1, g2) -> Double.compare(g2.getPrice(), g1.getPrice()));

        for (int i = 0; i < Math.min(n, sortedGoodies.size()); i++) {
            mostExpensiveBag.add(sortedGoodies.get(i));
        }

        return mostExpensiveBag;
    }

    public static CandyBag createCandyBagFromInput() {
        CandyBag candyBag = new CandyBag();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de golosinas que desea agregar: ");
        int numGoodies = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numGoodies; i++) {
            System.out.println("\nGolosina #" + (i + 1));
            Goodie goodie = Goodie.createGoodieFromInput();
            candyBag.add(goodie);
        }

        return candyBag;
    }
}


//Clase Bag
//Clase Bag

package com.mycompany.candybagsexample;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> {
    private List<T> items;

    public Bag() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}


//Clase Goodie
//Clase Goodie

package com.mycompany.candybagsexample;

import java.util.Scanner;

public class Goodie {
    private String name;
    private double price;

    public Goodie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }

    public static Goodie createGoodieFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la golosina: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el precio de la golosina: ");
        double price = scanner.nextDouble();

        return new Goodie(name, price);
    }
}

