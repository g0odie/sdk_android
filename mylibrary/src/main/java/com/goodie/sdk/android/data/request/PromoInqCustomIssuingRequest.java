package com.goodie.sdk.android.data.request;
import com.goodie.sdk.android.data.bean.CustomRulesReq;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Goodie on 21/02/2019.
 */

public class PromoInqCustomIssuingRequest {

    @SerializedName("memberId")
    private String memberId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("storeId")
    private String storeId;


    @SerializedName("custom")
    @Expose
    private List<CustomRulesReq> customRulesReqs;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    public List<CustomRulesReq> getCustomRulesReqs() {
        return customRulesReqs;
    }

    public void setCustomRulesReqs(List<CustomRulesReq> customRulesReqs) {
        this.customRulesReqs = customRulesReqs;
    }
}
