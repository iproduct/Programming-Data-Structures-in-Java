package problems;

import java.util.Arrays;

public class MaxSubSequence {
	
	public static int[] findMaxSequence(int[] a) {
		int start = 0, end = 0, maxStart = 0, maxEnd = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] >= a[i-1]) {
				end = i;
			} else {
				if(end - start > maxEnd - maxStart) {
					maxStart = start;
					maxEnd = end;
				}
				start = i;
				end = i;
			}
		}
		
		int[] result = new int[2];
		result[0] = maxStart;
		result[1] = maxEnd + 1;
		return result;
	}

	public static void main(String[] args) {
		int[] a = {23, 15, 17, 92, 110, 4, 12, 67, 112, 150, 54, 45};
		int[] indices = findMaxSequence(a);
		System.out.println("Max Sub-Sequence [" + indices[0] + ", " + indices[1] + "]:");
		int[] maxSubSequence = Arrays.copyOfRange(a, indices[0], indices[1]);
		System.out.println(Arrays.toString(maxSubSequence));
	}

}
