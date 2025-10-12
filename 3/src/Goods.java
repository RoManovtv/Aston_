public class Goods {
    String name;
    String date;
    String country;
    String manufacturer;
    int price;
    String booking;

    public static void main(String[] args) {
        Goods prod1 = new Goods();
        Goods prod2 = new Goods();
        prod1.name = "Бита";
        prod1.date = "09.11.2024";
        prod1.manufacturer = "Лес";
        prod1.country = "Россия";
        prod1.price = 1000;
        prod1.booking = "Да";
        prod2.name = "Компьютер";
        prod2.date = "05.11.2023";
        prod2.manufacturer = "Intel";
        prod2.country = "Китай";
        prod2.price = 120000;
        prod2.booking = "Нет";
        System.out.println("Продукт 1: " + prod1.name + "\nДата производства: " + prod1.date + "\nПроизводитель: " + prod1.manufacturer + "\nСтрана происхождения: " + prod1.country + "\nЦена: " + prod1.price + "\nБронь: " + prod1.booking);
        System.out.println("Продукт 2: " + prod2.name + "\nДата производства: " + prod2.date + "\nПроизводитель: " + prod2.manufacturer + "\nСтрана происхождения: " + prod2.country + "\nЦена: " + prod2.price + "\nБронь: " + prod2.booking);
    }
}