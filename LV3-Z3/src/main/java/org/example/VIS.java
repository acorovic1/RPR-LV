package org.example;

import java.util.List;

public class VIS {
    public static Double min(List<Double>numbers){
        double min=Double.MAX_VALUE;
        for(Double x:numbers){
            if(x.doubleValue()<min){
                min=x.doubleValue();
            }
        }
        return min;
    }

    public static Double max(List<Double>numbers){
        double max=Double.MIN_VALUE;
        for(Double x:numbers){
            if(x.doubleValue()>max){
                max=x.doubleValue();
            }
        }
        return max;
    }

    public static Double mean(List<Double>numbers){
        double mean=0;
        for(Double x:numbers){
            mean+=x.doubleValue();
            }

        return mean/numbers.size();
    }

    public static Double stdev(List<Double>numbers){
        double mean=VIS.mean(numbers);
        Double standardDeviation=0.0;
        for(Double x:numbers){
            standardDeviation+=Math.pow(x-mean,2);
        }

        return Math.sqrt(standardDeviation/numbers.size());
    }
}
