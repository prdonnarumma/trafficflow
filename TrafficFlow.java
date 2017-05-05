package trafficflow;

import java.util.Arrays;
import java.util.Scanner;

public class TrafficFlow {
//boolean contains = IntStream.of(this.possible).anyMatch(x -> x == vel);
    //int [] possible = {5,10,15,20,25,30};
    public static void main(String[] args) {
        Car car = new Car();
        Integer [] sp_possible = {5,10,15,20,25,30};
        int size,val,val2; final int lightdist = 150; float time=0;
        Lights light;
        Scanner read= new Scanner(System.in);
        boolean dummy=true;
        
        System.out.print("How many traffic lights are there?\n");
        
        do {
            size = read.nextInt();
            if (size>50) {System.out.println("There can't be more than 50"
                    + " traffic lights!\n");}
        }while (size>50);
        
        light = new Lights(size,time);
        
        System.out.println("And how much time for each until signal change?"
                + " (possible values are in the range of 10-60)\n");
        for (int i=0; i<size; i++) {
            while (dummy) {
                val = read.nextInt();
                if (val>=10 || val<=60) {
                    light.setLightTime(i, val);
                    break;
                }
                else {System.out.println("You didn't input a valid number."
                        + " Valid numbers are in the range of 10-60\n");}
            }   
        }
        
        System.out.println("What is the car's speed? (5-10-15-20-25-30)\n");
        while (dummy) {
            val2 = read.nextInt();
            if (Arrays.asList(sp_possible).contains(val2)) {
                car.setSpeed(val2);
                break;
            }
            
            else {System.out.println("You didn't input a valid number. Valid"
                    + " numbers are 5-10-15-20-25-30\n");}
            
        }
        time += car.time(lightdist);
        System.out.println(time);
        for (int i=0; i<light.number.length; i++) {
            light.actualize(time);
            if (light.red[i]) {
                time += (light.number[i]-time%light.number[i]);
                System.out.println(time);
            }
            time += car.time(lightdist);
            System.out.println(time);
        }
        
        System.out.printf("\nAt a speed of %d m/s and with %d traffic lights,the"
                + " car takes %d seconds to get to the end of the street\n"
                ,car.getSpeed(),light.number.length,(int)time);
    }
}
