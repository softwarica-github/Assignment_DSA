// you are provided with an array A [] containing set of different words in the form of string 
// and you are provided with targeted word, 
// return length of subset s from set A required to from targeted word by using 
// combination of different letters of subset s.
package Week5;
import java.util.Arrays;

public class week5 {
   // saves every letter of the given word.
   char letterSearch;

   // each word or element of the main array is stored.
   String word;

   // saves each letter of the element in the main array's
   char letter;

   // This features duplicate elements as well as subsets in array form
   String[] subSet = new String[10];

   // remembers the discovered elemnt's index from the subgroup ,
   // which, if detected, is increased; else, it is not raised
   int subSetIndex = 0;

   // identifies the subset
   String[] find(String[] mainArray, String targetedWord) {

       // get each letter of the element/word of the main array ,
       // to compare each letter with targetd word's letter
       for (int i = 0; i < targetedWord.length(); i++) {

           // saves each letter of the targeted word i.e --> 'H o u s e'
           letterSearch = targetedWord.charAt(i);

           // checking the value
           System.out.print(letterSearch + " ");
           System.out.println();

           // search the letter whether it is found in word or not by calling the function
           searching(mainArray);

       }

       // array that contains actual subset
       return removingDuplicateElement(subSet);
   }

   // searches whether letter is found in the word or not
   void searching(String[] mainArray) {

       // loop that is used for getting each word/element from the main array
       // and compare the letter of the word with letter of the targeted word
       for (int j = 0; j < mainArray.length; j++) {

           // saves each word/ element of the main array i.e --> 'programming', 'for',
           // 'developers'
           word = mainArray[j];

           // checking the value
           System.out.println(word);

           // loop used for comparing  the letter of the word with letter of the targeted word
           for (int k = 0; k < mainArray[j].length(); k++) {

               // stores each letter of the word i.e. --> 'p r o g r a m m i n g', 'f o r', 'd
               // e v e l o p e r s '
               letter = mainArray[j].charAt(k);

               // checking the values
               System.out.print(letter + " ");

               // compares each letter of the targed word with letter of the word of the main
               // array
               if (letterSearch == letter) {

                   // cheking the value
                   System.out.println("Found " + letterSearch+ " in " + word);

                   // inserts in the array of subset but it still contains duplicate elements
                   // E.g frog ==> r ---> 'programming', o ---> 'programming', g ---> 'programming'
                   subSet[subSetIndex] = word;

                   // increases the index value of the subset so that if next element is found
                   // then, it is added in that index
                   subSetIndex++;

                   // out of the function if element is added
                   return;
               }
           }
           // for checking
           System.out.println();
           System.out.println();
       }
   }

   // removes duplicate element's from the subset array
   String[] removingDuplicateElement(String[] subSet) {

       // initilization of an array without containing duplicate elements
       String[] actualSubSet = new String[4];

       // length of the subset that contains duplicate elements
       // E.g frog ==> r ---> 'programming', o ---> 'programming', g ---> 'programming'
       int subSetLength = subSet.length;

       // initial position/index of the actual subset that shows empty just like top of
       // stack
       int nextElement = -1;

       // loop used to
       for (int i = 0; i < subSetLength - 1; i++) {

           // if current position element and next position element does not the same
           // then, insert into the actual subset , eliminating duplicates
           if (subSet[i] != subSet[i + 1]) {

               // inserts non-repeated element only in the acutal sub set
               actualSubSet[++nextElement] = subSet[i];
           }
       }

       // returns that array which is free from repating elements
       return actualSubSet;
   }

   // functions that counts the length of the subset
   int countLen(String[] actualSubSet) {
       // for counting elment only, not null
       int count = 0;

       // loop which gives actual subset length
       for (int i = 0; i < actualSubSet.length; i++) {

           // compares it is either the element or null, if element(true) then, count it
           if (actualSubSet[i] != null) {

               // increases the count value
               count++;
           }
       }

       // returns the length of the subset
       return count;
   }

   public static void main(String[] args) {

       // Given array
       String[] mainArray = { "Programming", "for", "developers" };

       // targeted word
       String targetedWord = "frog";

       // creates instance of the class
       week5 W = new week5();

       // calls the function and stores the array that contains subsets but also has
       // 'null'
       String[] actualSubSet = W.find(mainArray, targetedWord);

       // checking the values
       System.out.println("Removed Duplicate : " + Arrays.toString(actualSubSet));

       int actualLength = W.countLen(actualSubSet);

       // printing length of the subset
       System.out.println("Output: " + actualLength);

   }
}
