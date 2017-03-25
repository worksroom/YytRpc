package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.ProductEvaluateRecord;

import java.util.List;

/**
 * Created by leo on 2016/11/24.
 */
public interface IProductEvaluateRecordDAO {
	int saveProductEvaluateRecord(ProductEvaluateRecord productEvaluateRecord);

	int updateProductEvaluateRecord(ProductEvaluateRecord productEvaluateRecord);

	ProductEvaluateRecord getProductEvaluateRecord(int id);

	int delProductEvaluateRecord(int id);

	/**
	 * 增量查询
	 *
	 * @param goodIds
	 * @param seq
	 * @param num
	 * @return
	 */
	List<ProductEvaluateRecord> findProductEvaluateList(int goodIds, int seq, int num);
}
