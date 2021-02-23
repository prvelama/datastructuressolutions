package main.java.com.companies.assignments.optimusride;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RGBPixelColors {

    public static List<String> closestColor(List<String> pixels) {
        List<String> finalList = new ArrayList<>();
        if (pixels == null || pixels.size() == 0) {
            return Collections.emptyList();
        }
        for (String pixel : pixels) {
            if (pixel.length() != 24) {
                System.out.println("Invalid input.");
                continue;
            }
            List<Integer> colorCodes = new ArrayList<>();
            for (int i = 0; i < pixel.length(); i = i + 8) {
                String splitValue = pixel.substring(i, Math.min(pixel.length(), i + 8));
                int colorCodeValue = convertBinaryStringToInteger(splitValue);
                colorCodes.add(colorCodeValue);
                System.out.println(colorCodeValue);
            }

            int[][] rgbValues = getRgbValues();
            double[] distance = new double[rgbValues.length];
            System.out.println("Distances");
            for(int i = 0; i < rgbValues.length; i++) {
                double sum = 0;
                for(int j = 0; j < rgbValues[i].length; j++) {
                    sum += Math.pow(rgbValues[i][j] - colorCodes.get(j), 2);
                }
                distance[i] = Math.sqrt(sum);
                System.out.println("[" + distance[i] + "]");
            }

            double min = Integer.MAX_VALUE;
            String[] colors = new String[] {"Black", "White", "Red", "Green", "Blue"};
            int minColorIndex = 0;
            for(int i = 0; i < distance.length; i++) {
                if(distance[i] < min){
                    min = distance[i];
                    minColorIndex = i;
                }
            }
            finalList.add(colors[minColorIndex]);
        }
        return finalList;
    }

    private static int[][] getRgbValues() {
        return new int[][] {{0, 0, 0}, {255, 255, 255}, {255, 0, 0}, {0, 255, 0}, {0, 0, 255}};
    }

    private static Integer convertBinaryStringToInteger(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        List<String> result = closestColor(Arrays.asList("000000001111111100000110"));
        result.forEach(System.out::println);
    }
}
