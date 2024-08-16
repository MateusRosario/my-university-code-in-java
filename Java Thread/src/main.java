import java.lang.Thread;

// Java code for thread creation by extending
// the Thread class
class MultithreadingDemo extends Thread
{
    private int id;

    public MultithreadingDemo(int id){
        this.id = id;
    }

    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    this.id +
                    " start to running.");

            System.out.println("Thread " + this.id + " will sleep for 5 seconds.");

            Thread.sleep(5000);

            System.out.println("Thread " + this.id + " finished.");
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

// Main Class
public class main{

    public static void main(String[] args)
    {
        int n = 100; // Number of threads
        for (int i=0; i<n; i++)
        {
            MultithreadingDemo object = new MultithreadingDemo(i);
            object.start();
        }
    }
}