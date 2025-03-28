package week3_chapter24;

public class Task01 {
	public static void main(String[] args) {
        try {
            Thread.sleep(2000);
            System.out.println("Thread slept for 2 seconds");
        } catch (InterruptedException e) {
            // Handle the InterruptedException
            System.err.println("Thread was interrupted: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
