import java.util.Arrays;
import java.util.Scanner;

public class CSCAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.println("Enter the disk requests:");
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter the initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter the size of the disk: ");
        int size = sc.nextInt();

        int totalDistance = 0;
        Arrays.sort(requests);

        int index = 0;
        while (index < n && requests[index] <= head) {
            index++;
        }

        totalDistance += size - head;
        totalDistance += size - requests[index - 1];
        head = requests[index - 1];

        totalDistance += head;
        totalDistance += size - requests[n - 1];
        head = size;

        for (int i = n - 2; i >= index; i--) {
            int distance = Math.abs(requests[i] - head);
            totalDistance += distance;
            head = requests[i];
        }

        System.out.println("Total head movement: " + totalDistance);

        sc.close();
    }
}
