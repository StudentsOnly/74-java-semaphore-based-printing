public class PrintJob extends Thread {

  PrintJobSchedulingExercise ex = new PrintJobSchedulingExercise();

  public PrintJob(PrintJobSchedulingExercise ex) {
    this.ex = ex;
  }

  @Override
  public void run() {
    ex.printJob();
  }
}
