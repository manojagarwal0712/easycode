package com.array;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.*;
import java.util.Arrays;

public class ArrayPractice {

    public static void rotateArray(int arr[], int k){
        for (int i =0;i<k;i++){
            rotateByOne(arr);
        }

        printArray(arr);
    }

    public static void printArray(int arr[]){
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void rotateByOne(int arr[]){
        int key =arr[0];
        for (int i =0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = key;
    }

    public static int binarySearch(int arr[], int start, int end, int key){
        if (arr.length==0){
            return -1;
        }
        int mid = start+(end-start)/2;

        if(key==arr[mid]){
            return mid;
        }
        else if (key>arr[mid]){
            return binarySearch(arr,mid+1,end,key);
        }else {
            return  binarySearch(arr,start,mid,key);
        }
    }

    /**
     * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * @param arr
     * int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
     * Maximum contiguous sum is 7
     */
    public static void findMaxSumSubArray(int arr[]){

        int windowSum =0;
        int maxSorFar=Integer.MIN_VALUE;
        int startIndex =0;
        int endIndex=0;

        for (int i=0;i<arr.length;i++){
            for (int j =i;j<arr.length;j++){
                windowSum=0;
                for (int k =i;k<j;k++){
                    windowSum+=arr[k];
                }
                //maxSorFar = Math.max(windowSum,maxSorFar);
                if (windowSum>maxSorFar){
                    maxSorFar = windowSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        System.out.println("Sum-"+maxSorFar +" startIndex-"+startIndex+" endIndex-"+endIndex);
    }

    public static void medianSortedArray(int arr1[], int arr2[]){

        int i=0;
        int k =0;
        int size =arr1.length;

        while (i<size){

        }

    }

    /**
     * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
     * Input: { 1, 4, 45, 6, 10, 8 }, sum =16
     * Output: 10,6
     * @param arr
     * @param key
     */
    public void findPairs(int arr[], int key){
        Set<Integer> set = new HashSet<>();

        for (int i =0; i<arr.length;i++){
            if (set.contains(key-arr[i])){
                System.out.println(arr[i] +"-"+(key-arr[i]));
            }else {
                set.add(arr[i]);
            }
        }

    }

    public static void findPaiInplace(int arr[], int key){

        //sort the array
        int left =0;
        int right = arr.length-1;

        while (left<right){
            if (arr[left]+arr[right]==key){
                System.out.println(arr[left]+"-"+arr[right]);
                left++;
                right++;
            }else if(arr[left]+arr[right]>key) {
                right++;
            }else {
                left++;
            }
        }

    }

    /**
     * https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
     *
     * @param arr
     */
    public static void removeDup(int arr[]){
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        //now re initin array with set
    }

    /**
     * https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
     * arr1[] = {7, 1, 5, 2, 3, 6}
     * arr2[] = {3, 8, 6, 20, 7}
     *
     * @param arr1
     * @param arr2
     */
    public static void findIntersectionOf2Aray(int arr1[], int arr2[]){
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++){
            if (set.contains(arr2[i])){
                System.out.println(arr2[i]);
            }
        }
    }

    public static void sort(int arr[]){
        int n = arr.length;
        for (int i =n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapfy(arr, i, 0);
        }

        for (int a:
             arr) {
            System.out.println(a);
        }
    }
    public static void heapfy(int arr[], int size, int root){

        int largest = root;
        int left = 2*root +1;
        int right = 2*root +2;

        if (left<size && arr[left]>arr[largest]){
            largest=left;
        }

        if (right<size && arr[right]>arr[largest]){
            largest=right;
        }
        if (largest!=root){
            int temp = arr[largest];
            arr[largest] = arr[root];
            arr[root] = temp;
            heapfy(arr,size,largest);
        }

    }

    /**
     * sort the array in O(nlogn) and then use this solution
     * @param arr
     * @return
     * https://www.geeksforgeeks.org/find-one-missing-number-range/
     * Input  :  arr[] = {13, 12, 11, 15}
     * Output :  14
     *
     */
   public static int findMissingNumberInRange(int arr[]){
        Set<Integer> set = new HashSet<>();
       for (int a:
            arr) {
           set.add(a);
       }
       for (int i =arr[0];i<arr[arr.length-1];i++){
           if (!set.contains(i)){
               return i;
           }
       }
       throw new IllegalArgumentException("none of the number is missing");
   }

    /**
     * https://www.geeksforgeeks.org/find-the-first-missing-number/
     * Given a sorted array of n distinct integers where each integer is in the range
     * from 0 to m-1 and m > n. Find the smallest number that is missing from the array.
     * Input: {0, 1, 2, 6, 9}, n = 5, m = 10
     * Output: 3
     * Input: {4, 5, 10, 11}, n = 4, m = 12
     * Output: 0
     *
     */
   public static int findSmallestMissingNumber(int arr[], int m){
       Set<Integer> set = new HashSet<>();
       for (int a:
            arr) {
           set.add(a);
       }

       for (int i =0;i<m;i++){
           if (!set.contains(i)){
               return i;
           }
        }
       throw new IllegalArgumentException("None of the number missing");
   }

   public static int findMissingNumebrinSortedArray(int []arr){

       int a = arr[0];
       for (int i =1;i<arr.length;i++){
           if (arr[i]!=a+1){
               return a+1;
           }
           a=arr[i];
       }
       throw new IllegalArgumentException("None of the number is missing");
   }

    /**
     * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
     *
     */
   public static void findPairEqualsSum(int arr[], int x){

        Set<Integer> set = new HashSet<>();

       for (int i =0;i<arr.length;i++){
           if (set.contains(x-arr[i])){
               System.out.println(arr[i] + "," + (x-arr[i]));
           }
           set.add(arr[i]);
       }
   }

    /**
     * https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
     * Input : arr[] = {4, 5, 6, 7, 6}
     *            k = 1
     *            x = 6
     * Output : 2
     * The first index of 6 is 2.
     *
     * Input : arr[] = {20, 40, 50, 70, 70, 60}
     *           k = 20
     *           x = 60
     * Output : 5
     * The index of 60 is 5
     *
     * @param arr
     */
   public static int searchInAdjacntDifferByK(int arr[], int x, int k){
       int i =0;
       while (i<arr.length){
            if (arr[i]==x){
                return i;
            }
            i=i+Math.max(1,Math.abs(arr[i]-x)/k);
        }
       return -1;
   }

    /**
     * https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
     * Input  : a[] = {1, 3, 2, 3, 4}
     * Output : 3
     */
   public static int findOnlyRepetitiveElement(int arr[]){
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            if (set.contains(arr[i])){
                return arr[i];
            }
            set.add(arr[i]);
        }

        throw new IllegalArgumentException("Incorrect input");
   }


    /**
     * https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
     * Input:  ar[] = {7, 3, 5, 4, 5, 3, 4}
     * Output: 7
     *
     *
     */
    public static void findElement(int arr[]){
        //use hash map and print the element with value coutn =1

    }

    /**
     * https://www.geeksforgeeks.org/leaders-in-an-array/
     *Write a program to print all the LEADERS in the array. An element is leader if it is
     * greater than all the elements to its right side. And the rightmost element is always
     * a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
     *
     * Sol:
     * Scan all the elements from right to left in an array and keep track of maximum till
     * now. When maximum changes its value, print it.
     */
    public static void findLeaders(int arr[]){

        int max_from_right=arr[arr.length-1];
        System.out.println(max_from_right);

        for (int i =arr.length-2;i>=0;i--){
            if (arr[i]>max_from_right){
                System.out.println(arr[i]);
                max_from_right=arr[i];
            }
        }

    }

    /**
     * Find the two repeating elements in a given array
     * https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
     */
    public static void findTwoRepElement(int arr[]){
        Set<Integer> set = new HashSet<>();
        for (int i =0;i<arr.length;i++){
            if (set.contains(arr[i])){
                System.out.println(arr[i]);
            }
            set.add(arr[i]);

        }
    }

    /**
     * https://www.geeksforgeeks.org/find-subarray-with-given-sum/
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * Ouptut: Sum found between indexes 2 and 4
     *
     */
    public static void findContiguousSubArrayWithSum(int arr[], int sum){

        int temp =0;
        for (int i =0;i<arr.length;i++){
            temp=arr[i];
            for (int j =i+1;j<arr.length;j++){
                temp =temp+arr[j];
                if (sum==temp){
                    System.out.println(i +","+j);
                    break;
                }
            }
        }

    }

    /**
     * https://www.geeksforgeeks.org/maximum-triplet-sum-array/
     *Input : arr[] = {1, 2, 3, 0, -1, 8, 10}
     * Output : 21
     * 10 + 8 + 3 = 21
     *
     * Sol1: sort the array and return the 3 max number O(nlogn)
     * sol2: find 3 max number in the array and return
     */
    public static void findMaxSumTriplet(int arr[]){
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for (int i =0;i<arr.length;i++){
            if (arr[i]>maxA){
                int temp = maxA;
                maxA=arr[i];
                maxC=maxB;
                maxB=temp;
            }else if(arr[i]<maxA && arr[i]>maxB){
                maxC=maxB;
                maxB=arr[i];
            }else if (arr[i]<maxA && arr[i]<maxB){
                if (arr[i]>maxC){
                    maxC=arr[i];
                }
            }
        }
        System.out.println(maxA +","+maxB+","+maxC);

    }

    /**
     * https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
     * Input : arr[] = {0, -1, 2, -3, 1}
     * Output : 0 -1 1
     *          2 -3 1
     *
     */
    public static void findAllTripletWithSumZero(int arr[]){

        for (int i =0;i<arr.length;i++){

            Set<Integer> set = new HashSet<>();
            for (int j=i+1;j<arr.length;j++){
                int x = -(arr[i]+arr[j]);
                if (set.contains(x)){
                    System.out.println("found triplet->"+arr[i]+","+arr[j] +","+x);
                }
                set.add(arr[j]);
            }

        }
    }

    /**
     * https://www.geeksforgeeks.org/check-whether-arithmetic-progression-can-formed-given-array/
     *
     * Input : arr[] = {0, 12, 4, 8}
     * Output : Yes
     * Rearrange given array as {0, 4, 8, 12}
     * which forms an arithmetic progression.
     */

    public static boolean findElementFormsAP(int arr[]){
        //sort the array
        Arrays.sort(arr);

        int d = arr[1]-arr[0];
        for (int i =2;i<arr.length-1;i++){
            if (arr[i+1]-arr[i]==d){
                return true;
            }
        }
        return false;
    }

    /**
     * https://www.geeksforgeeks.org/find-sum-non-repeating-distinct-elements-array/
     *Input  : arr[] = {12, 10, 9, 45, 2, 10, 10, 45,10};
     * Output : 78
     * Here we take 12, 10, 9, 45, 2 for sum
     * because it's distinct elements
     */
    public static int findSum(int arr[]){
        Set<Integer> set = new HashSet<>();

        int sum =0;
        for (int i =0;i<arr.length;i++){
            if (!set.contains(arr[i])){
                sum+=arr[i];
            }
            set.add(arr[i]);

        }
    return sum;
    }

    /**
     * https://www.geeksforgeeks.org/number-pairs-maximum-sum/
     *Input  : arr[] = {1, 1, 1, 2, 2, 2}
     * Output : 3
     * Explanation: The maximum possible pair
     * sum where i<j is  4, which is given
     * by 3 pairs, so the answer is 3
     * the pairs are (2, 2), (2, 2) and (2, 2)
     *
     * Input  : arr[] = {1, 4, 3, 3, 5, 1}
     * Output : 1
     * Explanation: The pair 4, 5 yields the
     * maximum sum i.e, 9 which is given by 1 pair only
     *
     */
    public static int maximumSumPairs(int arr[]){
        int maxSum = Integer.MIN_VALUE;

        for (int i =0;i<arr.length;i++){
            for (int j =i+1;j<arr.length;j++){
                maxSum = Math.max(maxSum,arr[i]+arr[j]);
            }
        }

        int count =0;
        for (int i =0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]+arr[j]==maxSum){
                    count++;
                    System.out.println(arr[i]+","+arr[j]);
                }
            }
        }
        return count;
    }

    /**
     * https://www.geeksforgeeks.org/find-closest-number-array/
     *
     * Input : arr[] = {1, 2, 4, 5, 6, 6, 8, 9}
     *              Target number = 11
     * Output : 9
     * 9 is closest to 11 in given array
     *
     * @param arr
     */
    public static void findClosestNumber(int arr[], int k){

        int min =Integer.MAX_VALUE;
        int num=0;

        for (int i =0;i<arr.length;i++){
            if ((k-arr[i])<min){
                num=arr[i];
                min=k-arr[i];
            }
        }
        System.out.println(num);
    }

    /**
     * https://www.geeksforgeeks.org/number-among-n-numbers-numbers-divisible/
     *
     * An efficient approach is to find smallest of all numbers, and check if it
     * divides all the other numbers, if yes then the smallest number will be the
     * required number.
     *
     * @param arr
     */
    public static int findNumberDevidesAllOthers(int arr[]){
        int min = Integer.MAX_VALUE;
        for (int i =0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }

        for (int i =0;i<arr.length;i++){
            if (arr[i]%min!=0){
                return -1;
            }
        }
        return min;

    }

    /**
     * https://www.geeksforgeeks.org/last-duplicate-element-sorted-array/
     * Input : arr[] = {1, 5, 5, 6, 6, 7}
     * Output :
     * Last index: 4
     * Last duplicate item: 6
     *
     */
    public static void findLastDup(int arr[]){

        // compare elements and return last
        // duplicate and its index
        for (int i = arr.length-1; i > 0; i--)
        {
            if (arr[i] == arr[i - 1])
            {
                System.out.println("Last index:" + i);
                System.out.println("Last duplicate item: "
                        + arr[i]);
                return;
            }
        }
    }

    /**
     * Find the sum of the 2nd most frequent integer in an array
     *
     * @param arr
     */
    public static void find2ndMostFrequentNumber(int arr[]){
        Map<Integer, Integer> map =new HashMap<>();
        for (int i =0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }

        int max = Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int key=0;
        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            if (entry.getValue()>max){
                secondMax=max;
                max=entry.getValue();
                key = entry.getKey();
            }else {
                if (entry.getValue()>secondMax){
                    secondMax=entry.getValue();
                    key=entry.getKey();
                }
            }
        }
        System.out.println(key*secondMax);

    }
    /**
     * Given an array S of n integers, find the pair with the largest difference
     *
     *
     */
    public static void largestDiff(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println(max+","+min);
        System.out.println(max-min);
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all triplets in the array which gives the sum of zero.
     *
     *Input : arr[] = {0, -1, 2, -3, 1}
     * Output : 0 -1 1
     *          2 -3 1
     *
     * Input : arr[] = {1, -2, 1, 0, 5}
     * Output : 1 -2  1
     *
     */

    public static void findTriplet(int arr[]){
        for (int i =0;i<arr.length;i++){

            //find all pairs with sum == -arr[i]

            Set<Integer> set = new HashSet<>();
            for (int j =i+1;j<arr.length;j++){
                int x = -(arr[i]+arr[j]);
                if (set.contains(x)){
                    System.out.println(arr[i]+","+arr[j]+","+x);
                }
                set.add(arr[j]);
            }
        }
    }

    /**
     * Write a function that returns whether an integer is a palindrome or not.
     * Input: 535
     * Out: True
     *
     * Input: 5315
     * OutPut: False
     *
     */

    public static boolean findIntegerPal(int num){
        int sum=0;
        int numTemp=num;
        while (num>0){
            sum = sum*10+num%10;
            num=num/10;
        }
        num=numTemp;
        if (sum==num){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Best Time to Buy and Sell Stock
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array. Also, the second number (selling price) must be larger than the first one (buying price).
     *
     * In formal terms, we need to find \max(prices[j] - prices[i])max(prices[j]−prices[i]), for every ii and jj such that j > ij>i.
     * ALLOWED ONLY ONCE
     * Slo1: find max and min such that j>i, O(n^2)
     * Sol2: find in O(n)
     * Sol3: FUQ: What if allowed to buy and sell multiple times
     */

    public static int findProfit(int arr[]){
        int maxProfit =0;

        for (int i =0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                int profit = arr[j]-arr[i];
                if (profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }

    public static int findProfitON(int arr[]){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for (int i =0;i<arr.length;i++){
            if (arr[i]<minPrice){
                minPrice = arr[i];
            }else if((arr[i]-minPrice)>maxProfit){
                maxProfit = arr[i];
            }
        }
        return maxProfit;
    }

    class Interval {
        int buy, sell;
    }
    public  void stockBuySell(int arr[]){

        int n = arr.length;
        if (n==1){
            return;
        }
        int count =0;
        ArrayList<Interval> sol = new ArrayList<>();

        int i=0;
        while (i<n-1){

            while ((i<n-1) && (arr[i+1]<=arr[i])){
                i++;
            }
            if (i==n-1){
                break;
            }
            Interval interval = new Interval();
            interval.buy =i++;

            while ((i<n)&& (arr[i]>=arr[i-1])){
                i++;
            }
            interval.sell=i-1;
            sol.add(interval);
            count++;
        }

        if (count==0){
            System.out.println("NO sol possible");
            return;
        }
        for (int j =0;j<count;j++){
            System.out.println("Buy at -"+ sol.get(j).buy +"sell at - "+ sol.get(j).sell);
        }

    }

    /**
     * m = n+m;
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     */
    public static void mergeTwoArray(int arr1[], int arr2[], int n, int m){
        int i =0;
        int j=0;

        while (i<n && j<m){

            if (arr1[i]<arr2[j]){

            }
        }
    }

    public static void main(String[] args) {
        int ar1[] = {1,2,3,4,5,6,7,8};
        //sort(ar1);
        //rotateArray(ar1,3);
        //findMaxSumSubArray(ar1);
        //System.out.println(findMissingNumebrinSortedArray(ar1));
        //findClosestNumber(ar1,11);
        System.out.println(binarySearch(ar1,0,7,6));
        //System.out.println(findNumberDevidesAllOthers(ar1));
    }
}
