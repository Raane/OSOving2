

/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman extends Thread{
	
	private CustomerQueue queue = null;
	private Gui gui = null;
	private boolean throwingInPeople = false;
	
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		this.queue = queue;
		this.gui = gui;
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		gui.println("doorman is throwing in people");
		throwingInPeople = true;
		setName("Doorman");
		start();
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		gui.println("doorman stopping!");
		throwingInPeople = false;
	}

	public void run() {
		while(throwingInPeople) {
			try {
				gui.println("doorman sleeping");
				sleep(Globals.doormanSleep);
				gui.println("doorman is awake!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				gui.println(e.toString());
			}
			queue.addCustomer(new Customer());			
		}
	}
}