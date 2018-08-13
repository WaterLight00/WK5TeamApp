package edu.phoenix.mbl402.wk5teamapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProvider {

    public static List<Product> productList = new ArrayList<>();
    public static Map<String, Product> productMap = new HashMap<>();

    static {

        addProduct("blackPanther",
                "The Amazing Black Panther",
                "The Black Panther uses all his might to defeat his greatest enemy.",
                11, "blackPanther.png");
        addProduct("flash",
                "Flash: Identity Crisis",
                "Flash Struggles to define who he is...",
                13, "flash.png");
        addProduct("hulk",
                "The Incredible Hulk",
                "Wil the Hulk control get control or will his rage destroy his friends",
                13, "hulk.png"
                );
        addProduct("wolverine",
                "Ultimate Wolverine",
                "Logan goes on a journey of self-discovery, is he a hero?",
                19, "wolverine.png");
        addProduct("xmen",
                "The Uncanny Xmen",
                "The Xmen fight a new an mysterious enemy, what could Shadow Star want?",
                17, "xmen.png");
    }

    private static void addProduct(String itemId, String name,
                                   String description, double price, String image) {
        Product item = new Product(itemId, name, description, price, image);
        productList.add(item);
        productMap.put(itemId, item);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(product.getName());
        }
        return list;
    }

    public static List<Product> getFilteredList(String searchString) {

        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductId().contains(searchString)) {
                filteredList.add(product);
            }
        }

        return filteredList;

    }

}
