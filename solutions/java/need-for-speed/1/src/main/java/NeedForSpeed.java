class NeedForSpeed {
    private int speed          = 0;
    private int distanceDriven = 0;
    private int batteryDrain   = 0;
    private int batteryPercentage = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryPercentage < batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if ( this.batteryPercentage > 0) {
           this.distanceDriven    += this.speed;
           this.batteryPercentage -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
    
    public int getPotentialDistance() {
        // Integer division automatically floors the result, which is what we want.
        // Example: 100% battery / 4% drain = 25 moves.
        int possibleMoves = batteryPercentage / batteryDrain;
        return possibleMoves * speed;
    }
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return car.getPotentialDistance() >= this.distance;
    }
}
