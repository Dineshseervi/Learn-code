package main.java.thread.example.executer;

import java.util.Date;
import java.util.concurrent.*;
/*import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;*/
public class SchedulerService {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService=Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new SchedulerWorkerRunnable(),0,3,TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(15);// in application this can be replace with destroy method of bean
        System.out.println("-------time over -------");
        executorService.shutdown();
    }
}


    class SchedulerWorkerRunnable implements Runnable
{
    public void execute()
    {
        System.out.println("how are u");

    }

    @Override
    public void run() {
        System.out.println("Start");
        this.execute();
        System.out.println("end");
    }
}