package FirstTerm.Week2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scheduler {
    private List<Process> processes;

    private float averageWaitTime = 0;
    private float averageTurnAroundTime = 0;

    public Scheduler() {
        processes = new ArrayList<>();
    }

    public void addProcess(Process process) {
        this.processes.add(process);
    }

    private void computeCompletionTime() {
        for (int i = 0; i < processes.size(); i++) {
            Process temp = processes.get(i);
            if (i == 0) {
                temp.setCompletionTime(temp.getArrivalTime() + temp.getBurstTime());
            } else {
                Process temp2 = processes.get(i - 1);
                // There is not waiting time
                if (temp.getArrivalTime() > temp2.getCompletionTime()) {
                    temp.setCompletionTime(temp.getArrivalTime() + temp.getBurstTime());
                } else {
                    // If there's waiting time we gonna finish process at completion time of previous process
                    temp.setCompletionTime(temp2.getCompletionTime() + temp.getBurstTime());
                }
            }
            temp.setTurnAroundTime(temp.getCompletionTime() - temp.getArrivalTime());
            temp.setWaitingTime(temp.getTurnAroundTime() - temp.getBurstTime());
            averageWaitTime += temp.getWaitingTime();
            averageTurnAroundTime += temp.getTurnAroundTime();
        }
    }

    public void printSchedulingResults() {
        processes.sort(Comparator.naturalOrder());
        computeCompletionTime();
        System.out.println("\npid | arrival | burst | complete | turn around | waiting");
        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);
            System.out.println(process.getId() + " \t\t " +
                    process.getArrivalTime() + " \t\t" +
                    process.getBurstTime() + " \t\t\t" +
                    process.getCompletionTime() + " \t\t\t" +
                    process.getTurnAroundTime() + " \t\t\t" +
                    process.getWaitingTime());
        }
        System.out.println("\nAverage Wait time: " + (averageWaitTime / processes.size()));
        System.out.println("\nAverage turn around time: " + (averageTurnAroundTime / processes.size()));
    }
}
