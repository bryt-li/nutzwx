package org.nutz.weixin.spi;

import org.nutz.lang.util.NutMap;
import org.nutz.weixin.bean.*;

import java.io.File;
import java.util.Map;

/**
 * Created by wizzer on 2017/3/23.
 */
public interface WxPayApi {
    NutMap postPay(String url, String key, Map<String, Object> params);

    NutMap postPay(String url, String key, Map<String, Object> params, File file, String password);

    NutMap pay_unifiedorder(String key, WxPayUnifiedOrder wxPayUnifiedOrder);

    NutMap pay_jsapi(String key, WxPayUnifiedOrder wxPayUnifiedOrder);

    NutMap pay_transfers(String key, WxPayTransfers wxPayTransfers, File file, String password);

    NutMap send_redpack(String key, WxPayRedPack wxRedPack, File file, String password);

    NutMap send_redpackgroup(String key, WxPayRedPackGroup wxRedPackGroup, File file, String password);

    NutMap send_coupon(String key, WxPayCoupon wxPayCoupon, File file, String password);
    
    //following added by Lixin
    //其实是是对上面API的进一步封装，把所有与微信相关的配置的处理都放到了这个项目里
    NutMap query_payment(String out_trade_no);
    
    NutMap get_pay_jsapi_args(String body, String openid, String ip, String out_trade_no, int total_fee);
    
    boolean is_sign_correct(NutMap map);
}
