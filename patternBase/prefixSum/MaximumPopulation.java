package patternBase.prefixSum;

public class MaximumPopulation {

    public int maximumPopulation(int[][] logs) {
        int[] populationChanges = new int[101]; // For years 1950 to 2050

        for (int[] log : logs) {
            int birthYear = log[0];
            int deathYear = log[1];

            populationChanges[birthYear - 1950]++; // Increment for birth year
            populationChanges[deathYear - 1950]--; // Decrement for death year
        }

        int maxPopulation = 0;
        int currentPopulation = 0;
        int yearOfMaxPopulation = 1950;

        for (int i = 0; i < populationChanges.length; i++) {
            currentPopulation += populationChanges[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                yearOfMaxPopulation = i + 1950; // Convert index back to year
            }
        }

        return yearOfMaxPopulation;
    }

    public static void main(String[] args) {
        int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        // Implementation for finding maximum population would go here
        MaximumPopulation calculator = new MaximumPopulation();
        int maxPopulationYear = calculator.maximumPopulation(logs);
        System.out.println("Year with maximum population: " + maxPopulationYear);
    }
}
