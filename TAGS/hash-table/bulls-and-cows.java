/*
 You are playing the following Bulls and Cows game with your friend: You write
down a number and ask your friend to guess what the number is. Each time your
friend makes a guess, you provide a hint that indicates how many digits in said
guess match your secret number exactly in both digit and position (called
"bulls") and how many digits match the secret number but locate in the wrong
position (called "cows"). Your friend will use successive guesses and hints to
eventually derive the secret number.  For example: Secret number:  "1807"
Friend's guess: "7810" Hint: 1 bull and 3 cows. (The bull is 8 , the cows are 0
, 1 and 7 .)  Write a function to return a hint according to the secret number
and friend's guess, use A to indicate the bulls and B to indicate the cows. In
the above example, your function should return "1A3B" .  Please note that both
secret number and friend's guess may contain duplicate digits, for example:
Secret number:  "1123"
Friend's guess: "0111" In this case, the 1st 1 in friend's guess is a bull, the
2nd or 3rd 1 is a cow, and your function should return "1A1B" .  You may assume
that the secret number and your friend's guess only contain digits, and their
lengths are always equal.  Credits: Special thanks to @jeantimex for adding this
problem and creating all test cases.   Subscribe to see which companies asked
this question    Show Tags   Hash Table
*/


import java.util.Hashtable;public class Solution {    public String getHint(String secret, String guess) {        int right = 0, wrong = 0;        HashMap<Character, Integer> st = new HashMap<>();        HashMap<Character, Integer> gt = new HashMap<>();        for(int i = 0; i < secret.length(); i++) {            if (secret.charAt(i) == guess.charAt(i)) right++;            else {                if (!st.containsKey(secret.charAt(i))) st.put(secret.charAt(i),1);                else st.put(secret.charAt(i),st.get(secret.charAt(i))+1);                if (!gt.containsKey(guess.charAt(i))) gt.put(guess.charAt(i),1);                else gt.put(guess.charAt(i),gt.get(guess.charAt(i))+1);            }        }            for (Character key : st.keySet()) {                // System.out.print(key+"\t");                if(gt.containsKey(key)){                    wrong += Math.min(st.get(key), gt.get(key));                }            }        return right+"A"+wrong+"B";    }}