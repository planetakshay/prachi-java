package practice.designpatterns.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

	/**
	 * This is needed when the object changes between serialization and
	 * de-serialization.
	 */
	private static final long serialVersionUID = -693657031818126414L;

	public static Singleton instance = null;

	private Singleton() {

	}

	public static Singleton getInstance() {

		// Checking nullity two times is called double checked locking.
		// Some developers don't like this approach as its a performance hit.

		if (instance == null) {

			synchronized (Singleton.class) {

				if (instance == null) {

					instance = new Singleton();
				}
			}
		}

		return instance;
	}

	public static synchronized Singleton getInstace() {

		if (instance == null) {

			instance = new Singleton();
		}

		return instance;
	}

	// This is used when the object is serialized. The following method will not
	// create a new object at the time of serialization.
	public Object readResolve() {

		return instance;
	}
}