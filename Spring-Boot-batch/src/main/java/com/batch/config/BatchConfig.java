package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {

		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}
	
	
	@Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
	
	@Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(myTasklet())
                .build();
    }

    @Bean
    public Tasklet myTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Executing batch step...");
            return null;
        };
    }
	

}
