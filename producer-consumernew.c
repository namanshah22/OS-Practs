#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

#define n 10

int buffer[n];
int in = 0;
int out = 0;
sem_t empty, full, s;

void produce_item(int *temp) {
    printf("enter item");
    scanf("%d",&temp);
}

void process_item(int item) {
    printf("Consumed item: %d\n", item);
}

void down(sem_t *sem) {
    sem_wait(sem);
}

void up(sem_t *sem) {
    sem_post(sem);
}

void producer() {
    int temp;
    while (1) {
        produce_item(&temp);
        
        down(&empty);
        down(&s);
        buffer[in] = temp;
        in = (in + 1) % n;
        up(&s);
        up(&full);
    }
}

void consumer() {
    int item;
    while (1) {
        if(full == 0)
        {
            printf("buffer empty");
            break;
        }
        down(&full);
        down(&s);
        item = buffer[out];
        out = (out + 1) % n;
        up(&s);
        up(&empty);
        process_item(item);
    }
}

int main() {
    //pthread_t producer_thread, consumer_thread;

    sem_init(&empty, 0, n);
    sem_init(&full, 0, 0);
    sem_init(&s, 0, 1);
   int n, i=1;
 printf("\n1. Press 1 for Producer\n2. Press 2 for Consumer\n3. Press 3 for Exit");
 while(i>0)
 {
 printf("\nEnter your choice: ");
 scanf("%d", &n);
 switch (n)
 {
 case 1:
 if (full!=n)
 producer();
 else
 printf("Buffer is Full\nProducer cannot produce more items\n");
 break;
 case 2:
 if (empty!=0)
 consumer();
 else
 printf("Buffer is empty\nConsumer not allowed to consume\n");
 break;
 case 3:
 exit(0);
 break;
 }
 }
    //pthread_create(&producer_thread, NULL, producer, NULL);
    //pthread_create(&consumer_thread, NULL, consumer, NULL);

    //pthread_join(producer_thread, NULL);
    //pthread_join(consumer_thread, NULL);

    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&s);

    return 0;
}
