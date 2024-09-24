import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PrintJobScheduler {
    // Shared list of print jobs
    private static List<PrintJob> printJobs = new ArrayList<>();
    private static int numberOfPrinters = 2;

    private static Semaphore printerSemaphore;

    public static void main(String[] args) {
        printerSemaphore = new Semaphore(numberOfPrinters);

        for (int i = 1; i <= 10; i++) {
            PrintJob printJob = new PrintJob("Job " + i, printerSemaphore);
            printJobs.add(printJob);
        }

        // Create and start PrintJob threads
        for (PrintJob printJob : printJobs) {
            printJob.start();
        }

        // Create and start Printer threads
        for (int i = 1; i <= numberOfPrinters; i++) {
            Printer printer = new Printer("Printer " + i);
            printer.start();
        }

        for (PrintJob printJob : printJobs) {
            try {
                printJob.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All jobs printed successfully");
    }
}
