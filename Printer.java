public class Printer extends Thread {
    private String printerName;

    public Printer(String printerName) {
        this.printerName = printerName;
    }

    @Override
    public void run() {
        System.out.println(printerName + " is ready.");
        while (true) { // printer is always ready
           try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
