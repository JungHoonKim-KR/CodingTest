import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.IntStream;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
        int max_arr=Arrays.stream(arr).max().getAsInt();
        int count[] = new int[4002];
        int minus_count[]=new int[4001];
        Arrays.sort(arr);

        //1번
        System.out.println(Math.round(Arrays.stream(arr).average().getAsDouble()));
        //2번
        System.out.println(arr[n/2]);
        //3번
        int maxcount=0;
        int counting_index=0;
        int counting[]=new int[2];
        counting[0]=4001;
        counting[1]=4002;

        for (int j = 0; j < n; j++) {
            if(arr[j]>=0) {

                count[arr[j]]++;

            }

            else if(arr[j]<0)
                minus_count[Math.abs(arr[j])]++;
        }

        for(int z=0;z<count.length;z++){
            maxcount=Math.max(maxcount,count[z]);
            ;


        }
        for(int Z=0;Z< minus_count.length;Z++){
            maxcount=Math.max(maxcount,minus_count[Z]);

        }


        for(int k : arr){
            if(k<0) {
                if (minus_count[Math.abs(k)] == maxcount&&!IntStream.of(counting).anyMatch(x -> x == k)) {
                    counting[counting_index] = k;

                    counting_index++;


                }
                    if(counting_index==2) {
                      System.out.println(counting[1]);

                        break;
                    }

                }

             else if(k>=0)  {
                 if(count[k]==maxcount&&!IntStream.of(counting).anyMatch(x -> x == k)){
                     counting[counting_index] =k ;

                     counting_index++;
                     if(counting_index==2) {
                         System.out.println(counting[1]);
                         break;
                     }

                 }
            }

        }

        if(counting_index==1)
            System.out.println(counting[0]);

       //4번
       int range=Arrays.stream(arr).max().getAsInt()-Arrays.stream(arr).min().getAsInt();
        System.out.println(range);






    }








    }








