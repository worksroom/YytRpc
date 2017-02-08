package com.yyt.print.product.service.impl;

import com.youguu.core.pojo.Response;
import com.yyt.print.product.dao.IMallProductCategoryProDAO;
import com.yyt.print.product.dao.IMallProductCategoryProValueDAO;
import com.yyt.print.product.pojo.CategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryProValue;
import com.yyt.print.product.service.ICategoryProService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/7.
 */
@Service("categoryProService")
public class CategoryProServiceImpl implements ICategoryProService {

    @Resource
    private IMallProductCategoryProDAO mallProductCategoryProDAO;

    @Resource
    private IMallProductCategoryProValueDAO mallProductCategoryProValueDAO;

    @Override
    public List<CategoryPro> findProValueByClassId(int id) {

        List<CategoryPro> list = new ArrayList<>();

        List<MallProductCategoryPro> pros = mallProductCategoryProDAO.findByClass(id);

        if( pros!=null && pros.size()>0){
            List<MallProductCategoryProValue> values =  mallProductCategoryProValueDAO.findByClass(id);
            Map<Integer,List<MallProductCategoryProValue>> map = new HashMap<>();
            for(MallProductCategoryProValue value:values){
                List<MallProductCategoryProValue> l = map.get(value.getClassProId());
                if(l==null){
                    l = new ArrayList<>();
                    map.put(value.getClassProId(),l);
                }
                l.add(value);
            }

            for(MallProductCategoryPro pro:pros){
                CategoryPro cp = new CategoryPro();
                cp.setPro(pro);
                cp.setValues(map.get(pro.getId()));
                list.add(cp);
            }
        }

        return list;
    }

    @Override
    @Transactional
    public int addProAndValues(int classId, MallProductCategoryPro pro, List<MallProductCategoryProValue> values) {

        pro.setClassId(classId);

        int proId = mallProductCategoryProDAO.saveMallProductCategoryPro(pro);

        if(proId > 0 ){
            for(MallProductCategoryProValue value:values){
                value.setClassId(classId);
                value.setClassProId(proId);
            }
            mallProductCategoryProValueDAO.batchSaveMallProductCategoryProValue(values);
        }else{
            throw new RuntimeException("add pro error");
        }
        return 1;
    }


    @Override
    public List<MallProductCategoryPro> findProByClassId(int classId) {
        return mallProductCategoryProDAO.findByClass(classId);
    }

    @Override
    public List<MallProductCategoryProValue> findProValueByProId(int proId) {
        return mallProductCategoryProValueDAO.findByPro(proId);
    }

    @Override
    public int addPro(MallProductCategoryPro pro) {
        return mallProductCategoryProDAO.saveMallProductCategoryPro(pro);
    }

    @Override
    public int addProValue(List<MallProductCategoryProValue> values) {
        return mallProductCategoryProValueDAO.batchSaveMallProductCategoryProValue(values);
    }

    @Override
    public int modifyPro(MallProductCategoryPro pro) {
        return mallProductCategoryProDAO.updateMallProductCategoryPro(pro);
    }

    @Override
    public int modifyProValue(MallProductCategoryProValue value) {
        return mallProductCategoryProValueDAO.updateMallProductCategoryProValue(value);
    }

    @Override
    public Response<String> delPros(List<Integer> list) {
        Response<String> res = new Response<String>();
        res.setCode("0000");
        for(Integer id:list){
            mallProductCategoryProDAO.deleteMallProductCategoryPro(id);
        }
        return res;
    }

    @Override
    public Response<String> delProValues(List<Integer> list) {
        Response<String> res = new Response<String>();
        res.setCode("0000");
        for(Integer id:list){
            mallProductCategoryProValueDAO.deleteMallProductCategoryProValue(id);
        }
        return res;
    }
}
