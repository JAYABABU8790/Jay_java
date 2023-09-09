package com.glca.serialization;

import java.util.Arrays;

public class IntermediateOperators {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int sum= Arrays.stream(arr).filter(e->e%2!=0).map(e->e*e).sum();
        System.out.println(sum);
    }
}
