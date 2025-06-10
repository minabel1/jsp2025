

public class Car {
	
	public abstract class CC{
		
		final public void left() { 
	
		}
	
		abstract public void right();
		
		public void middle() {
			
		}
	}

	public class Bike extends CC{
	
		public void right() {
			
		}
//		public void left() {
//			
//		}
		
		public void middle() {
			super.middle();
		}
		
		
	
	Bike mini = new Bike();
	}
}