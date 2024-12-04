import java.util.Scanner;

public class Average {
    // Attributes
    int[] data; // Array to store the scores
    double mean; // Arithmetic mean of the scores

    // Constructor
    public Average() {
        data = new int[5]; // Allocate memory for 5 scores
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter 5 scores
        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter score number " + (i + 1) + ": ");
            data[i] = scanner.nextInt();
        }

        // Call methods to calculate mean and sort the array
        selectionSort();
        calculateMean();
    }

    // Method to calculate the mean of the array
    public void calculateMean() {
        int sum = 0;
        for (int score : data) {
            sum += score; // Add each score to the total sum
        }
        mean = (double) sum / data.length; // Calculate mean
    }

    // Method to sort the array in descending order using selection sort
    public void selectionSort() {
        for (int i = 0; i < data.length - 1; i++) {
            int maxIndex = i;

            // Find the index of the maximum element
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the maximum element with the current element
            int temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;
        }
    }

    // toString method to display the array and the mean
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Data in descending order: ");
        for (int score : data) {
            result.append(score).append(" ");
        }
        result.append("\nMean: ").append(mean);
        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        Average average = new Average(); // Create an Average object
        System.out.println(average); // Display the sorted data and mean
    }
}
