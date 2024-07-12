import java.util.Scanner;
public class Main {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String arr=sc.next();
		int len=0;
		for (int i=0;i<arr.length();i++) {
			char b=arr.charAt(i);
			
			if(i!=arr.length()-1 && b=='c' && (arr.charAt(i+1)=='=' || arr.charAt(i+1)=='-')) {
				i+=1;
				
			}
			else if(i!=arr.length()-1 && b=='d' ) {
				if(arr.charAt(i+1)=='z') {
					if (i!=arr.length()-2&& arr.charAt(i+2)=='=') {
						i+=2;
					}
				}
				else if(arr.charAt(i+1)=='-') {
					i+=1;
				
				}
				
			}
			
			else if(i!=arr.length()-1 &&b=='l'&&arr.charAt(i+1)=='j') {
				i+=1;
			}
			else if(i!=arr.length()-1 &&b=='n'&&arr.charAt(i+1)=='j') {
				i+=1;
			}
			else if(i!=arr.length()-1 &&b=='s'&&arr.charAt(i+1)=='=') {
				i+=1;
			}
			else if(i!=arr.length()-1 &&b=='z'&&arr.charAt(i+1)=='=') {
				i+=1;
			}
			len+=1;
			
			
	
	

		
		
		
	}
		System.out.print(len);
	}
}
