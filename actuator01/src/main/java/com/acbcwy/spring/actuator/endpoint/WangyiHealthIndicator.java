package com.acbcwy.spring.actuator.endpoint;

import java.util.Date;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class WangyiHealthIndicator  extends AbstractHealthIndicator {
	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		try{
			if(isCheck()){
				builder.up().withDetail("MyStatus", "All is ok!");
			}else{
				builder.down().withDetail("MyStatus", "Time is error!");
			}
		}catch(Exception ex){
			builder.down().withException(ex);
		}
		
	}
	
	private boolean isCheck(){
		Date date=new Date();
	    int mod= date.getMinutes() % 5;
		return mod!=0;
	}
	

}
