/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficflow;

import java.util.Arrays;

class Lights {
    float time;
    int [] number;
    boolean [] red;
     
    public Lights (int size,float current_time) {
        number = new int [size];
        Arrays.fill(number, 1);
        red = new boolean [size];
        time = current_time;
        setColour(red);
    }    
    
    private void setColour(boolean [] colour) {
        int i;
        for (i = 0; i < colour.length; i++) {
            colour[i] = isRed (time, number[i]);
        }  
    }
    
    private boolean isRed(float t_paso, int t_luz) {
        int res = (int) ((t_paso/t_luz)%2);
        return res == 1;
    }
    
    private void setNewTime(float t) {
        time = t;
    }
    
    public void actualize(float newtime) {
        setNewTime(newtime);
        setColour(red);
    }
    
    public void setLightTime(int n, int val) {
        number[n] = val;
    }
}
    