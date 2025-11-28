public class JedliksToyCar {
    private int distanceDriven = 0;
    private int batteryPercentage = 100;
    
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distanceDriven);
    }

    public String batteryDisplay() {
        if (this.batteryPercentage > 0) {
                return String.format("Battery at %d%%", batteryPercentage);
        }
        return "Battery empty";
    }

    public void drive() {
        if ( this.batteryPercentage > 0) {
           this.distanceDriven += 20; 
           this.batteryPercentage -= 1;
        }
    }
}
