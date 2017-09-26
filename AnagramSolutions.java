public class AnagramSolutions {

  private static String[] solutions;
  private static int numberSubmitted;
  private static ProgressBar initialProgressBar;
  private static int totalNumSolutions;

  public AnagramSolutions(int wordLength) {
    int numC = 1;
    //claculate number of possible combinations
    for (int i = 1; i <= wordLength; i++) {
      numC *= i;
    }

    //initialse variables
    numberSubmitted = 0;
    solutions = new String[numC];
    totalNumSolutions = numC;
    initialProgressBar = new ProgressBar(0.04, 0.05);
  }

  public static void submitSolution(String word) {
    solutions[numberSubmitted] = word;
    numberSubmitted += 1;
    //try and get a loading bar...
    initialProgressBar.updateProgress(numberSubmitted, totalNumSolutions);
  }

  public static void printSolutions() {
    //try print them in rows of four
    for (String answer : solutions) {
      SolveAnagram.print("> " + answer);
    }
  }

  public int numOfSolutions() {
    return numberSubmitted;
  }

  public String getWord(int x) {
    return solutions[x];
  }
}
