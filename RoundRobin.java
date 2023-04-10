import java.util.Scanner;
class Queue 
{ 
Node front, rear; 
int queueSize; 
class Node
{ 
int data; 
Node next; 
} 
Queue() 
{ 
front = null; 
rear = null; 
queueSize = 0; 
} 
boolean isEmpty() 
{ 
return (queueSize == 0); 
}
int dequeue() 
{ 
int data = front.data; 
front = front.next; 
if (isEmpty()) 
{ 
rear = null; 
}
queueSize--; 
return data; 
} 
void enqueue(int data) 
{ 
Node oldRear = rear; 
rear = new Node(); 
rear.data = data; 
rear.next = null; 
if (isEmpty()) 
{ 
front = rear; 
} 
else
{ 
oldRear.next = rear; 
} 
queueSize++; 
} 
}
class RoundRobin
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int n, tq;
System.out.print("Enter number of processes: ");
n = sc.nextInt();
System.out.print("Enter time quantum: ");
tq = sc.nextInt();
Queue q = new Queue();
int p[] = new int[n]; 
int at[] = new int[n]; 
int bt[] = new int[n]; 
int flag[] = new int[n]; 
int f[] = new int[n]; 
int i, j, min1, min2, min3;
int cur_t = 0; 
int st[] = new int[n]; 
int ct[] = new int[n];
int tot = 0; 
int c = 0; 
int b[] = new int[n]; 
for(i = 0; i < n; i++)
{
p[i] = i+1;
System.out.print("Enter arrival time: ");
at[i] = sc.nextInt();
System.out.print("Enter burst time: ");
bt[i] = sc.nextInt();
flag[i] = 0;
f[i] = 0;
st[i] = -1;
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
for(i = 0; i < n; i++)
b[i] = bt[i];
while(tot < n)
{
for(i = 0; i < n; i++)
{
if((f[i] == 0) && (flag[i] == 0) && (at[i] <= cur_t))
{
q.enqueue(i);
f[i] = 1;
}
}
c = q.dequeue();
if(st[c] == -1)
st[c] = cur_t;
ct[c] = cur_t;
if(b[c] > tq)
{
ct[c] += tq;
b[c] -= tq;
cur_t += tq;
for(i = 0; i < n; i++)
{
if((f[i] == 0) && (flag[i] == 0) && (at[i] <= cur_t))
{
q.enqueue(i);
f[i] = 1;
}
}
if(b[c] > 0)
q.enqueue(c);
}
else if(b[c] <= tq)
{
ct[c] += b[c];
cur_t += b[c];
b[c] = 0;
for(i = 0; i < n; i++)
{
if((f[i] == 0) && (flag[i] == 0) && (at[i] <= cur_t))
{
q.enqueue(i);
f[i] = 1;
}
}
}
if(b[c] == 0)
{
flag[c] = 1;
tot++;
}
}
int tat = 0; //Turnaround Time
int wt = 0; //Waiting Time array
float sum1 = 0, sum2 = 0; //sum1 for tat and sum2 for wt
System.out.println("\nProcess No.\tA.T\tB.T.\tC.T.\tT.A.T.\tW.T.");
for(i = 0; i < n; i++)
{
tat = ct[i] - at[i];
wt = tat - bt[i];
System.out.println("Process "+p[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat+"\t"+wt);
sum1 += tat;
sum2 += wt;
}
System.out.println("Average Turn Around Time: "+(sum1/n));
System.out.println("Average Waiting Time: "+(sum2/n));
for(i = 0; i < n; i++)
{
min1 = st[i];
min2 = ct[i];
min3 = p[i];
j = i-1;
while(j >= 0 && st[j] > min1)
{
st[j+1] = st[j];
ct[j+1] = ct[j];
p[j+1] = p[j];
j--;
}
st[j+1] = min1;
ct[j+1] = min2;
p[j+1] = min3;
}
System.out.println("\n\t\tGANTT CHART\nPROCESS \tStart Time\tCompletion Time");
for(i = 0; i < n; i++)
{
System.out.println("PROCESS "+p[i]+"\t\t"+st[i]+"\t\t"+ct[i]);
}
}
}

