package count_1in_binaryarry;

class Main
{
	// Function to find number of 1's in a sorted binary array
	public static int count(int[] A, int left, int right)
	{
		// if last element of the array is 0, no ones can
		// be present in it since it is sorted
		if (A[right] == 0) {
			return 0;
		}

		// if first element of the array is 1, all its elements
		// are ones only since it is sorted
		if (A[left] == 1) {
			return (right - left + 1);  // returns number of 1;s
		}

		// divide array into left and right sub-array and recur
		int mid = (left + right) / 2;
		return count(A, left, mid) + count(A, mid + 1, right);
	}

	public static void main(String[] args)
	{
		int[] A = { 0, 0, 0, 0, 1, 1, 1 };

		System.out.println("Total number of 1's present are "
									+ count(A, 0, A.length - 1));
	}
}