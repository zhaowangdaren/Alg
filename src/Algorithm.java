
public class Algorithm {

	public static void quickSort(int[] datas, int left, int right){
		if(left >= right)return;
		int start = left;
		int end = right;
		int key = datas[left];
		while(start < end){
			while(start < end && datas[end] >= key) end--;
			if(start < end){
				datas[start] = datas[end];
				start++;
			}
			
			while(start < end && datas[start] < key) start++;
			if(start < end){
				datas[end] = datas[start];
				end--;
			}
		}
		datas[start] = key;
		quickSort(datas, left, start - 1);
		quickSort(datas, start + 1, right);
	}
	
	public static void KMPNext(int[] next, String str){
		for(int i=0; i<str.length(); i++){
			int k =0;
			for(int j=1; j <= i;j++){
				if(str.substring(0, j).equals(str.substring(i-j+1 , i+1))){
					if(j > k)k=j;
				}
			}
			next[i] = k;
		}
	}
	
	public static void KMPNext1(int[] next, String str){
		int q = 0;
		for(int i=0; i<str.length(); i++){
			while(q < i && str.charAt(q) == str.charAt(i))q++;
			
			while(str.charAt(q) != str.charAt(i))q = next[q];
			
			
		}
	}
	
	public static int KMP(String father, String son){
		int[] next = new int[son.length()];
		KMPNext(next, son);
		
		int times = 0;
		int q=0;
		for(int p=0; p<father.length(); p++){
			if(q==0){
				char fChar = father.charAt(p);
				char sChar = son.charAt(q);
				if(father.charAt(p)== son.charAt(q)){
					q++;
				}

				continue;
			}
			if(q >= son.length()){
				times++;
				q=0;
				p--;
			}
			
			char fChar = father.charAt(p);
			char sChar = son.charAt(q);
			if(father.charAt(p)== son.charAt(q)){
				q++;
				continue;
			}else{//bu deng
				
				while(q != 0 && father.charAt(p) != son.charAt(q-1))q=next[q];
				
				if(father.charAt(p) == son.charAt(q-1))q++;
			}
			
		}
		if(q >= son.length())times++;
		return times;
	}
}
