package com.javaweb.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.opensymphony.xwork2.ActionSupport;

@Controller("alipayAction")
@Scope("prototype")
public class AlipayAction extends ActionSupport {

	private static final long serialVersionUID = -7665234193188541820L;
	private String WIDout_trade_no;// 商户订单号
	private String WIDsubject;// 订单名称
	private String WIDtotal_fee;// 付款金额
	private String WIDshow_url;// 收银台页面上，商品展示的超链接，必填
	private String WIDbody;// 商品描述，可空

	private String payjson;

	public String toPayPage() {
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_id", AlipayConfig.seller_id);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("out_trade_no", WIDout_trade_no);
		sParaTemp.put("subject", WIDsubject);
		sParaTemp.put("total_fee", WIDtotal_fee);
		sParaTemp.put("show_url", WIDshow_url);
		// sParaTemp.put("app_pay","Y");//启用此参数可唤起钱包APP支付。
		sParaTemp.put("body", WIDbody);
		// 其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.2Z6TSk&treeId=60&articleId=103693&docType=1
		// 如sParaTemp.put("参数名","参数值");
		// 建立请求
		Map<String, String> sPara = AlipaySubmit.buildRequestPara(sParaTemp);
		payjson = JSON.toJSONString(sPara);
	//	System.out.println(payjson);
		return "toPayPage";
	}

	public String getPayjson() {
		return payjson;
	}

	public void setPayjson(String payjson) {
		this.payjson = payjson;
	}

	public String getWIDout_trade_no() {
		return WIDout_trade_no;
	}

	public void setWIDout_trade_no(String wIDout_trade_no) {
		WIDout_trade_no = wIDout_trade_no;
	}

	public String getWIDsubject() {
		return WIDsubject;
	}

	public void setWIDsubject(String wIDsubject) {
		WIDsubject = wIDsubject;
	}

	public String getWIDtotal_fee() {
		return WIDtotal_fee;
	}

	public void setWIDtotal_fee(String wIDtotal_fee) {
		WIDtotal_fee = wIDtotal_fee;
	}

	public String getWIDshow_url() {
		return WIDshow_url;
	}

	public void setWIDshow_url(String wIDshow_url) {
		WIDshow_url = wIDshow_url;
	}

	public String getWIDbody() {
		return WIDbody;
	}

	public void setWIDbody(String wIDbody) {
		WIDbody = wIDbody;
	}

}
