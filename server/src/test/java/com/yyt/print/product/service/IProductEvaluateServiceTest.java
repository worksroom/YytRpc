package com.yyt.print.product.service;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.ProductEvaluateRecord;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/22.
 */
public class IProductEvaluateServiceTest extends BaseTestClass {
	IProductEvaluateService service = getBean(IProductEvaluateService.class);

	@Test
	public void testRate() {
		int buyerId = 1;
		int sellerId = 2;
		String orderId = "25";
		int goodsId = 1;
		int score = 4;
		String content = "哈哈";
		String imgs = "111";
		int anonymous = 1;

		int result = service.rate(buyerId, sellerId, orderId, goodsId, score, content, imgs, anonymous);
		System.out.println(result);
	}

	@Test
	public void findProductEvaluateList() {
		System.out.println(service.findProductEvaluateList(1, 0, 10));
	}
}
