

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
	
	private int queueLength = 0;
	private boolean[] waitingroom = null;
	private Gui gui = null;
	
    public CustomerQueue(int queueLength, Gui gui) {
		this.queueLength = queueLength;
		this.gui = gui;
		this.waitingroom = new boolean[queueLength];
	}
    public void addCustomer() {
		queueLength++;
		
	}
}
