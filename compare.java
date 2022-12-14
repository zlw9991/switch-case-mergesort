package switchcaseimprovement;
import java.util.*;
import java.lang.reflect.Array;
import java.math.*;
import java.util.Arrays;
import java.util.Random;

public class compare {
	public static int mergec = 0;
	public static int hmergec = 0;
	public static void main(String [] args) {
		
	int []l1k = new int[1000];
	int []l10k = new int[10000];
	int []l100k = new int[100000];
	int []l1m = new int[1000000];
	int []l10m = new int[10000000];
	
	Random rn = new Random();
	
	/*
	for(int i = 0; i < 1000; i++) {
		l1k[i] = rn.nextInt(1, 1001); // 1001 - > 1000, x value
	}
	
	for(int i = 0; i < 10000; i++) {
		l10k[i] = rn.nextInt(1, 1001);
	}
	
	for(int i = 0; i < 100000; i++) {
		l100k[i] = rn.nextInt(1, 1001);
	}
	
	for(int i = 0; i < 1000000; i++) {
		l1m[i] = rn.nextInt(1, 1001);
	}
	
	for(int i = 0; i < 10000000; i++) {
		l10m[i] = rn.nextInt(1, 1001);
	}*/
	
	int []tmp = null;
	int []tnk = null;
	int []rnk = null;
	int []lnk = null;
	long startTime;
	long timeElapsed;
	
	long st;
	long te;
	
	long sta;
	long ten;
	System.out.println("Mergesort vs if Else mergesort vs full switch case mergesort :");
	for(int i = 100000000; i <= 1000000000; i+=100000000) {
		tnk = new int[i];
		for(int t = 0; t < i;t++) {
		tnk[t] = rn.nextInt(1, 1001); // 1001 - > 1000, x value
			//tnk[t] = i - t;
		}
		/*
		for(int c = 0; c < i; c++) {
			System.out.print(Integer.toString(tnk[c])+" ");
		}
		System.out.println();*/
		rnk = Arrays.copyOf(tnk, i);
		lnk = Arrays.copyOf(tnk, i);
		// partial switch case mergesort
		System.out.println("partial switch case mergesort:");
		startTime = System.nanoTime();   
		tmp = mergesort(tnk);/*
		for(int  l= 0; l < i; l++) {
			System.out.print(Integer.toString(tmp[l])+" ");
		}
		System.out.println(); */
		timeElapsed = System.nanoTime() - startTime;
		
		// full if else mergesort
		System.out.println("full if else mergesort:");
		st = System.nanoTime();   
		tmp = imergesort(rnk);/*
		for(int  l= 0; l < i; l++) {
			System.out.print(Integer.toString(tmp[l])+" ");
		}
		System.out.println(); */
		te = System.nanoTime() - st;
		
		// full switch case mergesort
		System.out.println("full switch case mergesort:");
		sta = System.nanoTime();   
		tmp = smergesort(lnk);/*
		for(int  l= 0; l < i; l++) {
			System.out.print(Integer.toString(tmp[l])+" ");
		}
		System.out.println(); */
		ten = System.nanoTime() - sta;
		
		/*
		for(int  l= 0; l < i; l++) {
			System.out.print(Integer.toString(tmp[l])+" ");
		}*/
		System.out.println("partial sw   time: " + Long.toString(timeElapsed) );
		System.out.println("full if else time: " + Long.toString(te));
		System.out.println("full sw case time: " + Long.toString(ten));
		//System.out.println(); 
		//System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size: "+ Integer.toString(i));
		mergec = 0;
		
	}
	
	
	
	
	/*
	System.out.println("Mergesort only:");
	
	long startTime = System.nanoTime();   
	tmp = mergesort(l1k);
	long timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 1k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = mergesort(l10k);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 10k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = mergesort(l100k);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 100k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = mergesort(l1m);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 1M:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = mergesort(l10m);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 10M:");
	mergec = 0;
	
	System.out.println("Hybrid Mergesort:");
	
	startTime = System.nanoTime();   
	tmp = hmergesort(l1k);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 1k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = hmergesort(l10k);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 10k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = hmergesort(l100k);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 100k:");
	mergec = 0;
	
	startTime = System.nanoTime();   
	tmp = hmergesort(l1m);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 1M:");
	mergec = 0; */
	/*
	startTime = System.nanoTime();   
	tmp = hmergesort(l10m);
	timeElapsed = System.nanoTime() - startTime;
	System.out.println("Number of comparisons: " + Integer.toString(mergec)+ " Time Spent In Nanoseconds: "+Long.toString(timeElapsed) + ", for size 10M:");
	mergec = 0;*/
	
	/* testing
	int []tl = new int[10];
	for(int i = 0; i < 10; i++) {
		tl[i] = rn.nextInt(1, 11);
	}
	
	
	for(int i = 0; i < 10; i++) {
		System.out.print(Integer.toString(tl[i])+" ");
	}
	System.out.println();
	int []st = insertionsort(tl);
	for(int i = 0; i < 10; i++) {
		System.out.print(Integer.toString(st[i])+" ");
	} 
	*/
	}
	
	public static int[] insertionsort(int []l1) {
		
		for(int i = 1; i < l1.length; i++) {
			for(int g = i; g > 0; g--) {
				if(l1[g] < l1[g-1]) {
					mergec++;
					int tmp = l1[g];
					l1[g] = l1[g-1];
					l1[g-1] = tmp;
				} else {
					break;
				}
			}
		}
		return l1;
	}
	
	
	public static int[] merge(int []l1, int []l2) {
		int []rtl = new int[l1.length + l2.length];
		int l1c = 0;
		int l2c = 0;
		int rtc = 0;
		int swc = 0;
		while (l1c < l1.length && l2c < l2.length) {
			//swc = l1[l1c] - l2[l2c];
			switch(l1[l1c] - l2[l2c]) {
			case 0:
				mergec++;
				rtl[rtc] = l1[l1c];
				l1c++;
				rtc++;
				rtl[rtc] = l2[l2c];
				l2c++;
				rtc++;
				break;
			default:
				if(l1[l1c] - l2[l2c] < 0) {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					//break;
				} else {
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
			}
		}
		while (l1c < l1.length) {
			rtl[rtc] = l1[l1c];
			l1c++;
			rtc++;
		}
		
		while (l2c < l2.length) {
			rtl[rtc] = l2[l2c];
			l2c++;
			rtc++;
		}
		
		
		return rtl;
	}
	
	public static int[] imerge(int []l1, int []l2) {
		int []rtl = new int[l1.length + l2.length];
		int l1c = 0;
		int l2c = 0;
		int rtc = 0;
		int swc = 0;
		while (l1c < l1.length && l2c < l2.length) {
			//swc = l1[l1c] - l2[l2c];
			
				if(l1[l1c] - l2[l2c] < 0) {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
				} else if (l1[l1c] - l2[l2c] > 0){
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				} else {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
			
		}
		while (l1c < l1.length) {
			rtl[rtc] = l1[l1c];
			l1c++;
			rtc++;
		}
		
		while (l2c < l2.length) {
			rtl[rtc] = l2[l2c];
			l2c++;
			rtc++;
		}
		
		
		return rtl;
	}
	
	public static int[] smerge(int []l1, int []l2) {
		int []rtl = new int[l1.length + l2.length];
		int l1c = 0;
		int l2c = 0;
		int rtc = 0;
		int swc = 0;
		while (l1c < l1.length && l2c < l2.length) {
						//swc = l1[l1c] - l2[l2c];
			
			
			switch(l1[l1c] - l2[l2c]) {
			case 0:
				mergec++;
				rtl[rtc] = l1[l1c];
				l1c++;
				rtc++;
				rtl[rtc] = l2[l2c];
				l2c++;
				rtc++;
				break;
			default:
				//swc = (int) (((swc)|~(swc))>>>1) ^((((swc)|~(swc))>>>1) | swc);
				//swc = (int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c]); ~((~(0)>>>1)|val)
				//(int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c])
				switch((int)
						~((~(0)>>>1)|l1[l1c] - l2[l2c])
						) {
				case 0:
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					break;
				default:
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
				
			}
		}
		while (l1c < l1.length) {
			rtl[rtc] = l1[l1c];
			l1c++;
			rtc++;
		}
		
		while (l2c < l2.length) {
			rtl[rtc] = l2[l2c];
			l2c++;
			rtc++;
		}
		
		
		return rtl;
	}
	
	public static int[] smergesort(int []il) {
		if (il.length == 1) {
			return il;
		} else {
			int inl = il.length;
			int mid = Math.round(inl/2);
			int []ml1 = smergesort(Arrays.copyOfRange(il, 0, mid));
			int []ml2 = smergesort(Arrays.copyOfRange(il, mid, il.length));
			return smerge(ml1,ml2);
		}
	}
	
	public static int[] mergesort(int []il) {
		if (il.length == 1) {
			return il;
		} else {
			int inl = il.length;
			int mid = Math.round(inl/2);
			int []ml1 = mergesort(Arrays.copyOfRange(il, 0, mid));
			int []ml2 = mergesort(Arrays.copyOfRange(il, mid, il.length));
			return merge(ml1,ml2);
		}
	}
	
	public static int[] imergesort(int []il) {
		if (il.length == 1) {
			return il;
		} else {
			int inl = il.length;
			int mid = Math.round(inl/2);
			int []ml1 = imergesort(Arrays.copyOfRange(il, 0, mid));
			int []ml2 = imergesort(Arrays.copyOfRange(il, mid, il.length));
			return imerge(ml1,ml2);
		}
	}
	
	public static int[] hmergesort(int []il) {
		if (il.length == 1) {
			return il;
		} else {
			int inl = il.length;
			if(inl > 16) { // S value
			int mid = Math.round(inl/2);
			int []ml1 = hmergesort(Arrays.copyOfRange(il, 0, mid));
			int []ml2 = hmergesort(Arrays.copyOfRange(il, mid, il.length));
			return merge(ml1,ml2);} else {
				return insertionsort(il);
			}
		}
	}
	
	
	
}

