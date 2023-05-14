import java.util.Scanner;

class rrnew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
        int quantum;
        System.out.print("Enter the time quantum: ");
        quantum = sc.nextInt();
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] remainingTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];
        //int[] st=new int[n];
        boolean[] finished = new boolean[n];
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the arrival time for process " + (i + 1) + ": ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("Enter the burst time for process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
            totalTime += burstTime[i];
        }
        int currentTime = 0;
        float sum1 = 0, sum2 = 0;
        while (currentTime < totalTime) {
            for (int i = 0; i < n; i++) {
                if (!finished[i] && arrivalTime[i] <= currentTime) {
                    int timeSlice = Math.min(quantum, remainingTime[i]);
                    currentTime += timeSlice;
                    remainingTime[i] -= timeSlice;
                    //st[i]=currentTime;
                    if (remainingTime[i] == 0) {
                        finished[i] = true;
                       // st[i]=currentTime;
                        completionTime[i] = currentTime;
                        turnaroundTime[i] = completionTime[i] - arrivalTime[i];
                        waitingTime[i] = turnaroundTime[i] - burstTime[i];
                        sum1 +=turnaroundTime[i];
                        sum2 +=waitingTime[i];
                    }
                    /*else {
                        if (remainingTime[i] == burstTime[i]) {
                            st[i] = currentTime - timeSlice;
                        }
                    }*/
                }
            }
        }
        System.out.println("Average Turn Around Time: "+(sum1/n));
        System.out.println("Average Waiting Time: "+(sum2/n));
        System.out.println("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + completionTime[i]
                    + "\t\t\t" + turnaroundTime[i] + "\t\t\t" + waitingTime[i]);
        }
        /*System.out.println("\n\t\tGANTT CHART\nPROCESS \tStart Time\tCompletion Time");
        for (int i = 0; i < n; i++) {
            System.out.println("PROCESS "+(i+1)+"\t\t"+st[i]+"\t\t"+completionTime[i]);
        }*/
    }
}
