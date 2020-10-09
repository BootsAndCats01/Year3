package FirstTerm.Week2;

public class Process implements Comparable<Process> {

    private int id;
    private int burstTime;
    private int arrivalTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Process(int id, int burstTime, int arrivalTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Process process) {
        int arrivalTime1 = this.arrivalTime;
        int arrivalTime2 = process.arrivalTime;

        if (arrivalTime1 == arrivalTime2) {
            return 0;
        } else if (arrivalTime1 > arrivalTime2) {
            return 1;
        } else {
            return -1;
        }
    }
}
