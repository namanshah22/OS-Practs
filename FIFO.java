import java.util.Scanner;
class FIFO
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int num, n, i;
System.out.print("Enter no of frames in main memory: ");
num = sc.nextInt();
int frame[] = new int[num];
for(i = 0; i < num; i++)
 frame[i] = -1;
System.out.print("Enter no of pages to be executed: ");
n = sc.nextInt();
int page_stream[] = new int[n];
System.out.println("Enter page stream:");
for(i = 0; i < n; i++)
page_stream[i] = sc.nextInt();
char check = 'F';
int j = 0, k, count1 = 0, count2 = 0;
System.out.println("\nPage Stream");
for(i = 0; i < n; i++)
{
 for(k = 0; k < num; k++)
{
 if(frame[k] == page_stream[i])
 {
 check = 'H';
 count2++;
 }
}
if(j < num && check != 'H')
{
frame[j] = page_stream[i];
j++;
count1++;
}
else if(j >= num && check != 'H')
{
 j = 0;
 frame[j] = page_stream[i];
 j++;
 count1++;
}
System.out.print(page_stream[i]+"\t\t\t");
for(k = 0; k < num; k++)
{
 if(frame[k] != -1)
 System.out.print(frame[k]+"\t");
else
 System.out.print("\t");
}
System.out.println(check);
check = 'F';
}
float hit_ratio, miss_ratio;
hit_ratio = (float)(count2)/(float)(n);
miss_ratio = (float)(count1)/(float)(n);
System.out.println("\n\nNo. of page hits = "+count2);
System.out.println("No. of page faults = "+count1);
System.out.println("Hit ratio = "+hit_ratio);
System.out.println("Miss ratio = "+miss_ratio);
}
}
