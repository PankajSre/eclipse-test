package com.sample.project;

public class BinaryGap {

	public static void main(String[] args) {
		int N = 1041;
		int binary[] = new int[1000000];
        int index = 0;
       int binaryGap = 0;
        while(N>0){
            binary[index++] = N%2;
            N = N/2;
        }
       int count = 0;
        for(int i = 0; i<index-1;i++) {
        	if(binary[i] ==1) {
        		while(binary[i] ==0) {
        			count++;
        			i++;
        		}
        		
        		
        		
        	}
        	else
    			continue;
        	
        	if(count> binaryGap)
    			binaryGap = count;
    		count= 0;
        }
        System.out.println(binaryGap);

	}

}
