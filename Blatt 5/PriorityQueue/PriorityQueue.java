public class PriorityQueue {
        static final int SIZE = 32;
        Element[] q = new Element[SIZE];
        int len = 0;
        
        // Insert an element into the queue according to its priority
        boolean put(Element x) {
        
        	if (len == SIZE) {
        		return false;
        	}
        	
        	int i = 0;
        	
        	for (i = 0; i < len; i++) {
        		if (q[i].getPriority() < x.getPriority()) {
        			continue;
        		}
        	}
        	//i ist jetzt der Index für die Stelle, an welcher wir das neue Element einsetzen
        	
        	for (int j = len; j > i; j--) {
        		q[j] = q[j-1];
        	}
        	q[i] = x;
        	len++;
        	return true;
        }
        
        // Return the element with the highest priority from the queue
        Element get() {
        	if (len <= 0)
        		return null;	//oder System.out.println("ERROR");
        	//len > 0
        	Element x = q[0];
        	for (int i = 0; i < len-1; i++) {
        		q[i] = q[i+1];
        	}
        	q[len-1] = null;
        	len--;
         	return x;
        }
        
        // Return the queue length
        public int length() { 
        	return len;
        }

        // Print the queue contents
        public String toString() {
        	if (len == 0)
        		return "Empty Queue";
        	
        	String out = "";
        	for (int i = 0; i < len; i++) {
        		out += q[i].toString();
        		out += "\n";
        	}
        	return out;
        }
        
}
