package com.yyt.print.info.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.fragment.pojo.FragmentHome;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IFragmentHomeService {

    public int saveFragmentHome(FragmentHome fragmentHome);

    public int updateFragmentHome(FragmentHome fragmentHome);

    public int deleteFragmentHome(int id);

    public FragmentHome getFragmentHome(int id);

    public PageHolder<FragmentHome> queryFragmentHomeByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

}
