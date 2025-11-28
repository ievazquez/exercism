
class BirdWatcher {
    private final int[] birdsPerDay;
    private int currentDayIndex;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.currentDayIndex = this.birdsPerDay.length - 1;
    }

    public int[] getLastWeek() {
        return this.birdsPerDay.clone();
    }

    public int getToday() {
        return this.birdsPerDay[this.currentDayIndex];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.currentDayIndex]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay){
            if (birds == 0 ) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int totalCount = 0;
        int limit  = Math.min(numberOfDays, this.birdsPerDay.length);
        for ( int i = 0; i < limit; i++) {
            totalCount += birdsPerDay[i];
        }
        return totalCount;
    }

    public int getBusyDays() {
        int totalBusyDays = 0;
        for ( int i = 0; i < this.birdsPerDay.length; i++) {
            if (birdsPerDay[i] >= 5){
                totalBusyDays ++;
            }
        }
        return totalBusyDays;
    }
}
