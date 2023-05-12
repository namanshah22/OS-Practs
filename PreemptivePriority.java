import java.util.Scanner;
import java.util.*;

class PreemptivePriority {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of processes to be executed: ");
        n = sc.nextInt();
        int p[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int pt[] = new int[n];
        //int rt[] = new int[n]; // remaining time
        int i;
        for(i = 0; i < n; i++) {
            p[i] = i+1;
            System.out.print("Enter arrival time: ");
            at[i] = sc.nextInt();
            System.out.print("Enter burst time: ");
            bt[i] = sc.nextInt();
            System.out.print("Enter priority: ");
            pt[i] = sc.nextInt();
            //rt[i] = bt[i];
        }
        int ct[] = new int[n];
        int cur_t = 0;
        int st[] = new int[n];
        boolean done[] = new boolean[n];
        int min_pt, min_idx;
        int remaining = n;
        while(remaining > 0) {
            min_pt = Integer.MAX_VALUE;
            min_idx = -1;
            for(i = 0; i < n; i++) {
                if(!done[i] && at[i] <= cur_t && pt[i] < min_pt) {
                    min_pt = pt[i];
                    min_idx = i;
                }
            }
            if(min_idx == -1) {
                cur_t++;
            } else {
                if(bt[min_idx] > 1) {
                    bt[min_idx]--;
                }
                else {
                    ct[min_idx] = cur_t + 1;
                    done[min_idx] = true;
                    remaining--;
                }
                st[min_idx] = cur_t;
                cur_t++;
            }
        }
        int tat[] = new int[n];
        int wt[] = new int[n];
        float sum1 = 0, sum2 = 0;
        System.out.println("\nProcess No.\tA.T\tB.T.\tC.T.\tT.A.T.\tW.T.");
        for(i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            System.out.println("Process "+p[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
            sum1 += tat[i];
            sum2 += wt[i];
        }
        System.out.println("Average Turn Around Time: "+(sum1/n));
        System.out.println("Average Waiting Time: "+(sum2/n));
        System.out.println("\n\t\tGANTT CHART\nPROCESS \tStart Time\tCompletion Time");
        for(i = 0; i < n; i++) {
            System.out.println("PROCESS "+p[i]+"\t\t"+st[i]+"\t\t"+ct[i]);
        }
    }
}

