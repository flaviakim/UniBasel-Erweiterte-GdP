public class Element {
		
        private int priority;
        private String data;
        
        public String getData() { return data; }
        public int getPriority() { return priority; }

        public Element(int priority, String data) { 
        	this.priority = priority;
        	this.data = data;
        }
        public String toString()        {
        	return "Data: " + data + " Priority: " + priority;
        }
        
}


