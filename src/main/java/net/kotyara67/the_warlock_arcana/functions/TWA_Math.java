package net.kotyara67.the_warlock_arcana.functions;

public class TWA_Math {

    public static double randomDoubleInRange(double min, double max){
        double rand = (Math.random()*((max-min)+1))+min;
        return rand;
    }

}
