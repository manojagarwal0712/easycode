package com.strings;

import java.util.*;

public class Practice {


    public static int printNumberOfWords(String str){
        String arr[] = str.split("\\s");
        return arr.length;
    }

    public static void findFreq(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i)+1));
            }else {
                map.put(str.charAt(i),1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Character, Integer> set:
             map.entrySet()) {
            System.out.println(set.getKey()+"-"+set.getValue());
        }
    }

    /**
     * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
     * Input: string = “this is a test string”, pattern = “tist”
     * Output: Minimum window is “t stri”
     * Explanation: “t stri” contains all the characters of pattern.
     *
     */
    public static void findStringSmallestWindow(String str){

    }

    /**
     * https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
     * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.
     * Input: abc, k = 2
     * Output: 2
     *
     * Input: aba, k = 2
     * Output: 3
     * Possible substrings are {"ab", "ba", "aba"}
     *
     * Input: aa, k = 1
     * Output: 3
     * Possible substrings are {"a", "a", "aa"}
     *
     */

    public static int findDistSubString(String str, int k){

        int dist =0;
        int res =0;
        int []cnt = new int[26];

        for (int i =0;i<str.length();i++){
            dist=0;
            for (int j=i;j<str.length();j++){

                if (cnt[str.charAt(j)-'a']==0){
                    dist++;
                }
                cnt[str.charAt(i)-'a']++;

                if (dist==k){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * reverse a string
     * @param str
     * @return
     */
    public static String reverse(String str){
        String strRev = "";
        if (str==null || str.length()<=1){
            return str;
        }
        for (int i =str.length()-1;i>=0;i--){
            strRev+=str.charAt(i);
        }
        return strRev;
    }

    /**
     * Write a method that will print out the locations of a word within a string of words.
     * NOTE: If this is too challenging for the QAE-2, then have them locate the first
     * location of the word within the string
     *
     */

    public static void findWord(String inputString, String searchWord){
        String word="";
        int startIndex=-1;
        int endIndex=-1;
        int j=0;
        for (int i =0;i<inputString.length();i++){

            if(j<=(searchWord.length()-1) && inputString.charAt(i)==searchWord.charAt(j)){
                j++;
                if (startIndex==-1){
                    startIndex=i;
                }else {
                    if (j==(searchWord.length()-1)){
                        endIndex=i+1;
                        break;
                    }
                }
            }else {
                startIndex=-1;
                j=0;
            }
        }

        System.out.println(startIndex +","+endIndex);
    }

    /**
     * Write a method to find out the prime numbers in 1 to 100
     *
     */
    public static void findPrimeNumber(int a, int b){
        boolean isPrime=true;
        while (a<=b){
            isPrime=true;
            if (a==1){
                a++;
                continue;
            }
            if (a==2){
                System.out.println(a);
                a++;
                continue;
            }
                for (int i=2;i<a;i++){
                if (a%i==0){
                    isPrime=false;
                    break;
                }
            }
            if (isPrime){
                System.out.println(a);
            }
            a++;
        }
    }

    /**
     * Given two string arrays, create a method to return all the common strings between
     * the arrays.
     *
     */

    public static void findCommonStrings(String arr1[], String arr2[]){
        Set<String> set = new HashSet<>();
        for (int i =0;i<arr1.length;i++){
            set.add(arr1[0]);
        }
        for (int i=0;i<arr2.length;i++){
            if (set.contains(arr2[i])){
                System.out.println(arr2[i]);
            }
        }
    }

    /**
     * Remove duplicate characters in a string
     * Given a string "banana", return unique string "ban"
     */
    public static String removeDuplicateCharFromString(String str){
        if (str==null){
            return str;
        }
        Set<Character> set = new HashSet<>();
        String strUnique="";
        for (int i =0;i<str.length();i++){
            if (!set.contains(str.charAt(i))){
                strUnique+=str.charAt(i);
                set.add(str.charAt(i));
            }
        }
        return strUnique;
    }

    /**
     * Write a function to count how many times the substring appears in the larger String.
     *
     */

    public static int findSubStringCount(String str, String sbStr){

        int count =0;
        int len = sbStr.length();
        for (int i=0;i<=str.length()-len;i++){
            int index = sbStr.length()+i;
            if((str.substring(i,index)).equalsIgnoreCase(sbStr)){
                count++;
            }
        }
        return count;
    }

    /**
     * Write a function that returns the nth number in the fibonacci’s sequence
     *
     *
     */

    public static int findnthFibNumber(int n){

        if (n<=0){
            throw new IllegalArgumentException("Invalid number");
        }
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int next=1;
        int prev=0;
        int sum =0;
        for (int i =2;i<n;i++){
            sum = next+prev;
            prev=next;
            next=sum;
        }
        return sum;
    }

    /**
     * Find the smallest window in a string containing all characters of another string
     * Input: string = “this is a test string”, pattern = “tist”
     * Output: Minimum window is “t stri”
     * Explanation: “t stri” contains all the characters of pattern.
     *
     *
     */

    public static void findSmallestWindowString(String str1, String str2){
        String res=null;
        for (int i =0;i<str1.length();i++){
            for (int j=i;j<str1.length();j++){
                String temp = str1.substring(i,j);
                if (containAllChar(temp,str2)){
                    if (res==null || res.length()==0){
                        res = temp;
                    }else {
                        if (temp.length()<res.length()){
                            res=temp;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static boolean containAllChar(String str1, String str2){
        Map<Character,Integer> map = new HashMap<>();
        for (int i =0;i<str1.length();i++){
            if (map.containsKey(str1.charAt(i))){
                map.put(str1.charAt(i),map.get(str1.charAt(i))+1);
            }else {
                map.put(str1.charAt(i),1);
            }
        }

        for (int i =0;i<str2.length();i++){
            if (map.containsKey(str2.charAt(i))){
                if (map.get(str2.charAt(i))!=null){
                    map.put(str2.charAt(i),map.get(str2.charAt(i))-1);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * https://www.youtube.com/watch?v=XpyAp5abmBI&t=677s
     *
     * @param str
     * @return
     */
    public static String [] findAllSubSeqOfString(String str){
        if (str.length()==0){
            String ans[]={""};
            return ans;
        }
        //Lets the string be "xyz", this is to find subsequence of string "yz"
        String []temp = findAllSubSeqOfString(str.substring(1));
        //this is to append the first char on the all the subseq found for string "yz" that wouod be
        //twice the number of subseq. above.
        String ans[]= new String[2*temp.length];

        int k=0;
        for (int i=0;i<temp.length;i++){
            ans[k] = temp[i];
            k++;
        }
        for (int i =0;i<temp.length;i++){
            ans[k] = str.charAt(0)+temp[i];
            k++;
        }
        return ans;
    }

    public static void printSubSeq(String str, String outPutSorFar){

        if (str.length()==0){
            System.out.println(outPutSorFar);
            return;
        }
        //when we choose not to inlcude 1st char
        printSubSeq(str.substring(1),outPutSorFar);
        //when we choose to select first char
        printSubSeq(str.substring(1),outPutSorFar+str.charAt(0));

    }
    public static void printSubSeq(String str){
        printSubSeq(str, "");
    }

    /**
     * https://www.youtube.com/watch?v=_AcZZfGQ7mU
     *
     * @param str
     */
    public static void permutationOfString(String str){
        ArrayList<String> arrayList = new ArrayList<>();

        getPermutation("",str,arrayList);

        System.out.println(arrayList);
    }

    public static void  getPermutation(String f, String u, ArrayList<String> res){

        if (u.length()==0){
            res.add(f);
            return ;
        }
        for (int i=0;i<u.length();i++){
            //fixed + first char of unfixed and then fixed+ 2nd char of unfixed  and so on
            String fixed = f+ u.charAt(i);
            String unFixed = u.substring(0,i)+u.substring(i+1);
            getPermutation(fixed,unFixed,res);
        }
    }

    /**
     * https://www.geeksforgeeks.org/longest-subsequence-where-every-character-appears-at-least-k-times/
     * Input : str = "geeksforgeeks"
     *          k = 2
     * Output : geeksgeeks
     * Every character in the output
     * subsequence appears at-least 2
     * times.
     *
     * Input : str = "aabbaabacabb"
     *           k = 5
     * Output : aabbaabaabb
     *
     *Sol1: Find all subseq. and check if the subseq. having every char equesl k
     */
    public static void findSubSeqWithKDistChar(String str, int k){
        int freq[] = new int[26];

        for (int i =0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        for (int i =0;i<str.length();i++){
            if (freq[str.charAt(i)-'a']>=k){
                System.out.print(str.charAt(i));
            }
        }
    }

    /**
     * https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
     *
     */
    public static boolean findIfSubString(String str1, String str2){

        int j =0;
        for (int i =0;i<str1.length();i++){
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }else {
                j=0;
            }
            if (j==str2.length()){
                return true;
            }
        }
        return false;
    }

    /**
     * https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
     *Input: str1 = "AXY", str2 = "ADXCPY"
     * Output: True (str1 is a subsequence of str2)
     *
     * Input: str1 = "AXY", str2 = "YADXCP"
     * Output: False (str1 is not a subsequence of str2)
     */
    public static boolean findIfSubSeq(String str1, String str2){

        int j =0;
        for (int i =0;i<str1.length() && i<str2.length();i++){
            if (str1.charAt(j)==str2.charAt(i)){
                j++;
            }
        }

        if (j==str2.length()){
            return true;
        }
        return false;
    }

    public static boolean palnDrome(String str){

        String rev = "";
        for (int i =str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        if (str.equalsIgnoreCase(rev)){
            return true;
        }
        return false;
    }
    /**
     * longest palndrom
     */
    public static void longestPal(String str){
        int len =Integer.MIN_VALUE;
        String pal = "";
        for (int i =0;i<=str.length();i++){
            for (int j =i+1;j<=str.length()-1;j++){
                String temp = str.substring(i,j);
                if (palnDrome(temp) && temp.length()>len){
                    pal = temp;
                    len=pal.length();
                }
            }
        }
        System.out.println(pal);
    }

    public static void longestCommonSubSeq(String str1, String str2){
        System.out.println(lcs(str1.toCharArray(),str2.toCharArray(),str1.length(),str2.length()));
    }

    public static int lcs(char []arr1, char []arr2, int m, int n ){
        if (m==0 || n==0){
            return 0;
        }
        if (arr1[m-1] == arr2[n-1]){
            return 1+lcs(arr1,arr2,m-1,n-1);
        }else {
            Math.max(lcs(arr1,arr2,m,n-1),lcs(arr1,arr2,m-1,n));
        }
        return 0;
    }

    /**
     * Longest Common Prefix using Sorting
     * https://www.geeksforgeeks.org/longest-common-prefix-using-sorting/
     * Input: {"geeksforgeeks", "geeks", "geek", "geezer"}
     * Output: "gee"
     *
     * Input: {"apple", "ape", "april"}
     * Output: "ap"
     */

    public static String longestCommonPrefix(String arr[]){

        String pref="";

        for (int i =0;i<arr[0].length();i++){
            char ch = arr[0].charAt(i);
            for (int j=1;j<arr.length;j++){
                if (i<=arr[j].length()){
                    if (ch!=arr[j].charAt(i)){
                        return pref;
                    }
                }

            }
            pref=pref+ch;

        }
        return pref;
    }
    /**
     * https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
     * Find number of times a string occurs as a subsequence in given string
     * Input:
     * string a = "GeeksforGeeks"
     * string b = "Gks"
     *
     * Output: 4
     *
     * Explanation:
     * The four strings are - (Check characters marked in bold)
     * GeeksforGeeks
     * GeeksforGeeks
     * GeeksforGeeks
     * GeeksforGeeks
     *
     */

    public static void findSubSeqCount(String str, String subSeq){

    }
    public static void main(String[] args) {

        //System.out.println(largestDiff(1));
        //findWord("How Good GOD IS", "GOD");
        //findFreq("How Good GOD Is.");
        //findPrimeNumber(1,100);
        String arr[] = {"apple", "ape", "april"};
        //System.out.println(findIfSubString("xyzabdabc","abc"));
        System.out.println(longestCommonPrefix(arr));
    }
}
