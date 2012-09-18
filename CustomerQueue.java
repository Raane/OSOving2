import org.apache.commons.collections.buffer.CircularFifoBuffer;


/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
	
	private CircularFifoBuffer waitingroom = null;
	private CircularFifoBuffer waitingroomChairNumberer = null;
	private Gui gui = null;
	private Integer itarator = 0;
	
    public CustomerQueue(int queueLength, Gui gui) {
    	this.waitingroom = new CircularFifoBuffer(queueLength);
		this.gui = gui;
	}
    public void addCustomer(Customer customer) {
		waitingroom.add(customer);
		waitingroomChairNumberer.add((int)itarator);
		gui.fillBarberChair(itarator, customer);
		itarator = (itarator+1)%waitingroom.maxSize();
	}
    public Customer getCustomer() {
    	gui.emptyBarberChair((int)waitingroomChairNumberer.remove());
		return (Customer) waitingroom.remove();
	}
    
}
