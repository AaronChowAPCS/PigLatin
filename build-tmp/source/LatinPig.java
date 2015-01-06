import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class LatinPig extends PApplet {

//Aaron Chow
//This is my PigLatin Program


String [] vowels = {"a", "e", "i", "o", "u"};

public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	} 
}

public void draw()
{
}

public int findFirstVowel(String word)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
  for(int i = 0; i < word.length(); i++){
     for(int j = 0; j < vowels.length; j++){
        if(word.substring(i,i+1).equals(vowels[j]))
            return i;
     }   
  }
  return -1;
}

public String pigLatin(String word)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(word) == -1)
	{
		return word + "ay";
	}
	else if(findFirstVowel(word) == 0){
		return word + "way";
	}
	else if(word.substring(0,2).equals("qu")){
		return word.substring(2, word.length()) + word.substring(0,2) + "ay";
	}
	else if(findFirstVowel(word) != 0){
		return word.substring(findFirstVowel(word), word.length()) + word.substring(0,findFirstVowel(word)) + "ay";
	}
	else
	{
		return "ERROR!";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LatinPig" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
