package it.dorosz.examples;

import java.io.IOException;

public class Calculations {

    public void showResults() throws IOException {
        System.out.println("Arithmetic mean: " + calculateMean(Rate.BUYING.getRate()) );
        System.out.println("Standard deviation: " + calculateDeviation(Rate.SELLING.getRate()));
    }

    private Float calculateMean(String rateType) throws IOException {
        float[] array = new JSONOperations().getBidsOrAsks(rateType);
        float sumOfArrayItems = 0;
        for(float i : array) {
            sumOfArrayItems += i;
        }
        return sumOfArrayItems / array.length;
    }

    private double calculateDeviation(String rateType) throws IOException {
        float mean = calculateMean(rateType);
        float[] array = new JSONOperations().getBidsOrAsks(rateType);
        float partOfDeviation = 0;
            for(float i : array) {
            partOfDeviation += Math.pow(i - mean, 2);
        }
            return Math.sqrt(partOfDeviation / array.length);
        }
}
