package com.zds.controller;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zds.bean.Shopcar;
import com.zds.config.AlipayConfig;
import com.zds.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 〈〉<br>
 *
 * @author
 * @create 2019/1/16 16:00
 * @since 1.0.0
 */
@Controller
public class AlipayController {
private static final Logger log = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/toAlipay.action")
	@ResponseBody
	public String toAlipay(String shopCars) throws Exception {
		log.info("^^^^^^^^^^^^^^^^^^^^ alipay 前往支付宝第三方网关进行支付");
		java.net.URLDecoder.decode(shopCars,"utf-8");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gateway_url, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		//alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		List<Shopcar> toObj = JSON.parseArray(shopCars,Shopcar.class);
		//System.out.println(toObj.get(0).getGoodsMounts());
		//Map<String,String> map = new HashMap<String, String>();
		//int row = ordersService.insertMore(toObj);
		double total_price = 0;
		for (int i=0;i<toObj.size();i++){
			total_price+=toObj.get(i).getGoodsMounts()*toObj.get(i).getGoodsPrice();
		}

		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no =  UUID.randomUUID().toString();
		//付款金额，必填
		String total_amount = String.valueOf(total_price);
		//订单名称，必填
		String subject = "pay for shopcar";
		//商品描述，可空
		String body = null; /*"mounts:" + toObj.get(0).getGoodsMounts();*/
		// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		String timeout_express = "60m";
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
				+ "\"total_amount\":\""+ total_amount +"\","
				+ "\"subject\":\""+ subject +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"timeout_express\":\""+ timeout_express +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		log.info("^^^^^^^^^^^^^^^^^^^^ alipay 前往支付宝第三方网关进行支付"+result);
		return result;
	}
    
    /**
	 *
	 * @Description: 支付宝同步通知页面
	 *
	 */
	@RequestMapping(value = "/applySuccess.action")
	public ModelAndView alipayReturnNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		ModelAndView mv = new ModelAndView();
		//判断验签
		if(signVerified) {
			mv.setViewName("test");
			return mv;
		}

		return mv;
	}

}