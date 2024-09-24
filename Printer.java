public class Printer extends Thread {

  PrintJobSchedulingExercise ex = new PrintJobSchedulingExercise();

  public Printer(PrintJobSchedulingExercise ex) {
    this.ex = ex;
  }

  @Override
  public void run() {
    ex.printer();
  }
}
