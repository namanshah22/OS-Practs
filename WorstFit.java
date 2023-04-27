import java.util.Scanner;
class WorstFit
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of memory partitions: ");
int totalMem = sc.nextInt();
int part[] = new int[totalMem];
int i, j;
for(i = 0; i < totalMem; i++)
{
System.out.print("Enter memory in memory partition "+(i+1)+": ");
part[i] = sc.nextInt();
}
System.out.print("\nEnter number of process to be added to main memory: ");
int n = sc.nextInt();
int mem_p[] = new int[n];
for(i = 0; i < n; i++)
{
System.out.print("Enter memory to be assigned to process "+(i+1)+": ");
mem_p[i] = sc.nextInt();
}
int diff = 0, id;
for(i = 0; i < n; i++)
{
id = -1;
for(j = 0; j < part.length; j++)
{
if((mem_p[i] <= part[j]) && (part[j] - mem_p[i] > diff))
{
diff = part[j] - mem_p[i];
id = j;
}
}
if(id != -1)
{
System.out.println("Process "+(i+1)+"\tMemory Allocated\tPartition: "+part[id]);
part[id] = part[id] - mem_p[i];
}
else
System.out.println("Process "+(i+1)+"\tMemory Not Allocated");
diff = 0;
}
}
}
