package aula20201116;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class JobProducer extends Thread {

    private final JobQueue jobs;
    private AtomicBoolean isRunning = new AtomicBoolean(true);

    public JobProducer(JobQueue jobs) {
        this.jobs = jobs;
    }

    @Override
    public void run() {
            try {
                System.out.println("Adicionando atividade, " + this );
                this.jobs.queueJob(1);
            } catch (Exception e) {
                System.out.println("Thread interrupted, " + this);
            }
        System.out.println("Stopping thread, " + this);
        this.interrupt();
    }

}
