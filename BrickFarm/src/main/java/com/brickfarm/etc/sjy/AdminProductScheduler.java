package com.brickfarm.etc.sjy;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.brickfarm.service.admin.product.ProductManagingService;

@Component
public class AdminProductScheduler {
	@Inject
	private ProductManagingService pmService;

	@Scheduled(cron = "0 0 0 * * *")
	public void producstScheduler() throws Exception {
		pmService.confirmOrder();
		pmService.confirmReceiving();
		pmService.confirmCarryingOut();
		pmService.eventEnd();
		pmService.autoOrder(); 
		pmService.updateEventScheduler();
	}

	@Scheduled(cron = "0/10 * * * * *")
	public void test() throws Exception {
		System.out.println("@Scheduled annotation : 10초에 1번씩 console 찍기");
	}

}
