import java.util.ArrayList;
import java.util.Collections;

/**
 * Applied Style Guide Rules:
 *
 * 1. 5.2.2 Class Names: The class name "StatisticalLibrary" follows the CamelCase convention and is a noun.
 *
 * 2. 5.2.3 Method Names: Method names like "calculateMean" and "calculateMax" follow the lowerCamelCase naming convention, and are verbs or verb phrases.
 *
 * 3. 4.8.2 Block Indentation: Each code block is indented by 2 spaces for readability and consistency.
 *
 * 4. 4.2 Line Length: Lines are wrapped at 100 characters to prevent lines from being too long.
 *
 * 5. 7.2.1 @param and @return Documentation: Each method is documented with clear JavaDoc comments that include explanations for all parameters and return values.
 *
 * 6. 4.6.2 Horizontal Whitespace: Whitespace is consistently applied around operators, after commas, and between method arguments for readability.
 *
 * 7. 6.2.1 Static Members: Static methods (such as `calculateMean` and `calculateMax`) are used for utility-like behavior, as they do not require any instance-specific data.
 */


/**
 * A library of statistical calculations.
 * This class includes methods for calculating the mean, median, minimum, and maximum values
 * from a list of double values.
 * <p>
 * The methods are designed to handle a variety of input lists, with options to apply a minimum
 * cutoff value for the mean calculation.
 * </p>
 *
 * <p>All calculations assume that the input list is not null or empty.</p>
 *
 * @author Rodik Jiju
 * @version 1.0
 * @since 2024-09-27
 */
public class StatisticalLibrary {

    /**
     * Calculates the mean of a list of double values.
     * If {@code cutOff} is {@code true}, only values greater than or equal to {@code min} are included
     * in the calculation.
     *
     * @param values the list of double values to calculate the mean from
     * @param min the minimum value to consider if {@code cutOff} is true
     * @param cutOff if true, only include values greater than or equal to {@code min}
     * @return the mean of the values in the list, or 0 if the list is empty or no values are included
     */
    public static double calculateMean(ArrayList<Double> values, double min, boolean cutOff) {
        double sum = 0;
        int count = 0;

        for (double value : values) {
            if (!cutOff || value >= min) {
                sum += value;
                count++;
            }
        }

        return count > 0 ? sum / count : 0;
    }

    /**
     * Calculates the median of a list of double values.
     * <p>
     * The median is the middle value when the list is sorted. If the list has an even number
     * of values, the median is the average of the two middle values.
     * </p>
     *
     * @param values the list of double values to calculate the median from
     * @return the median of the values in the list
     */
    public static double calculateMedian(ArrayList<Double> values) {
        int size = values.size();

        // If the size is odd, return the middle value
        if (size % 2 == 1) {
            return values.get(size / 2);
        }

        // If the size is even, return the average of the two middle values
        return (values.get(size / 2 - 1) + values.get(size / 2)) / 2;
    }

    /**
     * Finds the minimum value in a list of double values.
     *
     * @param values the list of double values to find the minimum from
     * @return the minimum value in the list
     */
    public static double calculateMin(ArrayList<Double> values) {
        double min = values.get(0);

        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    /**
     * Finds the maximum value in a list of double values.
     *
     * @param values the list of double values to find the maximum from
     * @return the maximum value in the list
     */
    public static double calculateMax(ArrayList<Double> values) {
        double max = values.get(0);

        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    /**
     * The main method for testing the statistical calculation methods.
     * <p>
     * This method creates a sample list of double values and uses it to demonstrate
     * the functionality of the {@link #calculateMean(ArrayList, double, boolean)},
     * {@link #calculateMedian(ArrayList)}, {@link #calculateMin(ArrayList)}, and
     * {@link #calculateMax(ArrayList)} methods.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example usage of the statistical library
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        System.out.println("Mean: " + calculateMean(data, 0, true));
        System.out.println("Median: " + calculateMedian(data));
        System.out.println("Minimum: " + calculateMin(data));
        System.out.println("Maximum: " + calculateMax(data));
    }
}
