package fr.tyr.tools;

import com.google.common.collect.EvictingQueue;
import fr.tyr.Main;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unused")
public class Runner extends Thread{

    private final String name;
    private final Runnable action;
    private double aps;
    private final boolean stability;

    private boolean running = false;
    private boolean paused = false;
    private int passedActions = 0;
    private Queue<Long> apsQueue;
    private final ReentrantLock queueLock = new ReentrantLock();

    /**
     * Create a new Runner
     * @param action The action to run
     */
    public Runner(@NotNull final String name, @NotNull final Runnable action){
        this(name, action, 60, true);
    }

    /**
     * Create a new Runner
     * @param action The action to run
     * @param aps The number of actions per second
     * @param stabilized If the runner should be stable
     */
    public Runner(@NotNull final String name, @NotNull final Runnable action, @Range(from = 0, to=10000) final int aps, final boolean stabilized){
        this.name = name;
        this.action = action;
        this.aps = 1D / aps;
        this.stability = stabilized;
        this.apsQueue = EvictingQueue.create(aps);
    }

    /**
     * The main loop of the runner
     */
    @Override
    public void run() {
        Main.getLogger().info("Runner " + this.name + " started");
        this.running = true;
        long nextAction = (long) (System.nanoTime() + this.aps * 1_000_000_000L);
        long start = System.nanoTime();
        while (running){
            if(!paused){
                if(System.nanoTime() >= nextAction){
                    if(this.stability)
                        nextAction = (long) (nextAction + this.aps * 1_000_000_000L);
                    else
                        nextAction = (long) (System.nanoTime() + this.aps * 1_000_000_000L);
                    try{
                        this.action.run();
                    }catch (Exception e){
                        Main.getLogger().severe(e.getMessage());
                    }
                    this.passedActions++;
                    long end = System.nanoTime();
                    this.queueLock.lock();
                    try {
                        this.apsQueue.add(end - start);
                    }catch(Exception e){
                        Main.getLogger().severe(e.getMessage());
                    }finally {
                        this.queueLock.unlock();
                    }
                    start = System.nanoTime();
                }
            }
            Thread.yield();
        }
        this.queueLock.lock();
        try {
            this.apsQueue.clear();
        }catch(Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            this.queueLock.unlock();
        }
    }

    /**
     * Compute the average of the queue
     * @return The average of the queue
     */
    private double computeAverage() {
        long sum = 0;
        int count = this.apsQueue.size();
        this.queueLock.lock();
        try{
            for (long element : this.apsQueue)
                sum += element;
        }catch(Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            this.queueLock.unlock();
        }
        if (count > 0)
            return (double) sum / count;
        else
            return -1_000_000_000;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
    public void stopRunner(){
        this.running = false;
    }
    public void setAps(int aps){
        this.aps = 1D / aps;
        this.queueLock.lock();
        try {
            this.apsQueue = EvictingQueue.create(aps);
        }catch(Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            this.queueLock.unlock();
        }
    }

    public boolean isRunning() {
        return running;
    }
    public int getPassedActions() {
        return passedActions;
    }
    public int getCurrentAps() {
        return (int) (1D / (computeAverage() / 1_000_000_000D));
    }
    public int getAps() {
        return (int) (1D / this.aps);
    }
}
