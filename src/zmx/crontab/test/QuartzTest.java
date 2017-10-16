package zmx.crontab.test;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest implements Job {

	@Override
	//该方法实现需要执行的任务
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Generating report - "
				+ arg0.getJobDetail().getFullName() + ", type ="
				+ arg0.getJobDetail().getJobDataMap().get("type"));
		System.out.println(new Date().toString());
	}
	public static void main(String[] args) {
		try {
			// 创建一个Scheduler
			SchedulerFactory schedFact = new StdSchedulerFactory();
			Scheduler scheduler = schedFact.getScheduler();
			
			// 创建一个JobDetail，指明name，groupname，以及具体的Job类名，
			//该Job负责定义需要执行任务
			JobDetail jobDetail = new JobDetail("myJob", "myJobGroup",QuartzTest.class);
			jobDetail.getJobDataMap().put("type", "FULL");
			// 定义调度触发规则  
           CronTrigger cornTrigger=new CronTrigger("myTrigger","myTriggerGroup");  
			// 执行规则表达式  ：每隔1分钟执行一次
           cornTrigger.setCronExpression("0 0/1 * * * ?");  
			//把作业和触发器注册到任务调度中  
           scheduler.scheduleJob(jobDetail, cornTrigger);  
			             
			// 启动调度  
           scheduler.start();  
  
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 

