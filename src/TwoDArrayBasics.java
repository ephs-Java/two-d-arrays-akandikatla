import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class TwoDArrayBasics {

	public static void main(String[] args) {
		int size = 1;

		int[][] nums = new int[size][size];
		ArrayList<Integer>a = new ArrayList<Integer>();
		
//		while(a.size()<20000){
		fillRandom(nums);
		printArray(nums);
		System.out.println();
//		int startTime = (int) System.nanoTime();
		mirrorVir(nums);
//		int endTime = (int) System.nanoTime();
//		int duration = ((endTime - startTime)); 
//		a.add(duration);
//		//System.out.println(duration);
//		}
//		int sum = 0;
//		int largest = 0;
//		int smallest = 999999999;
//		for(int b : a){
//			if(b>largest)
//				largest = b;
//			if(b<smallest)
//				smallest = b;			
//			sum+=b;
//		}
		
//		System.out.println("Average time: "+(sum/a.size())/10+" microseconds");
//		System.out.println("Longest time: "+largest/10+" microseconds");
//		System.out.println("Shortest time: "+smallest/10+" microseconds");




	}

	public static void mirrorHor(int[][] nums) {

		for (int y = 0; y < nums.length; y++) {
			int[] a = new int[nums[0].length];

			for (int x = 0; x < nums[0].length; x++) {
				a[x] = nums[y][x];

			}

			a = mirror1DArray(a);

			for (int x = 0; x < nums[0].length; x++)
				nums[y][x] = a[x];

			System.out.println(Arrays.toString(a));
		}
		System.out.println();

		printArray(nums);

	}

	public static void mirrorVir(int[][] nums) {
		String GREEN = "\u001B[32m";
		String RESET = "\u001B[0m";

		for (int y = 0; y < nums[0].length; y++) {
			int[] a = new int[nums.length];

			for (int x = 0; x < nums.length; x++) {
				a[x] = nums[x][y];
			}

			a = mirror1DArray(a);

			for (int x = 0; x < nums.length; x++)
				nums[x][y] = a[x];

			System.out.println(Arrays.toString(a));
		}
		System.out.println();

		printArray(nums);

	}

	public static int[] mirror1DArray(int[] a) {

		 for(int x = 0; x<a.length/2;x++){
	            a[a.length-1-x]=a[x];
	        }
		 return a;

	}

	/*
	 * given the lower and upper bounds of the random numbers fill an array of
	 * random numbers
	 */

	public static void fillRandom(int[][] nums) {
		Random random = new Random();
		for (int x = 0; x < nums.length; x++) {

			for (int y = 0; y < nums[0].length; y++) {
				nums[x][y] = random.nextInt(10);
			}

		}
	}

	/*
	 * create a method that prints a 2D array
	 */

	public static void printArray(int[][] nums) {
		for (int x = 0; x < nums.length; x++) {
			for (int y = 0; y < nums[0].length; y++) {
				System.out.print(" " + nums[x][y] + " ");
			}
			System.out.println();

		}
	}

	/*
	 * return the sum of a row (r) in a 2D array (nums)
	 */

	public static int sum(int[][] a, int row) {
		int total = 0;
		for (int x = 0; x < a[0].length; x++) {
			total += a[row][x];
		}
		return total;
	}

	/*
	 * return an array of row sums of a 2D array (nums)
	 */

	public static int[] rowSums(int[][] nums) {
		int[] arr = new int[nums[0].length];
		for (int x = 0; x < nums.length; x++) {
			arr[x] = sum(nums, x);
		}
		for (int a : arr)
			System.out.print(a + " ");
		return arr;
	}

	/*
	 * check an 1D array for repeats, return true if all elements of the array
	 * are unique
	 */

	public static boolean isUnique(int[] a) {

		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a.length; y++) {

				if (a[y] == a[x]) {
					if (x != y)
						return false;
				}

			}
		}
		return true;

	}

	/*
	 * given an array return the index of the target value, return -1 if it is
	 * not found
	 */
	public static int binarySearchInts(int[] b, int a) {
		int startIndex = 0;
		int endIndex = b.length - 1;

		if (a > b[0] || a > b[b.length - 1])
			return -1;

		while (true) {

			if (startIndex == endIndex)
				return -1;

			int found = b[(startIndex + endIndex) / 2];

			if (found == a)
				return (startIndex + endIndex) / 2;

			else if (found > a)
				endIndex = (startIndex + endIndex) / 2;

			else
				startIndex = (startIndex + endIndex) / 2;

		}

	}

	/*
	 * return the min value in a 2D array
	 */
	public static int min(int[][] nums) {
		int min = 999;
		for (int x = 0; x < nums.length; x++) {
			for (int y = 0; y < nums[0].length; y++) {
				if (nums[x][y] < min)
					min = nums[x][y];
			}
		}
		return min;
	}

	/*
	 * return the max value in a 2D array
	 */

	public static int max(int[][] nums) {
		int max = -999;
		for (int x = 0; x < nums.length; x++) {
			for (int y = 0; y < nums[0].length; y++) {
				if (nums[x][y] > max)
					max = nums[x][y];
			}
		}
		return max;
	}

}
