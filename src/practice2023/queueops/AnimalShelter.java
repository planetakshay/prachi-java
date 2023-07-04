package practice2023.queueops;

import java.util.LinkedList;

/**
 * From cracking coding interview book
 */
public class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    // The below field is used for keep order of arrival of the animal
    // into the shelter as based on that, it will be determined which
    // animal is the oldest. This is also used to determine which animal
    // to give away when there is a conflict.
    private int order;

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Dog 1"));
        shelter.enqueue(new Dog("Cat 1"));
        shelter.enqueue(new Dog("Dog 2"));
        shelter.enqueue(new Dog("Dog 3"));
        shelter.enqueue(new Dog("Cat 2"));
        shelter.enqueue(new Dog("Cat 3"));
        shelter.enqueue(new Dog("Cat 4"));

        System.out.println("Adopted Animal 1: " + shelter.dequeueAny().getName());
        System.out.println("Adopted Animal 2: " + shelter.dequeueAny().getName());
        System.out.println("Adopted Animal 3: " + shelter.dequeueAny().getName());

        shelter.enqueue(new Dog("Cat 11"));
        shelter.enqueue(new Dog("Dog 21"));

        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());
        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());
        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());

        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());

        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());

        System.out.println("adopted animal after new animals' arrival: " + shelter.dequeueAny().getName());
        String animalName = shelter.dequeueAny() == null ? "None" : shelter.dequeueAny().getName();
        System.out.println("Last adopted animal: " + shelter.dequeueAny() == null ? "None" : animalName);
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            /**
             * Alternatively use addLast method to ensure
             *              the element is getting added at the end of the list
             *              since we are using it as a Queue. Which is a FIFO data structure
             *              and dequeue operation always remove the top element.
             *              to maintain FIFO the newly inserted elements should always go
             *              at the end of the existing list/queue.
             */
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        } else {
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if (dog.isOlderThan(cat)) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }
}