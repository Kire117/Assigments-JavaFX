package com.example.assignment3javafx;

public class Convertion {


    public static double convertLBtoKG(double lb) {
        return lb / 2.204;
    }

    public static double convertKGtoLB(double kg) {
        return kg * 2.204;
    }

    public static double convertFAHtoCEL(double fah) {
        return (fah - 32) / 1.8;
    }

    public static double convertCELtoFAH(double cel) {
        return (cel * 1.8) + 32;
    }
}
