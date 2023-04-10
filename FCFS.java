import java.util.Scanner;
class FCFS
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int n;
System.out.print("Enter number of processes to be executed: ");
n = sc.nextInt();
int p[] = new int[n]; 
int at[] = new int[n]; 
int bt[] = new int[n]; 
int i, j, min1, min2, min3;
for(i = 0; i < n; i++)
{
p[i] = i+1;
System.out.print("Enter arrival time: ");
at[i] = sc.nextInt();
System.out.print("Enter burst time: ");
bt[i] = sc.nextInt();
}
for(i = 0; i < n; i++)
{
min1 = at[i];
min2 = bt[i];
min3 = p[i];
j = i-1;
while(j >= 0 && at[j] > min1)
{
at[j+1] = at[j];
bt[j+1] = bt[j];
p[j+1] = p[j];
j--;
}
at[j+1] = min1;
bt[j+1] = min2;
p[j+1] = min3;
}
int ct[] = new int[n]; 
int cur_t = 0; 
int st[] = new int[n]; 
for(i = 0; i < n; i++)
{
ct[i] = cur_t + bt[i];
st[i] = cur_t;
cur_t = ct[i];
}
int tat[] = new int[n]; 
int wt[] = new int[n]; 
float sum1 = 0, sum2 = 0; 
System.out.println("\nProcess No.\tA.T\tB.T.\tC.T.\tT.A.T.\tW.T.");
for(i = 0; i < n; i++)
{
tat[i] = ct[i] - at[i];
wt[i] = tat[i] - bt[i];
System.out.println("Process "+p[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
sum1 += tat[i];
sum2 += wt[i];
}
System.out.println("Average Turn Around Time: "+(sum1/n));
System.out.println("Average Waiting Time: "+(sum2/n));
System.out.println("\n\t\tGANTT CHART\nPROCESS \tStart Time\tCompletion Time");
for(i = 0; i < n; i++)
{
System.out.println("PROCESS "+p[i]+"\t\t"+st[i]+"\t\t"+ct[i]);
}
}
}
