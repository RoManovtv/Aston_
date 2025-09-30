class Animal{
    private String name;
    private static int animalcount = 0;

    public Animal(String name){
        this.name = name;
        animalcount++;
    }
    public void run(int distance){
        System.out.println(name + " бежит " + distance +" м.");
    }

    public void swim(int distance) {
        System.out.println(name + " плывет " + distance + " м.");
    }
    public String getName(){
        return name;
    }
    public static int getAnimalcount(){
        return animalcount;
    }
}

class Dog extends Animal{
    private static int dogcount = 0;
    private final int max_run_distance = 500;
    private final int max_swim_distance = 10;

    public Dog(String name){
        super(name);
        dogcount++;
    }

    @java.lang.Override
    public void run(int distance) {
        if (distance<=max_run_distance){
            System.out.println(getName()+" пробежал " + distance + " м.");
        }
        else {
            System.out.println(getName()+ " не может пробежать " + distance + " м. Максимум " + max_run_distance + " м." );
        }
    }

    @java.lang.Override
    public void swim(int distance) {
        if (distance<=max_swim_distance){
            System.out.println(getName()+" проплыл "+ distance +" м.");
        }
        else{
            System.out.println(getName()+ " не может проплыть " + distance + " м. Максимум " + max_swim_distance +" м.");
        }
    }
    public static int getDogcount(){
        return dogcount;
    }
}

class Bowl {
    private int foodAmount;
    private final int capacity;

    public Bowl(int capacity) {
        this.capacity = capacity;
        this.foodAmount = 0;
    }

    public void addFood(int amount) {
        if (amount < 0) {
            System.out.println("Нельзя добавить отрицательное количество еды");
            return;
        }
        int newamount = foodAmount + amount;
        if (newamount > capacity) {
            foodAmount = capacity;
            System.out.println("Миска заполнена! Осталось " + (newamount - capacity) + " еды не поместилось.");
        } else {
            foodAmount = newamount;
            System.out.println("Теперь в миске " + foodAmount);
        }
        }
        public boolean decreaseFood ( int amount){
            if (amount < 0) {
                System.out.println("Нельзя взять отрицательное количество еды");
                return false;
            }
            if (foodAmount >= amount) {
                foodAmount -= amount;
                System.out.println("Из миски взято: " + amount + "/Осталось еды: " + foodAmount);
                return true;
            } else {
                System.out.println("В миске недостаточно еды. Нужно: " + amount + "Доступно: " + foodAmount);
                return false;
            }
        }

        public int getFoodAmount () {
            return foodAmount;
        }
        public int getCapacity () {
            return capacity;
        }

    }


class Cat extends Animal{
    private boolean isFull;
    private final int appetite;
    private static int catcount = 0;
    private final int max_run_distance = 200;

    public Cat(String name, int appetite){
        super(name);
        this.appetite = appetite;
        this.isFull = false;
        catcount++;
    }

    @java.lang.Override
    public void run(int distance) {
        if (distance<=max_run_distance){
            System.out.println(getName()+ " пробежал " + distance + " м.");
        }else{
            System.out.println(getName()+" не может пробежать "+ distance+" м. Максимум " + max_run_distance +" м.");
        }
    }

    @java.lang.Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }
    public static int getCatcount(){
        return catcount;
    }
    public void eat(Bowl bowl){
        if (isFull){
            System.out.println(getName()+" уже сыт.");
            return;
        }
        System.out.println(getName()+" подошел к миске. Ему нужно " + appetite + " еды.");
        if (bowl.decreaseFood(appetite)){
            isFull = true;
            System.out.println(getName() + " покушал и теперь сыт.");
        } else {
            System.out.println(getName() + " не стал есть, недостаточно еды");
        }
    }
    public boolean isFull(){
        return isFull;
    }
    public int getAppetite(){
        return appetite;
    }
}

public class AnimalDemo{
    public static void main(String[] args) {
        System.out.println("Тест класса животных");

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Мухтар");
        Cat cat1 = new Cat("Барсик", 10);
        Cat cat2 = new Cat("Мурка", 20);
        Cat cat3 = new Cat("Умка", 15);

        System.out.println("Тест бега");

        System.out.println("Собаки:");
        dog1.run(150);
        dog1.run(350);
        dog1.run(600);
        dog2.run(500);
        dog2.run(501);

        System.out.println("\nКоты:");
        cat1.run(100);
        cat2.run(200);
        cat3.run(201);
        cat1.run(50);
        cat2.run(300);

        System.out.println("\nПлавание\n");
        System.out.println("Собаки:");
        dog1.swim(10);
        dog1.swim(5);
        dog2.swim(30);
        dog2.swim(11);

        System.out.println("\nКоты");
        cat1.swim(5);
        cat2.swim(2);
        cat1.swim(0);

        System.out.println("\nСтатистика:");
        System.out.println("Всего животных: " + Animal.getAnimalcount());
        System.out.println("Всего собак:" + Dog.getDogcount());
        System.out.println("Всего кошек" + Cat.getCatcount());

        System.out.println("\nКормление котов\n");
        Bowl bowl = new Bowl(50);
        bowl.addFood(30);
        bowl.addFood(25);

        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Умка", 15),
                new Cat("Мурка", 20),
                new Cat("Васька", 12)
        };

        System.out.println("\nПроцесс кормления");
        for (Cat cat : cats){
            System.out.println("\n" + cat.getName());
            cat.eat(bowl);
        }
    }
}
