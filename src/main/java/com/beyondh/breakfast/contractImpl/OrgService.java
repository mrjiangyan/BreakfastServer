package com.beyondh.breakfast.contractImpl;

import com.beyondh.breakfast.contract.IOrgService;
import com.beyondh.breakfast.interceptor.RequestCallContext;
import com.beyondh.breakfast.model.auth.UserModel;
import com.beyondh.breakfast.network.Model.HotelBreakfastSummaryModel;
import com.beyondh.breakfast.network.Model.OrgInfoModel;
import com.beyondh.breakfast.network.Model.PmsResultModel;
import com.beyondh.breakfast.network.PmsRestClient;
import com.beyondh.breakfast.utils.CookieCache;
import com.beyondh.breakfast.utils.JsonUtils;
import com.beyondh.breakfast.utils.StringUtils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Created by jliang on 7/31/2017.
 */
@Service
public class OrgService implements IOrgService {

    @Autowired
    private PmsRestClient pmsRestClient;

    @Autowired
    private RequestCallContext requestCallContext;

    @Override
    public OrgInfoModel[] GetAvailiableOrgsByUser() {
        ParameterizedTypeReference<PmsResultModel<String>> typeRef = new ParameterizedTypeReference<PmsResultModel<String>>() { };
        PmsResultModel<String> result = pmsRestClient.GetClient().exchange(requestCallContext.GetUser().getUrl()+"/API/Configure/GetAvailiableOrgsByUser", HttpMethod.GET, null,typeRef).getBody();
        if (result.getCode() != 0) {
            throw new IllegalArgumentException(result.getMessage());
        }

        return JsonUtils.Deserialize(result.getContent(),OrgInfoModel[].class);
    }

    @Override
    public UserModel ChangeOrg() {
        UserModel userModel = new UserModel();

        JSONObject postData = new JSONObject();
        postData.put("OrgId", requestCallContext.GetUser().getOrgId());
        ResponseEntity<JSONObject> jsonObjectResponseEntity = pmsRestClient.GetClient().postForEntity(requestCallContext.GetUser().getUrl() + "/Home/ChangeOrg", postData, JSONObject.class);
        JSONObject body = jsonObjectResponseEntity.getBody();

        if (Integer.parseInt(jsonObjectResponseEntity.getBody().get("Code").toString()) == 0) {
            LinkedHashMap<String, Object> content = (LinkedHashMap<String, Object>) body.get("Content");
            userModel.setSessionId(content.get("SessionId").toString());
            userModel.setDefaultOrgId(content.get("DefaultOrgId").toString());
            userModel.setOrgId(content.get("OrgId").toString());
            userModel.setOrgName(content.get("OrgName").toString());
            userModel.setOwnerId(content.get("OwnerId").toString());
            userModel.setShift(content.get("Shift").toString());
            userModel.setOwnerName(content.get("OwnerName").toString());
            LinkedHashMap<String, Object> currentUser = (LinkedHashMap<String, Object>) content.get("CurrentUser");
            userModel.setBusinessDate(currentUser.get("BusinessDate").toString());
            userModel.setEmployeeName(currentUser.get("EmployeeName").toString());

            String cookie = StringUtils.ToString(jsonObjectResponseEntity.getHeaders().get("Set-Cookie"));

            CookieCache.Save(requestCallContext.GetUser(), cookie);
        }

        return userModel;
    }
}
