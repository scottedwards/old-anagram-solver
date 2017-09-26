import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordChecker {
  private Set<String> wordSet;
  //add all words from word.txt into a hashmap
  //create a method to see if a word is correct
  public WordChecker() throws IOException {
    //get the absolute path of the
    Path path = Paths.get("words.txt");

    byte[] readBytes = Files.readAllBytes(path);
    String wordListContents = new String(readBytes, "UTF-8");
    String[] words = wordListContents.split("\n");

    wordSet = new HashSet<>();
    Collections.addAll(wordSet, words);
  }

  public boolean contains(String word) {
    return wordSet.contains(word);
  }
}
