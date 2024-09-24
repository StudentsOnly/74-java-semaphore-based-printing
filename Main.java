import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    PrintJobSchedulingExercise sharedResource = new PrintJobSchedulingExercise();
    List<Thread> threads = new ArrayList<>();

    initializeThreads(threads, sharedResource, 2, 10);
    threads.forEach(Thread::start);
    joinThreads(threads);
  }

  private static void joinThreads(List<Thread> threads) {
    threads.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    });
  }

  private static void initializeThreads(List<Thread> threads,
                                        PrintJobSchedulingExercise sharedResource,
                                        int printers,
                                        int printJobs) {
    for (int i = 0; i < printers; i++) {
      threads.add(new Printer(sharedResource));
    }
    for (int i = 0; i < printJobs; i++) {
      threads.add(new PrintJob(sharedResource));
    }
  }
}
