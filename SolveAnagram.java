import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SolveAnagram {

	static AnagramSolutions solutions;
	static WordChecker dictionary;
	static ProgressBar progressBar;
	static int maxLetters = 10;

	public static void main(String[] args) {
		//make sure the user has only inputted 1 word
		if (args.length != 1) {
			print("You can only input 1 word!");
			return;
		} else if (args[0].length() > maxLetters) {
			print("Only use words that are under " +maxLetters+ " characters long!");
			return;
		}
		
		//initialise an anagram solution class
		solutions = new AnagramSolutions(args[0].length());
		print("Finding all possible combinations...");
		//call permute with param arg[0] and ""
		permute(args[0], "");
		print("\nFound all combinations!");
		print("Cross referencing words with a dictionary...");
		findCorrectWords(solutions);
		//delete solutions just in case some solutions are remembered in future
		solutions = null;
	}

	public static void findCorrectWords(AnagramSolutions solutions) {
		try {
			//create a new dictionary to check the words and a Hash Set to store
			//the correct words
			dictionary = new WordChecker();
			Set<String> correctWords = new HashSet<>();
			//create a new progress bar where each hashtag is added every 5%
			progressBar = new ProgressBar(0.04, 0.05);
			//iterate over all solutions
			for (int k = 0; k < solutions.numOfSolutions(); k++) {
				//if the dictionary contains this word then add it to the list of
				//correct words
				if (dictionary.contains(solutions.getWord(k))) {
					correctWords.add(solutions.getWord(k));
				}
				//update progress bar
				progressBar.updateProgress(k, solutions.numOfSolutions());
			}

			print("\n" + correctWords.toString());
			dictionary = null;
		} catch (Exception exc) {
			print("Oh no! Something happened...");
			print(exc.toString());
		}
	}

	public static void permute(String word, String newWord) {
		//in permute go through each letter
		for (int i = 0; i < word.length(); i++) {
			char letter = word.toCharArray()[i];
			//add on a letter to create a new word
			String newerWord = newWord + Character.toString(letter);
			//remove that character from word
			String oldWord = "";
			for (int j = 0; j < word.length(); j++) {
				String newLetter = Character.toString(word.toCharArray()[j]);
				oldWord = (i != j ? oldWord + newLetter : oldWord);
			}
			//check if the word is empty
			//if it is, output the new word else keep up the recursion!
			if (oldWord == "") {
				solutions.submitSolution(newerWord);
				return;
			} else {
				permute(oldWord, newerWord);
			}
		}
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
