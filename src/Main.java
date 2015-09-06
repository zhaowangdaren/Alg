import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] datas = new int[]{88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262};
//		Algorithm.quickSort(datas, 0, datas.length - 1);
//		int result = getMostTimes(datas);
//		System.out.println(""+result);
		
//		String str = "bababb";
//		int[] next = new int[str.length()];
//		Algorithm.KMPNext1(next, str);
//		for(int i=0; i< next.length; i++){
//			System.out.print(""+next[i]);
//		}
//		String father = "ababababab";
//		String son = "abab";
//		int times = Algorithm.KMP(father, son);
//		System.out.println(""+times);
		
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		while(in.nextLine().length() > 0);
//		for(int i=0; i< n; i++){
//			String son = in.nextLine();
//			
//			String father = in.nextLine();
//			int times = Algorithm.KMP(father, son);
//			System.out.println(""+times);
//		}
		
//		String father = "ADDAADAADDAAADAAD";
//		String son = "D";
//		int times = KMP(father, son);
//		System.out.println(""+times);
		
//		int ssize = 8;
//		for(int i =0; i<8;i++){
//			ssize <<=1;
//			System.out.println(Integer.toBinaryString(ssize));
//		}
//		System.out.println(Integer.toBinaryString(ssize));
//		ssize >>= 1;
//		System.out.println(Integer.toBinaryString(ssize));
		
		Pair pair = new Pair();
		pair.setFirst(1);
		Integer i = (Integer) pair.getFirst();
		System.out.println();
		
		
		Pair2 pair2 = new Pair2();
		pair2.setFirst(2);
		Integer i2 = (Integer) pair.getFirst();
		System.out.println();
		
		double d = 1.11;
		pair.setFirst(d);
		d = (double) pair.getFirst();
		System.out.println(""+d);
	}

	
	private static void KMPNext(int[] next, String str){
		for(int i=0;i<str.length(); i++){
			for(int j=1; j< i; j++){
				String first = str.substring(0, j);
				String second = str.substring(i-j+1, i+1);
				if(first.equals(second)){
					if(j > next[i]){
						next[i]=j;
					}
				}
			}
			next[i] -= 1;
		}
	}
	
	private static int KMP(String father, String son){
		int times = 0;
		int[] next = new int[son.length()];
		KMPNext(next, son);
		
		int p=0;
		int q=0;
		while(p<father.length()){
			if(q < 0) q=0;
			if(q >= son.length()){
				times++;
				q=0;
				p--;
				continue;
			}
			if(father.charAt(p) == son.charAt(q)){
				p++;
				q++;
			}else{
				if(q == 0)p++;
				q=next[q];
			}
		}
		if( q >= son.length())times++;
		return times;
	}
	
	private static void quickSort(int s[], int left, int right)
	{
	    if (left < right)
	    {
	        int i = left, j = right, x = s[left];
	        while (i < j)
	        {
	            while(i < j && s[j] >= x)j--;  
	            if(i < j){
	            	s[i] = s[j];
					i++;
	            }
	            while(i < j && s[i] < x)i++;  
	            if(i < j){
					s[j] = s[i];
					j--;
	            }
	        }
	        s[i] = x;
	        quickSort(s, left, i - 1); 
	        quickSort(s, i + 1, right);
	    }
	}
	
	private static int getMostTimes(int[] datas){
		int result = datas[0];
		int resultTimes = 0;
		int counter = 0;
		for(int i=0; i < datas.length; i++){
			if(datas[i] == result) ++counter;
			else{//
				if(counter > resultTimes){
					resultTimes = counter;
//					result = datas[i];
				}else{
					if(resultTimes == counter)result = datas[i-1];
					counter = 0;
				}
			}
		}
		return result;
	}

}
