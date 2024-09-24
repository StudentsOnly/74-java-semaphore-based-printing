import java.util.concurrent.Semaphore;

public class PrintJob extends Thread {
    private String jobName;
    private Semaphore printerSemaphore;


    public PrintJob(String jobName, Semaphore printerSemaphore) {
        this.jobName = jobName;
        this.printerSemaphore = printerSemaphore;
    }

    @Override
    public void run() {
        try {
           System.out.println(jobName + " is waiting to be printed.");
            // Acquire a printer resource
            printerSemaphore.acquire();
            System.out.println(jobName + " is being printed.");
            // Simulate the time taken to print
            Thread.sleep(2000); // Simulates printing time
            System.out.println(jobName + " has been printed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Release the printer resource
            printerSemaphore.release();
        }
    }
}
