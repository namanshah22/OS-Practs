import java.util.Arrays;
import java.util.Scanner;

public class LOOK {
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

        System.out.print("Enter the direction (1 for up, -1 for down): ");
        int direction = sc.nextInt();

        Arrays.sort(requests);

        int index = Arrays.binarySearch(requests, head);
        if (index < 0) {
            index = -(index + 1);
        }

        int totalDistance = 0;

        if (direction == 1) {
            for (int i = index; i < n; i++) {
                int distance = Math.abs(requests[i] - head);
                totalDistance += distance;
                head = requests[i];
            }

            for (int i = index - 1; i >= 0; i--) {
                int distance = Math.abs(requests[i] - head);
                totalDistance += distance;
                head = requests[i];
            }
        } else {
            for (int i = index - 1; i >= 0; i--) {
                int distance = Math.abs(requests[i] - head);
                totalDistance += distance;
                head = requests[i];
            }

            for (int i = index; i < n; i++) {
                int distance = Math.abs(requests[i] - head);
                totalDistance += distance;
                head = requests[i];
            }
        }

        System.out.println("Total head movement: " + totalDistance);

        sc.close();
    }
}

