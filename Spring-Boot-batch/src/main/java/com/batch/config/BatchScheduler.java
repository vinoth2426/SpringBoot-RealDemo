package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BatchScheduler {

	private final JobLauncher jobLauncher;
	private final Job myJob;

	public BatchScheduler(JobLauncher jobLauncher, Job myJob) {
		this.jobLauncher = jobLauncher;
		this.myJob = myJob;
	}
	
	
	@Scheduled(cron = "0 */1 * * * ?") // Runs every 1 minute
    public void scheduleJob() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(myJob, params);
        System.out.println("Job triggered by scheduler 1 mins");
    }

}
