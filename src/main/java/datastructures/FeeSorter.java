package datastructures;

public class FeeSorter {

    // Custom Selection Sort written without built-in sorting utilities
    public static void sortByFeeDescending(double[] fees, String[] plates, int count) {
        for (int i = 0; i < count - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (fees[j] > fees[maxIdx]) {
                    maxIdx = j;
                }
            }
            double tempFee = fees[maxIdx];
            fees[maxIdx] = fees[i];
            fees[i] = tempFee;

            String tempPlate = plates[maxIdx];
            plates[maxIdx] = plates[i];
            plates[i] = tempPlate;
        }
    }
}