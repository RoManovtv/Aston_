class Park{
    static class Attraction{
        String name;
        String time;
        int price;

        Attraction(String name, String time, int price){
            this.name = name;
            this.time = time;
            this.price = price;
        }
    }
    String name;
    Park(String name){
        this.name = name;
    }
    public static void main(String[] args){
        Park park = new Park("Луна");
        Attraction attr1 = new Attraction("Колесо обозрения","10:00-21:00", 350);
        Attraction attr2 = new Attraction("Американские горки","10:00-20:00", 500);
        Attraction[] attractions = {attr1,attr2};

        System.out.println("Парк: " + park.name);
        for(Attraction attr: attractions) {
            System.out.println(attr.name + ": " + attr.time + ", " + attr.price + "руб.");

        }
    }

}