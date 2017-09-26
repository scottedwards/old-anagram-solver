public class ProgressBar {
  private static double limit;
  private static double difference;

  public ProgressBar(double limit, double difference) {
    this.limit = limit;
    this.difference = difference;
  }

  public static void updateProgress(double x, double total) {
    double percentage = x / total;
    if (percentage >= limit) {
      System.out.print("#");
      limit += difference;
    }
  }
}
