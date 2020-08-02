package com.array;

import java.util.*;
import java.util.Arrays;

public class PracticeToDelete {

    public static void rotate(int arr[], int n){

        for (int i =0;i<n;i++){
            rotateByOne(arr);
        }
        for (int a:
             arr) {
            System.out.println(a);
        }
    }

    public static void rotateByOne(int arr[]){

        int key = arr[0];
        for (int i =0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = key;
    }

    public static int binarySearch(int arr[], int start,int end,int key){
        int mid = start + (end-start)/2;

        if (key==arr[mid]){
            return mid;
        }
        else if (key>arr[mid]){
            return binarySearch(arr,mid+1, end, key);
        }else {
            return binarySearch(arr,start,mid,key);
        }
    }

    public static void findMaxSumSubArray(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int startIndex =-1;
        int endIndex=-1;
        for (int i =0;i<arr.length;i++){

            for (int j =0;j<arr.length;j++){
                int windowSum=0;
                for (int k=i;k<j;k++){
                    windowSum+=arr[k];
                }
                if (windowSum>maxSum){
                    maxSum = windowSum;
                    startIndex=i;
                    endIndex=j;
                }
            }
        }
        System.out.println(maxSum+"i="+startIndex+"=j="+endIndex);
    }

    public static void findPairs(int arr[], int key){

        Set<Integer> set = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            if (set.contains(key-arr[i])){
                System.out.println(arr[i]+"-"+(key-arr[i]));
            }
            set.add(arr[i]);
        }
    }

    public static void findPairInplace(int arr[], int key){
        int i=0;
        int j = arr.length;
        Arrays.sort(arr);
        while (i<j){
            if (arr[i]+arr[j]==key){
                System.out.println(arr[i]+","+arr[j]);
            }else if (arr[i]+arr[j]>key){
                j--;
            }else {
                i++;
            }
        }
    }

    public static void removeDup(int arr[]){
        int temp[] = new int[arr.length];
        int j =0;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++){
            if (!set.contains(arr[i])){
                temp[j] = arr[i];
                j++;
                set.add(arr[i]);
            }
        }
        for (int a:
             temp) {
            System.out.println(a);
        }
    }

    public static void findIntersectionOfArrays(int arr1[], int arr2[]){
        Set<Integer> set = new HashSet<>();
        for (int i =0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for (int j=0;j<arr2.length;j++){
            if (set.contains(arr2[j])){
                System.out.println(arr2[j]);
            }
        }
    }

    public static void heapSort(int arr[]){
        int n = arr.length-1;
        for (int i =n/2-1;i>=0;i--){
            heapiFy(arr,n,i);
        }
        for (int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapiFy(arr,i,0);
        }
    }
    public static void heapiFy(int arr[], int root, int size){
        int larget = root;
        int left = 2*root+1;
        int right = 2*root +2;

        if (left<size && arr[left]>arr[larget]){
            larget = left;
        }
        if (right<size && arr[right]>arr[larget]){
            larget = right;
        }

        if (larget!=root){
            int temp = larget;
            larget = root;
            root = temp;
            heapiFy(arr,larget,size);
        }

    }
    /*
    Input  :  arr[] = {13, 12, 11, 15}
     * Output :  14
     */
    public static void findMissingNumnerInRange(int arr[]){
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i =0;i<arr.length;i++){
            set.add(arr[i]);
            if (arr[i]<min){
                min=arr[i];
            }
        }
        for (int i=min;i<arr.length;i++){
            if (!set.contains(arr[i])){
                System.out.println(arr[i]);
                break;
            }
        }
    }

    /**
     * * Input : arr[] = {20, 40, 50, 70, 70, 60}
     *      *           k = 20
     *      *           x = 60
     *      * Output : 5
     *      * The index of 60 is 5
     */
    public static int findNum(int arr[], int k,int x){
        int i =0;
        while (i<arr.length){
            if (arr[i]==k){
                return arr[i];
            }
            i = Math.max(1, Math.abs(arr[i]-x)/k);
        }
        return -1;
    }

    public static int findOnlyRepeatedNumber(int arr[]){
        Map<Integer, Integer> map =new LinkedHashMap<>();
        for (int i =0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }

        for (int i =0;i<arr.length;i++){
            if (map.get(arr[i])>1){
                return arr[i];
            }
        }
        return -1;
    }

    public static void findTripletWithSumZero(int arr[]){

        Set<Integer> set = new HashSet<>();

        for (int i =0;i<arr.length;i++){
            for (int j=i+1;j<arr.length-1;j++){
                int temp = -(arr[i]+arr[j]);
                if (set.contains(temp)){
                    System.out.println(arr[i]+","+arr[j]+","+temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        //rotate(arr,2);
        //System.out.println(binarySearch(arr,0,7,2));
        findIntersectionOfArrays(arr1,arr2);
    }


}
