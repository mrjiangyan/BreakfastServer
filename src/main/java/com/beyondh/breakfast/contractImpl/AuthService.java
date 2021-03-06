package com.beyondh.breakfast.contractImpl;

import com.beyondh.breakfast.contract.IAuthService;
import com.beyondh.breakfast.model.auth.User;
import com.beyondh.breakfast.model.auth.UserModel;
import com.beyondh.breakfast.network.PmsRestClient;
import com.beyondh.breakfast.utils.CookieCache;
import com.beyondh.breakfast.utils.StringUtils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Created by jliang on 7/24/2017.
 */
@Service
public class AuthService implements IAuthService {

    @Autowired
    private PmsRestClient pmsRestClient;

    @Override
    public UserModel Login(User user) {
        ValidateUser(user);
        UserModel userModel = new UserModel();

        JSONObject postData = new JSONObject();
        postData.put("ID", user.getUserName());
        postData.put("Password", user.getPassword());
        postData.put("Shift", StringUtils.isBlank(user.getShift()) ? "0" : user.getShift());
        ResponseEntity<JSONObject> jsonObjectResponseEntity = pmsRestClient.GetClient().postForEntity(user.getUrl() + "/Home/Login", postData, JSONObject.class);
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

            user.setOrgId(Long.parseLong(currentUser.get("ExtenalOrgId").toString()));
            String cookie = StringUtils.ToString(jsonObjectResponseEntity.getHeaders().get("Set-Cookie"));

            CookieCache.Save(user, cookie);
        }

        return userModel;
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
