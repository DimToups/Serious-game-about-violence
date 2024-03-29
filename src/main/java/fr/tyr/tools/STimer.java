package fr.tyr.tools;

import fr.tyr.Main;

import java.util.HashMap;

public class STimer {

    private static final HashMap<Long, Long> timers = new HashMap<>();
    private static long lastId = 0;

    /**
     * Start a timer
     * @return The id of the timer
     */
    public static long start(){
        timers.put(++lastId, System.currentTimeMillis());
        return lastId;
    }

    public static long startNano(){
        timers.put(++lastId, System.nanoTime());
        return lastId;
    }

    /**
     * Stop a timer and return the time in milliseconds
     * @param id The id of the timer
     * @return The time in milliseconds
     */
    public static long stop(long id){
        if(!timers.containsKey(id)){
            Main.getLogger().severe("Timer %d does not exist".formatted(id));
            return -1;
        }
        long time = System.currentTimeMillis() - timers.get(id);
        timers.remove(id);
        return time;
    }

    public static long stopNano(long id){
        if(!timers.containsKey(id)){
            Main.getLogger().severe("Timer %d does not exist".formatted(id));
            return -1;
        }
        long time = System.nanoTime() - timers.get(id);
        timers.remove(id);
        return time;
    }
}
