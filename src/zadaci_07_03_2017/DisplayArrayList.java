package zadaci_07_03_2017;

import java.util.ArrayList;
import java.util.Date;

public class DisplayArrayList {
	public static void main(String[] args) {
	    ArrayList<Object> list = new ArrayList<>();
	    list.add(new Loan(10000));
	    list.add(new Date());
	    list.add(new String("String object"));
	    list.add(new Circle(5.5));

	    for (int i = 0; i < list.size(); i++)
	      System.out.println(list.get(i));
	  }

}
