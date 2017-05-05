package trafficflow;

class Car {
    private int insp;
    
    public Car () {
        insp = 0;
    }
    
    public void setSpeed(int vel) {
        insp = vel;
    }
    
    public int getSpeed() {
        return insp;
    }
    
    public void stop() {
        insp = 0;
    }
    
    public float time(float dist) {
        float t;
        if (insp == 0) {
            return 0;
        }
        else {
            t = dist / insp;
            return t;
        }
    }
}
