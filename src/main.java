class Product {
    private String name;
    private String releaseDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean inStock;

    public Product(String name, String releaseDate, String manufacturer,
                   String country, double price, boolean inStock) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.inStock = inStock;
    }

    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}

public class main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024",
                "Apple Inc.", "USA", 5999, true);
        productsArray[2] = new Product("Xiaomi 14", "10.11.2023",
                "Xiaomi Corporation", "China", 4499, false);
        productsArray[3] = new Product("Google Pixel 8", "04.10.2023",
                "Google LLC", "USA", 3999, true);
        productsArray[4] = new Product("OnePlus 12", "05.12.2023",
                "OnePlus Technology", "China", 4899, true);
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар " + (i + 1) + ": " + productsArray[i]);
        }
    }
}