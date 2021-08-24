/*
* Danish Wasif, Evan Woo, Michael Xie, Justin Ye
* August 24, 2021
* ICS4UE-20
* Class that stores the methods of the stopwatch method. More information can be found in https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/time/StopWatch.html
 */
package pkg2048gui;
import java.io.IOException;
import org.apache.commons.lang3.time.StopWatch;
import java.util.concurrent.TimeUnit;


public class stopwatch {
StopWatch watch = new StopWatch();//Creates the stopwatch
    
    //Method used to reset the stopwatch and start it.
    public void stopwatchStart(){
        watch.reset();
        watch.start();
    }
    //Stops the stop watch.
    public void stopwatchStop(){
        watch.stop();
    }
    
    //Returns the time on the stopwatch
    long stopwatchReturn() throws IOException{
        long seconds = watch.getTime(TimeUnit.SECONDS); 
        return seconds;
    }

}
