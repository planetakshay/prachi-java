package practice2023.design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern covered in Interview Kickstart.
 */
public class ImplementObserver {
    public static void main(String[] args) {
        // Entity that is observed.
        MobilePhone phone = new MobilePhone();
        // Observer that is monitoring the location change
        MobileApp app = new MobileApp();
        // Register observer to receive notifications after the
        // state change.
        phone.register(app);
        phone.move(3.0, 5.0);
        phone.move(2.0, 4.0);
        phone.move(-3.0, -5.0);
        phone.move(3.0, 5.0);
    }
}

class MobilePhone {
    double latitude;
    double longitude;

    List<Observer> observers;

    void move(double lat, double log) {
        latitude += lat;
        longitude += log;
        locationChanged();
    }

    void register(Observer obs) {
        if(observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(obs);
    }

    private void locationChanged() {
        observers.forEach(o -> o.update(latitude, longitude));
    }
}

abstract class Observer {
    abstract void update(double lat, double log);
}

class MobileApp extends Observer {

    @Override
    void update(double lat, double log) {
        System.out.println("Latest latitude: " + lat + " longitude: " + log);
    }
}