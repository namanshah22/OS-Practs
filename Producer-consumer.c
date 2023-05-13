#include <stdio.h>
#include <stdlib.h>
int semaphore = 1;
int full = 0;
int empty = 5, x = 0;
#define MAX_BUFFER_SIZE 100
#define buffer_size 8
int buffer[buffer_size];    // shared buffer
int in = 0;     // index for next item to be produced
int out = 0;    // index for next item to be consumed
//int buffer_size; 
int temp;  
int item;      // size of buffer
int down(int n)
{
 --n;
 return n;
}
int up(int n)
{
 ++n;
 return n;
}
void produce_item(int temp) {
    printf("enter item");
    scanf("%d",&temp);
    printf("produced item %d\n",temp);  
}

void consume_item(int item) {
    printf("Consumed item %d\n", item);
}
void producer()
{
 produce_item(temp);
 semaphore = down(semaphore);
 empty = down(empty);
 buffer[in]=temp;
 in=(in+1) % buffer_size;
 semaphore=up(semaphore);
 full=up(full);
}
void consumer()
{
 //produce_item(temp);
 full = down(full);
 semaphore = down(semaphore);
 item=buffer[out];
 //buffer[in]=temp;
 out=(out+1) % buffer_size;
 semaphore=up(semaphore);
 empty=up(down);
 consume_item(item);
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
 if ((semaphore == 1) && (empty !=0))
 producer();
 else
 printf("Buffer is Full\nProducer cannot produce more items\n");
 break;
 case 2:
 if ((semaphore == 1) && (full != 0))
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
