package practice2023.queueops;

abstract class Animal {
    String name;
    int order;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOlderThan(Animal animal) {
        return this.getOrder() < animal.getOrder();
    }
}
