package zadaci_28_02_2017;

class Stopwatch {
	long startTime;
	long endTime;

	Stopwatch() {
		this.startTime = System.currentTimeMillis();
	}

	public long start() {
		return this.startTime = System.currentTimeMillis();
	}

	public long stop() {
		return this.endTime = System.currentTimeMillis();
	}

	public long getElapsedTime() {
		return this.endTime - this.startTime;
	}

}

public class TestStopwatch {
	public static int minFromIndex(int[] array, int k) {
		int minElement = array[k];
		int index = 0;
		for (int i = k + 1; i < array.length; i++) {
			if (array[i] < minElement) {
				minElement = array[i];
				index = i;
			}
		}
		return index;
	}

	public static void selectionSort(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[minFromIndex(array, i)]) {
				index = minFromIndex(array, i);
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}

	public static void main(String[] args) {

		int[] array = new int[100000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		Stopwatch s1 = new Stopwatch();
		System.out.println("Start time (in milliseconds): " + s1.start());
		selectionSort(array);
		System.out.println("End time (in milliseconds): " + s1.stop());

		System.out.println("Elapsed time (in milliseconds): "
				+ s1.getElapsedTime());

	}

}
