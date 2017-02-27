package com.yyt.print.rpc.client.ad;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;
import com.yyt.print.rpc.client.YytRpcClientFactory;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AdRpcServiceImplTest {

    IAdRpcService adRpcService = YytRpcClientFactory.getAdRpcService();

    @Test
    public void testQueryAdByPage() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        PageHolder<Ad> pageHolder = adRpcService.queryAdByPage(map, 1, 50);
        System.out.println(pageHolder.size());
    }
}