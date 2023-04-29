import java.util.Scanner;

public class Optimal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num, n, i;
        System.out.print("Enter no of frames in main memory: ");
        num = sc.nextInt();
        int frame[] = new int[num];
        for (i = 0; i < num; i++)
            frame[i] = -1;
        System.out.print("Enter no of pages to be executed: ");
        n = sc.nextInt();
        int page_stream[] = new int[n];
        System.out.println("Enter page stream:");
        for (i = 0; i < n; i++)
            page_stream[i] = sc.nextInt();
        int count1 = 0, count2 = 0;
        System.out.println("\nPage Stream");
        for (i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < num; j++) {
                if (frame[j] == page_stream[i]) {
                    flag = true;
                    count2++;
                    break;
                }
            }
            if (!flag) {
                int index = -1, farthest = 0;
                for (int j = 0; j < num; j++) {
                    int nextOccurrence = -1;
                    for (int k = i + 1; k < n; k++) {
                        if (frame[j] == page_stream[k]) {
                            nextOccurrence = k;
                            break;
                        }
                    }
                    if (nextOccurrence == -1) {
                        index = j;
                        break;
                    }
                    if (nextOccurrence > farthest) {
                        farthest = nextOccurrence;
                        index = j;
                    }
                }
                frame[index] = page_stream[i];
                count1++;
            }
            System.out.print(page_stream[i] + "\t\t\t");
            for (int j = 0; j < num; j++) {
                if (frame[j] != -1)
                    System.out.print(frame[j] + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println(flag ? "H" : "F");
        }
        float hit_ratio, miss_ratio;
        hit_ratio = (float) (count2) / (float) (n);
        miss_ratio = (float) (count1) / (float) (n);
        System.out.println("\n\nNo. of page hits = " + count2);
        System.out.println("No. of page faults = " + count1);
        System.out.println("Hit ratio = " + hit_ratio);
        System.out.println("Miss ratio = " + miss_ratio);
    }
}
