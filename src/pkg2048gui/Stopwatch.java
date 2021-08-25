/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * Stopwatch.java
 * Class that stores the methods for the game stopwatch.
 */

package pkg2048gui;

// Imports.
import java.io.IOException;
import org.apache.commons.lang3.time.StopWatch;
import java.util.concurrent.TimeUnit;

public class Stopwatch {

    StopWatch watch = new StopWatch();  // Creates a new stopwatch for the code to run off of.

    // Method that resets then starts the stopwatch.
    public void stopwatchStart() {
        watch.reset();
        watch.start();
    }

    // Method that stops the stopwatch.
    public void stopwatchStop() {
        watch.stop();
    }

    // Method that returns the time in seconds from the stopwatch.
    long stopwatchReturn() throws IOException {
        long seconds = watch.getTime(TimeUnit.SECONDS);
        return seconds;
    }

}
