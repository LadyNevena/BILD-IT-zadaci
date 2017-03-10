package zadaci_10_03_2017;

public class TestOutOfMemory {

	public static void main(String[] args) {
		 try {
		      int[] list = new int[100000000];
		      System.out.println("This array has a "+list.length+" elements");
		    }
		    catch (Error ex) {
		      ex.printStackTrace();
		      System.out.println("You are running out of memory.");
		    }
		    
		    System.out.println("After catch...");
	}
}
