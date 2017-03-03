package zadaci_03_03_2017;


class Time{
	private long currentHour;
	private long currentMin;
	private long currentSec;
	Time(){
		this(System.currentTimeMillis());
	}
	Time(long millisec){
		long sec = millisec / 1000;
		this.currentSec = sec % 60;
		long min = sec / 60;
		this.currentMin = min % 60;
		long hour = min / 60;
		this.currentHour = hour % 24;
	}
	Time(long hour, long min, long sec){
		setCurrentHour(hour);
		setCurrentMin(min);
		setCurrentSec(sec);
	}
	public long getCurrentHour() {
		return currentHour;
	}
	public void setCurrentHour(long currentHour) {
		this.currentHour = currentHour;
	}
	public long getCurrentMin() {
		return currentMin;
	}
	public void setCurrentMin(long currentMin) {
		this.currentMin = currentMin;
	}
	public long getCurrentSec() {
		return currentSec;
	}
	public void setCurrentSec(long currentSec) {
		this.currentSec = currentSec;
	}
	public void setTime(long elapseTime){
		long sec = elapseTime / 1000;
		this.currentSec = sec % 60;
		long min = sec / 60;
		this.currentMin = min % 60;
		long hour = min / 60;
		this.currentHour = hour % 24;
	}
	
	
	
}

public class TestTime {
	
	public static void main(String[] args) {
		

		Time t1=new Time();
		System.out.println(t1.getCurrentHour()+":"+t1.getCurrentMin()+":"+t1.getCurrentSec());
		
		Time t2=new Time(555550000);
		System.out.println(t2.getCurrentHour()+":"+t2.getCurrentMin()+":"+t2.getCurrentSec());
		
		Time t3=new Time(10,15,45);
		System.out.println(t3.getCurrentHour()+":"+t3.getCurrentMin()+":"+t3.getCurrentSec());
		
		/*t1.setTime(12345678);
		System.out.println(t1.getCurrentHour()+":"+t1.getCurrentMin()+":"+t1.getCurrentSec());
		*/
	}

}
