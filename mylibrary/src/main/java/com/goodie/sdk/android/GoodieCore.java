package com.goodie.sdk.android;
import android.app.Application;
import android.support.annotation.RestrictTo;
import com.goodie.sdk.android.data.bean.BasicRulesReq;
import com.goodie.sdk.android.data.bean.CustomRulesReq;
import com.goodie.sdk.android.data.builder.LoginBuilder;
import com.goodie.sdk.android.data.builder.MemberPointBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryBasicBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryCustomByAmountBuilder;
import com.goodie.sdk.android.data.builder.PromotionInquiryCustomIssuingBuilder;
import com.goodie.sdk.android.data.builder.PromotionPostingBuilder;
import com.goodie.sdk.android.data.builder.RegisterBuilder;
import com.goodie.sdk.android.data.builder.VerificationBuilder;
import java.util.List;

/**
 * Created by asep.surahman on 09/01/2019.
 */

public class GoodieCore{

    private static Application appInstance;
    private static String appId;
    private static String appServer;

    GoodieCore(){}

    /**
     * The first method you need to be invoke to using goodie sdk. Call this method from your Application
     * class. You can not using another goodie feature if you not invoke this method first. Here sample
     * to call this method:
     * <pre>
     * {@code
     * public class SampleApps extends Application {
     *  public void onCreate() {
     *      super.onCreate();
     *      GoodieCore.init(this, "yourQiscusAppId");
     *  }
     * }
     * }
     * </pre>
     *
     * @param application Application instance
     * @param goodieAppId Your goodie application Id
     */
    public static void init(Application application, String qiscusAppId){
        initWithCustomServer(application, qiscusAppId, "");
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    public static void initWithCustomServer(Application application, String goodieAppId, String serverBaseUrl){
        appInstance = application;
        appId = goodieAppId;
        appServer = !serverBaseUrl.endsWith("/") ? serverBaseUrl + "/" : serverBaseUrl;
    }

    //login user
    public static LoginBuilder setLoginUser(String deviceUniqId, String userEmail, String password, String merchantId){
        return new LoginBuilder(deviceUniqId, userEmail, password, merchantId);
    }

    //register user
    public static RegisterBuilder setRegisterUser(String username, String merchantId, String phoneNumber, String password, String firstName, String lastName,
                                                  String deviceUniqId, String birthDate, String referralCode){
        return new RegisterBuilder(username, merchantId, phoneNumber, password, firstName, lastName, deviceUniqId, birthDate, referralCode);
    }

    //verification
    public static VerificationBuilder setVerificationUser(String username, String merchantId, String verificationCode){
        return new VerificationBuilder(username, merchantId, verificationCode);
    }

    //member point
    public static MemberPointBuilder setMemberPointBuilder(String authToken, String deviceUniqId,  String memberId, String merchantId){
        return new MemberPointBuilder(authToken, deviceUniqId, memberId, merchantId);
    }

    //promotion inquiry
    public static PromotionInquiryBuilder setPromotionInquiryBuilder(String authToken, String deviceUniqId, String memberId, String merchantId,
                                                                     String storeId, BasicRulesReq basicRulesReq,
                                                                     List<CustomRulesReq> customRulesReqs){
        return new PromotionInquiryBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, basicRulesReq, customRulesReqs);
    }

    //promotion posting
    public static PromotionPostingBuilder setPromotionPostingBuilder(String authToken, String deviceUniqId, String memberId, String merchantId,
                                                                     String storeId, BasicRulesReq basicRulesReq,
                                                                     List<CustomRulesReq> customRulesReqs){
        return new PromotionPostingBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, basicRulesReq, customRulesReqs);
    }

    //promotion inquiry basic
    public static PromotionInquiryBasicBuilder setPromotionInqBasicBuilder(String authToken, String deviceUniqId, String memberId, String merchantId,
                                                    String storeId, String productCode, String refNumber,
                                                    Double totalTrxAmount){
        return new PromotionInquiryBasicBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, productCode, refNumber, totalTrxAmount);
    }

    //promotion inquiry custom issuing
    public static PromotionInquiryCustomIssuingBuilder setPromotionInqCustomIssuingBuilder(String authToken, String deviceUniqId, String memberId, String merchantId,
                                                                                   String storeId, String ruleName, int issuing,
                                                                                   int amount, String ref){
        return new PromotionInquiryCustomIssuingBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, issuing, amount, ref);
    }

    //promotion inquiry custom by Amount
    public static PromotionInquiryCustomByAmountBuilder setPromotionInqCustomByAmountBuilder(String authToken, String deviceUniqId, String memberId, String merchantId,
                                                                                            String storeId, String ruleName, int issuing,
                                                                                            int amount, String ref){
        return new PromotionInquiryCustomByAmountBuilder(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, issuing, amount, ref);
    }


    /**
     * Use this method if we need application context instance
     *
     * @return Your application instance
     */
    public static Application getApps(){
        checkAppIdSetup();
        return appInstance;
    }


    /**
     * AppId checker
     *
     * @throws RuntimeException
     */
    public static void checkAppIdSetup() throws RuntimeException {
        if (appServer == null) {
            throw new RuntimeException("Please init Goodie with your app id before!");
        }
    }



}
