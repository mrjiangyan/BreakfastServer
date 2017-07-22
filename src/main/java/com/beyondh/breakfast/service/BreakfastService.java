package com.beyondh.breakfast.service;

import com.beyondh.breakfast.model.BreakfastInfoModel;
import com.beyondh.breakfast.network.PmsRestClient;
import com.beyondh.breakfast.utils.JsonUtils;
import com.beyondh.breakfast.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Created by BeyondHost on 7/18/2017.
 */
@Service
public class BreakfastService {
    @Autowired
    private PmsRestClient pmsRestClient;

    public BreakfastInfoModel GetBreakfastInfo(String roomNumber) {
        if (StringUtils.isEmpty(roomNumber)) {
            throw new IllegalArgumentException("roomNumber is illegal");
        }
        BreakfastInfoModel breakfastInfoModel = new BreakfastInfoModel();
        String queryUrl = String.format("http://pms.test.beyondh.com/API/Breakfast/GetBreakfastInfo?Number=%s&SearchType=RoomNumber", roomNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "qqmail_alias=yxzhao@beyondh.com; CallDetect=Null; Shift=2; SessionId=AADEE915-228A-4ADE-A901-7FA6E2E50F87; OwnerId=164-249-252-54-237-28-162-142-252-143-97-116-230-13-68-69; LoginOrgId=191-177-10-23-134-199-115-171-28-141-251-210-49-27-53-105; Token=4D3BBF34-ABE5-43C7-BAD5-36CCDA0C0FEA; StorageKey=CB322B73F853C5A62022F531BDACB33BC47479F4; IsShowByhHelp=true; tutorialAddress=http://tutorial.beyondh.com?r=; OperateOrgId=191-177-10-23-134-199-115-171-28-141-251-210-49-27-53-105");
        headers.setContentType( MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);

        ResponseEntity<Object> responseEntity = pmsRestClient.GetClient().exchange(queryUrl, HttpMethod.GET,requestEntity, Object.class);

        LinkedHashMap response = (LinkedHashMap) responseEntity.getBody();
        LinkedHashMap content = (LinkedHashMap)response.get("Content");

        String jsonString = JsonUtils.Serialize(content);

        breakfastInfoModel = JsonUtils.Deserialize(jsonString,BreakfastInfoModel.class);

        return breakfastInfoModel;
    }
}
