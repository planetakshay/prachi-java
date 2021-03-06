package practice.designpatterns.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {

		this.weatherData = weatherData;

		weatherData.registerObserver(this);

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

		System.out.println("Current Conditions: \nTemperature: "
				+ this.temperature + "\nHumidity: " + this.humidity);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub

		this.temperature = temp;

		this.humidity = humidity;

		display();

	}

}
