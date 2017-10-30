package com.baidu.entity;

import java.util.Date;



public class OrderPayLog extends BaseEntity {
    
    /**
     * 序列化Id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String id ;
    /**
     * 订单号
     */
    private String orderNo ;
    /**
     * 支付订单号，发起支付请求时生成
     */
    private String payOrderNo ;
    /**
     * 微信支付订单号
     */
    private String transactionId ;
    /**
     * 用户id
     */
    private String customerId ;
    /**
     * 用户名称
     */
    private String customerName ;
    /**
     * 用户号码
     */
    private String customerMobile ;
    /**
     * 支付状态 0 待提交 1 提交失败 2 提交成功 3 支付成功 4 支付超时
     */
    private Integer payStatus ;
    /**
     * 订单总金额，单位为分
     */
    private Integer totalFee ;
    /**
     * 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private Integer settlementTotalFee ;
    /**
     * 现金支付金额
     */
    private Integer cashFee ;
    /**
     * 现金支付货币类型
     */
    private String cashFeeType ;
    /**
     * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepayId ;
    /**
     * 二维码链接 trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
     */
    private String codeUrl ;
    /**
     * 
     */
    private java.util.Date payTime ;
    /**
     * 支付完成时间，格式为yyyyMMddHHmmss
     */
    private String timeEnd ;
    /**
     * 支付方式 0 维修支付
     */
    private Integer payType ;
    /**
     * 费用类型 0 保证金  1 支付余额
     */
    private Integer expenseType;
    /**
     * 是否退款   0 否  1 是  2 退款失败
     */
    private Integer isDrawback;
    /**
     * 退款时间
     */
    private Date drawbackTime;
    /**
     * 是否需要对账（-1不需要 0：需要；1：日对账通过；2：日对账异常）
     */
    private Integer accountStatus;
    /**
     * 日对账时间
     */
    private Date accountTime;
    /**
     * 结算状态（-1不需要 0：未结算对账；1：待结算；2：结算单生成）
     */
    private Integer balanceStatus;
    /**
     * 结算对账时间
     */
    private Date balanceTime;
    /**
     * 默认人民币：CNY
     */
    private String feeType ;
    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    private String deviceInfo ;
    /**
     * 随机字符串
     */
    private String nonceStr ;
    /**
     * 签名
     */
    private String sign ;
    /**
     * 
     */
    private String body ;
    /**
     * 
     */
    private String detail ;
    /**
     * 附加数据
     */
    private String attach ;
    /**
     * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    private String spbillCreateIp ;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss
     */
    private String timeStart ;
    /**
     * 订单失效时间，格式为yyyyMMddHHmmss
     */
    private String timeExpire ;
    /**
     * 商品标记 ，代金券或立减优惠功能的参数
     */
    private String goodsTag ;
    /**
     * 交易类型 取值如下：JSAPI，NATIVE，APP
     */
    private String tradeType ;
    /**
     * 付款银行
     */
    private String bankType ;
    /**
     * 商品ID
     */
    private String productId ;
    /**
     * 指定支付方式 no_credit--指定不能使用信用卡支付
     */
    private String limitPay ;
    /**
     * 用户标识
     */
    private String openid ;
    /**
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String isSubscribe ;
    /**
     * 错误代码
     */
    private String errCode ;
    /**
     * 错误代码描述
     */
    private String errCodeDes ;
    /**
     * 代金券金额<=订单金额，订单金额-代金券金额=现金支付金额
     */
    private Integer couponFee ;
    /**
     * 代金券使用数量
     */
    private Integer couponCount ;
    /**
     * 代金券数据信息
     */
    private String couponData ;

    /**
     * get:
     */
    public String getId(){
        return this.id;
    }

    /**
     * set：
     */
    public void setId(String id){
        this.id=id;
    }
    /**
     * get:订单号
     */
    public String getOrderNo(){
        return this.orderNo;
    }

    /**
     * set：订单号
     */
    public void setOrderNo(String orderNo){
        this.orderNo=orderNo;
    }
    /**
     * get:支付订单号，发起支付请求时生成
     */
    public String getPayOrderNo(){
        return this.payOrderNo;
    }

    /**
     * set：支付订单号，发起支付请求时生成
     */
    public void setPayOrderNo(String payOrderNo){
        this.payOrderNo=payOrderNo;
    }
    /**
     * get:微信支付订单号
     */
    public String getTransactionId(){
        return this.transactionId;
    }

    /**
     * set：微信支付订单号
     */
    public void setTransactionId(String transactionId){
        this.transactionId=transactionId;
    }
    /**
     * get:用户id
     */
    public String getCustomerId(){
        return this.customerId;
    }

    /**
     * set：用户id
     */
    public void setCustomerId(String customerId){
        this.customerId=customerId;
    }
    /**
     * get:用户名称
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     * set：用户名称
     */
    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }
    /**
     * get:用户号码
     */
    public String getCustomerMobile(){
        return this.customerMobile;
    }

    /**
     * set：用户号码
     */
    public void setCustomerMobile(String customerMobile){
        this.customerMobile=customerMobile;
    }
    /**
     * get:支付状态 0 待提交 1 提交失败 2 提交成功 3 支付成功 4 支付超时
     */
    public Integer getPayStatus(){
        return this.payStatus;
    }

    /**
     * set：支付状态 0 待提交 1 提交失败 2 提交成功 3 支付成功 4 支付超时
     */
    public void setPayStatus(Integer payStatus){
        this.payStatus=payStatus;
    }
    /**
     * get:订单总金额，单位为分
     */
    public Integer getTotalFee(){
        return this.totalFee;
    }

    /**
     * set：订单总金额，单位为分
     */
    public void setTotalFee(Integer totalFee){
        this.totalFee=totalFee;
    }
    /**
     * get:应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    public Integer getSettlementTotalFee(){
        return this.settlementTotalFee;
    }

    /**
     * set：应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    public void setSettlementTotalFee(Integer settlementTotalFee){
        this.settlementTotalFee=settlementTotalFee;
    }
    /**
     * get:现金支付金额
     */
    public Integer getCashFee(){
        return this.cashFee;
    }

    /**
     * set：现金支付金额
     */
    public void setCashFee(Integer cashFee){
        this.cashFee=cashFee;
    }
    /**
     * get:现金支付货币类型
     */
    public String getCashFeeType(){
        return this.cashFeeType;
    }

    /**
     * set：现金支付货币类型
     */
    public void setCashFeeType(String cashFeeType){
        this.cashFeeType=cashFeeType;
    }
    /**
     * get:微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    public String getPrepayId(){
        return this.prepayId;
    }

    /**
     * set：微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    public void setPrepayId(String prepayId){
        this.prepayId=prepayId;
    }
    /**
     * get:二维码链接 trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
     */
    public String getCodeUrl(){
        return this.codeUrl;
    }

    /**
     * set：二维码链接 trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
     */
    public void setCodeUrl(String codeUrl){
        this.codeUrl=codeUrl;
    }
    /**
     * get:
     */
    public java.util.Date getPayTime(){
        return this.payTime;
    }

    /**
     * set：
     */
    public void setPayTime(java.util.Date payTime){
        this.payTime=payTime;
    }
    /**
     * get:支付完成时间，格式为yyyyMMddHHmmss
     */
    public String getTimeEnd(){
        return this.timeEnd;
    }

    /**
     * set：支付完成时间，格式为yyyyMMddHHmmss
     */
    public void setTimeEnd(String timeEnd){
        this.timeEnd=timeEnd;
    }
    /**
     * get:支付方式 0 维修支付
     */
    public Integer getPayType(){
        return this.payType;
    }

    /**
     * set：支付方式 0 维修支付
     */
    public void setPayType(Integer payType){
        this.payType=payType;
    }
    
    /**
     * 费用类型 0 保证金  1 支付余额
     * @CreateDate: 2016-10-12 下午11:14:02
     */
    public Integer getExpenseType() {
        return expenseType;
    }
    /**
     * 费用类型 0 保证金  1 支付余额
     * @CreateDate: 2016-10-12 下午11:14:02
     */
    public void setExpenseType(Integer expenseType) {
        this.expenseType = expenseType;
    }

    public Integer getIsDrawback() {
        return isDrawback;
    }

    public void setIsDrawback(Integer isDrawback) {
        this.isDrawback = isDrawback;
    }

    public Date getDrawbackTime() {
        return drawbackTime;
    }

    public void setDrawbackTime(Date drawbackTime) {
        this.drawbackTime = drawbackTime;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    public Date getBalanceTime() {
        return balanceTime;
    }

    public void setBalanceTime(Date balanceTime) {
        this.balanceTime = balanceTime;
    }

    /**
     * get:默认人民币：CNY
     */
    public String getFeeType(){
        return this.feeType;
    }

    /**
     * set：默认人民币：CNY
     */
    public void setFeeType(String feeType){
        this.feeType=feeType;
    }
    /**
     * get:终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    public String getDeviceInfo(){
        return this.deviceInfo;
    }

    /**
     * set：终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    public void setDeviceInfo(String deviceInfo){
        this.deviceInfo=deviceInfo;
    }
    /**
     * get:随机字符串
     */
    public String getNonceStr(){
        return this.nonceStr;
    }

    /**
     * set：随机字符串
     */
    public void setNonceStr(String nonceStr){
        this.nonceStr=nonceStr;
    }
    /**
     * get:签名
     */
    public String getSign(){
        return this.sign;
    }

    /**
     * set：签名
     */
    public void setSign(String sign){
        this.sign=sign;
    }
    /**
     * get:
     */
    public String getBody(){
        return this.body;
    }

    /**
     * set：
     */
    public void setBody(String body){
        this.body=body;
    }
    /**
     * get:
     */
    public String getDetail(){
        return this.detail;
    }

    /**
     * set：
     */
    public void setDetail(String detail){
        this.detail=detail;
    }
    /**
     * get:附加数据
     */
    public String getAttach(){
        return this.attach;
    }

    /**
     * set：附加数据
     */
    public void setAttach(String attach){
        this.attach=attach;
    }
    /**
     * get:APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    public String getSpbillCreateIp(){
        return this.spbillCreateIp;
    }

    /**
     * set：APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    public void setSpbillCreateIp(String spbillCreateIp){
        this.spbillCreateIp=spbillCreateIp;
    }
    /**
     * get:订单生成时间，格式为yyyyMMddHHmmss
     */
    public String getTimeStart(){
        return this.timeStart;
    }

    /**
     * set：订单生成时间，格式为yyyyMMddHHmmss
     */
    public void setTimeStart(String timeStart){
        this.timeStart=timeStart;
    }
    /**
     * get:订单失效时间，格式为yyyyMMddHHmmss
     */
    public String getTimeExpire(){
        return this.timeExpire;
    }

    /**
     * set：订单失效时间，格式为yyyyMMddHHmmss
     */
    public void setTimeExpire(String timeExpire){
        this.timeExpire=timeExpire;
    }
    /**
     * get:商品标记 ，代金券或立减优惠功能的参数
     */
    public String getGoodsTag(){
        return this.goodsTag;
    }

    /**
     * set：商品标记 ，代金券或立减优惠功能的参数
     */
    public void setGoodsTag(String goodsTag){
        this.goodsTag=goodsTag;
    }
    /**
     * get:交易类型 取值如下：JSAPI，NATIVE，APP
     */
    public String getTradeType(){
        return this.tradeType;
    }

    /**
     * set：交易类型 取值如下：JSAPI，NATIVE，APP
     */
    public void setTradeType(String tradeType){
        this.tradeType=tradeType;
    }
    /**
     * get:付款银行
     */
    public String getBankType(){
        return this.bankType;
    }

    /**
     * set：付款银行
     */
    public void setBankType(String bankType){
        this.bankType=bankType;
    }
    /**
     * get:商品ID
     */
    public String getProductId(){
        return this.productId;
    }

    /**
     * set：商品ID
     */
    public void setProductId(String productId){
        this.productId=productId;
    }
    /**
     * get:指定支付方式 no_credit--指定不能使用信用卡支付
     */
    public String getLimitPay(){
        return this.limitPay;
    }

    /**
     * set：指定支付方式 no_credit--指定不能使用信用卡支付
     */
    public void setLimitPay(String limitPay){
        this.limitPay=limitPay;
    }
    /**
     * get:用户标识
     */
    public String getOpenid(){
        return this.openid;
    }

    /**
     * set：用户标识
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }
    /**
     * get:用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    public String getIsSubscribe(){
        return this.isSubscribe;
    }

    /**
     * set：用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    public void setIsSubscribe(String isSubscribe){
        this.isSubscribe=isSubscribe;
    }
    /**
     * get:错误代码
     */
    public String getErrCode(){
        return this.errCode;
    }

    /**
     * set：错误代码
     */
    public void setErrCode(String errCode){
        this.errCode=errCode;
    }
    /**
     * get:错误代码描述
     */
    public String getErrCodeDes(){
        return this.errCodeDes;
    }

    /**
     * set：错误代码描述
     */
    public void setErrCodeDes(String errCodeDes){
        this.errCodeDes=errCodeDes;
    }
    /**
     * get:代金券金额<=订单金额，订单金额-代金券金额=现金支付金额
     */
    public Integer getCouponFee(){
        return this.couponFee;
    }

    /**
     * set：代金券金额<=订单金额，订单金额-代金券金额=现金支付金额
     */
    public void setCouponFee(Integer couponFee){
        this.couponFee=couponFee;
    }
    /**
     * get:代金券使用数量
     */
    public Integer getCouponCount(){
        return this.couponCount;
    }

    /**
     * set：代金券使用数量
     */
    public void setCouponCount(Integer couponCount){
        this.couponCount=couponCount;
    }
    /**
     * get:代金券数据信息
     */
    public String getCouponData(){
        return this.couponData;
    }

    /**
     * set：代金券数据信息
     */
    public void setCouponData(String couponData){
        this.couponData=couponData;
    }

}
