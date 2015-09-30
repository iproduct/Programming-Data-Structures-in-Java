package sorting;

import java.util.Arrays;

public class SimpleSortingDemo {
	private static Integer[] a = {7, 3, 1, 19, 0 ,3, 5, 2, 11, 19, 6, 3, 1, 11, 7,
		16, 5, 13, 2, 1, 1, 5, 18, 3, 19, 4, 0, 7, 12};
	private static String[] s = 
		{"Ivan", "Pavel", "Geotrgi", "Petar", "Mihail", "Pencho", 
		"Ivan", "Gergana", "Sonya", "Gavril"};
	
	public static void swap(Comparable[] a, int index1, int index2) {
		Comparable temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	public static Comparable[] sortMinSelection(Comparable[] a) {
		for(int i = 0;  i < a.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < a.length; j++)
				if(a[j].compareTo(a[minIndex]) < 0)
					minIndex = j;
			swap(a, i, minIndex);
		}
		return a;
	}
	
	public static Comparable[] sortInsertion(Comparable[] a) {
		for(int i = 1;  i < a.length; i++) {
			Comparable insertedElement = a[i];
			int j;
			for(j = i - 1; j >= 0 && insertedElement.compareTo(a[j]) < 0; j--)
				a[j+1] = a[j];
			a[j + 1] = insertedElement;
		}
		return a;
	}
	
	public static Integer[] sortCounting(Integer[] a, int maxValue) {
		Integer[] sorted = new Integer[a.length];
		int[] counter = new int[maxValue];
		//count different possible values in counter array
		for(int i = 0; i < a.length; i++)
			counter[a[i]]++;
		
		//Calculate running sum of counters
		for(int i = 1; i < counter.length; i++)
			counter[i] += counter[i-1];
		
		//place original values in appropriate positions in sorted result array
		for(int i = 0; i < a.length; i++)
			sorted[--counter[a[i]]] = a[i];
		
		return sorted;
	}
	
	public static void qsort(Comparable[] a,int start,int end){
		//Recursive bottom
        if(end <= start) return;
        
        Comparable comp = a[start];
        int i = start,j = end + 1;
        for(;;){
            do i++; while(i<end && a[i].compareTo(comp)<0);
            do j--; while(j>start && a[j].compareTo(comp)>0);
            if(j <= i)   break;
            swap(a, i, j);
        }
        swap(a, start, j);
        
        //Recursive step
        qsort(a,start,j-1);
        qsort(a,j+1,end);
    }

    public static Comparable[] qsort(Comparable[] c){
        qsort(c,0,c.length-1);
        return c;
    }
	

	public static void main(String[] args) {
		System.out.println(Arrays.asList(a));
		System.out.println(Arrays.asList(qsort(a)));
		System.out.println(Arrays.asList(s));
		System.out.println(Arrays.asList(qsort(s)));

	}

}
