package com.baidu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Te {

   
	public static int longest(int[] ints){
        sort(ints);
        int longest = 0;
        for(int i=0;i<=ints[ints.length-1]-ints[0];i++){
            for(int j=0;j<ints.length-1;j++){
                int maxTmp = getMax(ints[j],ints,i,j);
                if(longest<maxTmp) longest = maxTmp;
            }
        }
        
        return longest;
    }
    
    private static int getMax(int begin,int[] ints,int cha,int j){
        int maxTmp = 1;
        for(int i=j+1;i<ints.length;i++){
            if(begin+cha==ints[i]){
                maxTmp ++;
                begin = begin+cha;
            }
        }
        return maxTmp;
    }
    
    private static int[] sort(int[] ints){
        for(int i=0;i<ints.length-1;i++){
            for(int j=i;j<ints.length;j++){
                if(ints[i]>ints[j]){
                    int t = ints[i];
                    ints[i] = ints[j];
                    ints[j] = t;
                }
            }
        }
        return ints;
    }
    
    
    public static void numOfPath(int n){
    System.out.println(Factor(n));
    }

    public static int Factor(int n){
    if (n==1) return 3;
    else if(n ==2) return 7;
    else return 2*Factor(n-1) + Factor(n-2);
    }

    
    public static int play(int n){
    	int count=0;
    	  int value=0;
    	  for(int i=1;i<Integer.MAX_VALUE;i++){
    	     for(int j=1;j<=i;j++){
    	       if(i%(j*j)!=0){
    	         count++;
    	         if(count==n){
    	           value=i;
    	           break;
    	         }
    	       }
    	     }
    	  }
    	  return value;
    }
    
    public static void main(String[] args) {
    	int[] values={3,8,4,5,6,2,2,9,10,12,11,13};
        Arrays.sort(values);
     
    	for(int i:values){
    		System.out.print(i+" ");
    	}
		int math=longest(values);
		System.out.println("最大组合"+math);
		
		numOfPath(4);
	}
   
	  
}
