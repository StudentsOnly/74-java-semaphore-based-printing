import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PrintJobSchedulingExercise {

  private List<String> jobs;
  private Semaphore printerSemaphore = new Semaphore(2);

  public PrintJobSchedulingExercise() {
    this.jobs = new ArrayList<>();
    initializeJobs(10);
  }

  private void initializeJobs(int n) {
    for (int i = 0; i < n; i++) {
      jobs.add("Job" + " " + i);
    }
  }

  public void printJob() {
    try {
      printerSemaphore.acquire();
      synchronized (jobs) {
        if (!jobs.isEmpty()) {
          System.out.println("Printing " + jobs.removeFirst());
        }
      }
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    } finally {
      printerSemaphore.release();
    }
  }

  public void printer() {
    try {
      printerSemaphore.acquire();
      System.out.println("Printer is ready");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    } finally {
      printerSemaphore.release();
    }
  }
}
