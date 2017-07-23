package com.beyondh.breakfast.contractImpl;

import com.beyondh.breakfast.contract.IAuthService;
import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.model.auth.UserEncryptModel;
import com.beyondh.breakfast.network.PmsRestClient;
import com.beyondh.breakfast.utils.CookieCache;
import com.beyondh.breakfast.utils.StringUtils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

/**
 * Created by jliang on 7/24/2017.
 */
public class AuthService implements IAuthService {

    @Autowired
    private PmsRestClient pmsRestClient;

    @Override
    public UserEncryptModel Login(User user) {
        ValidateUser(user);
        UserEncryptModel userEncryptModel = new UserEncryptModel();

        JSONObject postData = new JSONObject();
        postData.put("ID", user.getUserName());
        postData.put("Password", user.getPassword());
        postData.put("Shift", StringUtils.isBlank(user.getShift()) ? "0" : user.getShift());
        ResponseEntity<JSONObject> jsonObjectResponseEntity = pmsRestClient.GetClient().postForEntity(user.getUrl() + "/Home/Login", postData, JSONObject.class);
        JSONObject body = jsonObjectResponseEntity.getBody();

        if (Integer.parseInt(jsonObjectResponseEntity.getBody().get("Code").toString()) == 0) {
            LinkedHashMap<String, Object> content = (LinkedHashMap<String, Object>) body.get("Content");
            userEncryptModel.setSessionId(content.get("SessionId").toString());
            userEncryptModel.setDefaultOrgId(content.get("DefaultOrgId").toString());
            userEncryptModel.setOrgId(content.get("OrgId").toString());
            userEncryptModel.setOrgName(content.get("OrgName").toString());
            userEncryptModel.setOwnerId(content.get("OwnerId").toString());
            userEncryptModel.setShift(content.get("Shift").toString());
            userEncryptModel.setOwnerName(content.get("OwnerName").toString());
            LinkedHashMap<String, Object> currentUser = (LinkedHashMap<String, Object>) content.get("CurrentUser");
            userEncryptModel.setBusinessDate(currentUser.get("BusinessDate").toString());

            String cookie = StringUtils.ToString(jsonObjectResponseEntity.getHeaders().get("Set-Cookie"));

            CookieCache.Save(user, cookie);
        }

        return userEncryptModel;
    }

    private void ValidateUser(User user) {
        if (null == user) {
            throw new IllegalArgumentException("user is illegal");
        }
        if (StringUtils.isEmpty(user.getUrl())) {
            throw new IllegalArgumentException("url is illegal");
        }
        if (StringUtils.isEmpty(user.getUserName())) {
            throw new IllegalArgumentException("username is illegal");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new IllegalArgumentException("password is illegal");
        }
    }
}
