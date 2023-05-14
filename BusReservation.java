public class BusReservation extends Thread 
{
    int vacant=2,required;
    BusReservation(int r)
    {
        required= r;
    }
    public synchronized void run()
    {
        System.out.println("Welcome "+Thread.currentThread().getName()+"!");
        System.out.println("No. of seats left: "+vacant);
        if(required<= vacant)
        {
            System.out.println(required+" tickets have been booked");
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e){

            }
            vacant-= required;
        }
        else
        {
            System.out.println("All tickets booked");
        }
    }
}
class Main
{
    public static void main(String args[])
    {
        BusReservation br=new BusReservation(2);
        Thread t1=new Thread(br);
        Thread t2=new Thread(br);
        t1.setName("naman");
        t2.setName("kamlesh");
        t1.start();
        t2.start();
    }
}
