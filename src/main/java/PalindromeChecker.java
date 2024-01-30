import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public String onlyLetters(String sString){
  String word = "";
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))){
      word+= sString.substring(i, i+1);
    }
  }
  return word;
}
public boolean palindrome(String sWord)
{
  String words = noCapitals(onlyLetters(sWord));
  String word = "";
  for(int i = sWord.length(); i > 0; i--){
    word+= sWord.substring(i-1, i);
  }
  return words.equals(noCapitals(onlyLetters(word)));
}
public String reverse(String sWord)
{
  String word = "";
  for(int i = sWord.length(); i > 0; i--){
    word+= sWord.substring(i-1, i);
  }
  return word;
}
public String noCapitals(String sWord){
  return sWord.toLowerCase();
}
}
