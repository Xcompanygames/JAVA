
public class SingletonMultiThreads { 

	private static SingletonMultiThreads instance = null;

	private SingletonMultiThreads() {
	}

	public static SingletonMultiThreads getInstance() {
		if (instance == null) {
			synchronized (SingletonMultiThreads.class) {
				if (instance == null) {
					instance = new SingletonMultiThreads();
				}
			}
	
		}
		return instance;
	}

}