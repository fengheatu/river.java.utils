package com.river.utils.code;

import com.river.utils.HttpResp;
import com.river.utils.HttpsClientUtil;
import com.river.utils.Sha1Util;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.*;

/**
 * @author he.feng
 * @2018/7/4
 * @desc
 */
public class CodecTest {


    public static final String  BUSSINE_TEST_URL = "https://t.limuzhengxin.cn";
    /**
     * 电商报告 begin
     */

    /**
     * 电商报告采集任务提交
     */
    @Test
    public void test1() throws Exception {
        Map<String,String> params = new HashMap<>();
        params.put("apiKey","7746667229513598");
        params.put("accessType","api");
        params.put("identityCardNo","45092319930809177X");
        params.put("identityName","冯河");
        params.put("username","13122198128");
        String sign = getSign(params);
        params.put("sign",sign);
        HttpResp httpResp = HttpsClientUtil.httpPost(BUSSINE_TEST_URL + "/taobao_report/v1/task", params);
        System.out.println(httpResp.getResponseContext());

    }


    /**
     * 电商报告 end
     */

    /**
     * 获取签名
     * @param params
     * @return
     */
    private String getSign(Map<String,String> params) {
        List<String> paramKeys = new ArrayList<>();
        for(String key : params.keySet()) {
            paramKeys.add(key);
        }

        Collections.sort(paramKeys);

        StringBuilder sb = new StringBuilder();
        //组装
        for (String key : paramKeys) {
            sb.append(key).append("=").append(params.get(key)).append("&");
        }
        String signText = sb.toString().substring(0,sb.length() - 1) + "H3JMO7wkw9gplsro8AuUcETARsFk4pTg";

        return Sha1Util.shaHex(signText);
    }


}
