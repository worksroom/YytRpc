package com.yyt.print.thirdparty.wx;

import com.alibaba.fastjson.JSONObject;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.pojo.Response;
import com.youguu.core.util.HttpsUtil;
import com.yyt.print.common.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leo on 2017/2/7.
 */
public class TokenUtil {
    private static Log logger = LogFactory.getLog(Constants.LOGGER_NAME);

    /**
     * 微信token验证接口
     */
    private static final String AUTH_URL = "https://api.weixin.qq.com/sns/auth";
    /**
     * 微信用户信息查询接口
     */
    private static final String QUERY_USERINFO = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 验证令牌是否有效
     *
     * @param openid
     * @param access_token
     * @return
     */
    public static WxResponse authToken(String openid, String access_token) {
        WxResponse rs = new WxResponse();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("access_token", access_token);
        paramMap.put("openid", openid);

        Response<String> response = HttpsUtil.sendGet(AUTH_URL, paramMap, null, "UTF-8");
        if ("0000".equals(response.getCode())) {
            String result = response.getT();
            JSONObject o = JSONObject.parseObject(result);
            if (o.getInteger("errcode") == 0) {
                rs.setCode(0);
                rs.setText("ok");
            } else {
                rs.setCode(o.getInteger("errcode"));
                rs.setText(o.getString("errmsg"));
                logger.error("authToken wx_code=" + o.getInteger("errcode") + ", msg=" + o.getString("errmsg"));
            }

        } else {
            rs.setCode(-1);
            rs.setText(response.getMsg());
            logger.error("authToken youguu_code=" + response.getCode() + ", msg=" + response.getMsg());
        }
        return rs;
    }


    /**
     * 查询微信用户基本信息
     * @param openid
     * @param access_token
     * @return
     */
    public static WxUserInfo getWxUserInfo(String openid, String access_token) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("access_token", access_token);
        paramMap.put("openid", openid);

        Response<String> response = HttpsUtil.sendGet(QUERY_USERINFO, paramMap, null, "UTF-8");
        if ("0000".equals(response.getCode())) {
            String result = response.getT();

            if (result.contains("errcode")) {
                JSONObject o = JSONObject.parseObject(result);
                logger.error("getWxUserInfo wx_code=" + o.getInteger("errcode") + ", msg=" + o.getString("errmsg"));
            } else {
                WxUserInfo o = JSONObject.parseObject(result, WxUserInfo.class);
                return o;
            }
        } else {
            logger.error("authToken youguu_code=" + response.getCode() + ", msg=" + response.getMsg());
        }
        return null;
    }
}
