package unit13.practice;

public class Printer implements Runnable {
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < message.length(); i++) {
            System.out.println(message.charAt(i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Printer("Test"));
        thread.start();
    }
}
