#include <stdio.h>
#include <stdlib.h>
int mutex = 1;
int products = 0;
int emptyspace = 5, x = 0;
int Wait(int n)
{
 --n;
 return n;
}
int Signal(int n)
{
 ++n;
 return n;
}
void producer()
{
 mutex = Wait(mutex);
 products = Signal(products);
 emptyspace = Wait(emptyspace);
 x = Signal(x);
 printf("Producer produces item : %d\n",x);
 mutex = Signal(mutex);
}
void consumer()
{
 mutex = Wait(mutex);
 products = Wait(products);
 emptyspace = Signal(emptyspace);
 printf("Consumer consumes item : %d\n",x);
 x = Wait(x);
 mutex = Signal(mutex);
}
int main()
{
 int n, i=1;
 printf("\n1. Press 1 for Producer\n2. Press 2 for Consumer\n3. Press 3 for Exit");
 while(i>0)
 {
 printf("\nEnter your choice: ");
 scanf("%d", &n);
 switch (n)
 {
 case 1:
 if ((mutex == 1) && (emptyspace != 0))
 producer();
 else
 printf("Buffer is Full\nProducer cannot produce more items\n");
 break;
 case 2:
 if ((mutex == 1) && (products != 0))
 consumer();
 else
 printf("Buffer is empty\nConsumer not allowed to consume\n");
 break;
 case 3:
 exit(0);
 break;
 }
 }
}
