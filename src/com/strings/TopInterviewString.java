package com.strings;

import java.util.*;

public class TopInterviewString {

    /*
    How to find the maximum occurring character in given String?

     */

    public static void maxOccChar(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i =0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }

        System.out.println(map);

        int max = Integer.MIN_VALUE;
        char ch ='#';
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()>max){
                max = entry.getValue();
                ch = entry.getKey();
            }
        }
        System.out.println(ch+"-"+max);
    }

    /**
     * How to remove all duplicates from a given string?
     * ### Write in place removal of dup
     */
    public static void removDup(String str){
        Set<Character> set = new LinkedHashSet<>();
        for (Character ch:
             str.toCharArray()) {
            set.add(ch);
        }
        String temp ="";
        for (Character ch:
             set) {
            temp = temp+ch;
        }
        str = temp;
        System.out.println(str);
    }

    /**
     * How to print the duplicate characters from the given String?
     *
     */
    public  static void printDup(String str){
        //Take Linked HasMap and in last print the elemets having more then 1 char as those wouod be
        //duplicates
    }

    /**
     * How to remove characters from the first String which are present in the second String?
     *
     *
     */
    public static void removeCharFromFristString(String str1, String str2){
       Queue<Character> queue = new LinkedList<>();
       String temp ="";
        for (Character ch:
             str1.toCharArray()) {
            queue.add(ch);
        }
        while (!queue.isEmpty()){
            Character ch = queue.remove();
            if(!str2.contains(""+Character.toLowerCase(ch))){
                temp = temp+ch;
            }
        }
        System.out.println(temp);
    }

    /**
     * How to check if two strings are rotations of each other?
     *
     * str1= "XYZ", str2="YXZ"
     *
     * **** Warning: while this is complex solution. The easy solition is to
     * add the string1 to it self (XYZXYZ) now check if str2 exist in concatenated string. then
     * rotation exist.
     *
     */
    public static boolean checkTwoStringAreRotation(String str1, String str2) {
        //Rotate the original string by one and compare with the rotated string if equals then
        //return true or else false. do this till the length of str1
        char ch[] = str1.toCharArray();
        if(str1.equalsIgnoreCase(str2)){
            return false;
        }
        for (int i =0;i<ch.length;i++){
            char temp[] = rotatebyOne(ch);
            //verify if the 2 array are same then return true or after the loop it will return false
        }
        return false;
    }
    public static char[] rotatebyOne(char ch[]){
        char temp = ch[0];
        for (int i =0;i<ch.length-1;i++){
            ch[i] = ch[i+1];
        }
        ch[ch.length-1]=temp;
        return ch;
    }

    /**
     * How to find the first non-repeating character in a given String?
     *
     *
     */
    public static void firstNonRepChar(String str){
        // take LinkedHaspMap and keep all the element in it.
        // now find the key with value 1 and that would be first onn -rep char
    }

    /**
     * How to find the smallest substring in a given string containing all characters of another string?
     *
     *
     * Str1:"this is a test string" and str2="tist"
     * output: "t stri"
     */
    public static String findminWindowString(String searchString, String t){

        //map of charachters that we need to match
        Map<Character, Integer> requiredCharacters = new HashMap<>();
        for (int i =0;i<t.length();i++){
            int occurrencesOfCharacter = requiredCharacters.getOrDefault(t.charAt(i),0);
            requiredCharacters.put(t.charAt(i),occurrencesOfCharacter+1);
        }

        /*
    For our window. Map all characters in the window to their occurrence count. You
    will see how we use this below.
  */
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();
        //2 pointers. Left holds the left index of the window we are inspecting and right
        //holds the right index.
        int left =0;
        int right =0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        /*
        'totalCharFrequenciesToMatch' is the total characters we need to match frequency for
    in the window. If I have 1 'a' in my window and I need 2 'a' chars...then the char
    frequencies don't match.

    'charFrequenciesInWindowThatMatch' is the count of frequencies that we have satisfied.

       When 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then it can be
    said that the current window satisfies that property of having all characters with matching
    counts to the string t.

       */

        totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        /*
        We will keep track of the best window we have seen so far
         */
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right<searchString.length()){

            /*
      Add the character on the right pointer to the hashtable that maps the characters seen
      in the window to their occurrence count
    */
            char characterAtRightPointer = searchString.charAt(right);

            //addCharacterToHashtableMapping();
            int occurrences = windowCharacterMapping.getOrDefault(characterAtRightPointer, 0);
            windowCharacterMapping.put(characterAtRightPointer, occurrences + 1);
            /*
            Is this character part of the requirement?
           */
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                /*
                Does the current window frequency match the required frequency?
                */
                boolean requirementForCharacterMet= requiredCharacters.get(characterAtRightPointer).intValue()
                        == windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    /*
          If so then we have one more frequency requirement that matches...remember when:
          'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then we know that
          we have a satisfying window
        */
                    charFrequenciesInWindowThatMatch++;
                }
            }

             /*
      Does this window satisfy? Ok...if it does try contracting the left pointer inward until
      we go over the right pointer.
    */
            while (charFrequenciesInWindowThatMatch==totalCharFrequenciesToMatch && left<=right){
            /*
        Put these things in plain English so you don't get confused
      */
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;
            /*
        Have we beat the best satisfiable window seen so far? Ok...if so then update
        the tracking variables
      */
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;;
                    minWindow = searchString.substring(left, right + 1);
                }
            /*
        This character will get contracted out. It won't be in the window anymore once
        left moves forward.
      */
                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);
              /*
        Was this character part of the requirement? If so then its frequency changing matters to us.
      */
              /*
        Was this character part of the requirement? If so then its frequency changing matters to us.
      */
              boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    /*
          Does the character frequence count not fall below the threshold of satisfying?
        */
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() <
                            requiredCharacters.get(characterAtLeftPointer).intValue();
                    if (characterFailsRequirement) {
          /*
            If so then we have one less character frequency mapping in the window that matches
          */
                        charFrequenciesInWindowThatMatch--;
                    }
                    /*
        Move the left point forward. We will keep going until the window no longer satisfies.
      */
                    left++;
                }
                /*
      We have moved left as far as it could go. It either led to a window that no longer
      satisfied or left passed the right pointer. Either way...advance the right pointer.
    */
                right++;


            }

        }

        return minWindow;
    }

    /**
     * How to check if two given String is the anagram of each other?
     * Note: An anagram contains are of the same length and contains the same character,
     * but in a different order, for example, "Army" and "Mary" is the anagram.
     *
     *
     */
    public static boolean findTwoStringAreAnagram(String str1, String str2){
        Map<Character,Integer> map = new HashMap<>();
        for (Character ch:
             str1.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
        for (Character ch:
                str2.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character,Integer> entry:
             map.entrySet()) {
            if(entry.getValue()%2!=0){
                return false;
            }
        }
        return true;

    }

    /**
     * How do you remove all occurance of a given character from String?
     *
     */
    public static String removeACharFromString(String str, char ch){

        if(str==null)
            return null;

        String temp ="";
        for (int i =0;i<str.length();i++){
            if(str.charAt(i)!=ch){
                temp += str.charAt(i);
            }
        }
        return temp;
    }

    /**
     * How do you check if a given string contains valid parentheses?
     *
     */
    public static void findValidParentheses(String str){

    }


    public static void main(String[] args) {
        System.out.println(removeACharFromString("Programming",'m'));
    }
}
