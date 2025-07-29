import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
	
	static StringBuilder sb= new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
			
		bw.write(new BigInteger("2").pow(n).subtract(new BigInteger("1"))+"\n");
		if(n <= 20) {
			hannoi(n, 1, 2, 3);
			bw.write(sb.toString());
		}
		
		bw.flush();
	}
	
	static void hannoi(int n, int start, int mid, int end) throws IOException {
		if(n==1) {
			sb.append(start+" "+end+"\n");
	
			return ;
		}
		
		// n-1개를 start -> mid로 이동
		hannoi(n-1, start, end, mid);
		// 위의 n-1개를 옮긴 후 남은 제일 큰 원판을 목적지로 옮김
		sb.append(start+" "+end+"\n");

		// n-1개를 mid -> end로 이동
		hannoi(n-1,mid, start, end);
	}

		
	

	
	
}
