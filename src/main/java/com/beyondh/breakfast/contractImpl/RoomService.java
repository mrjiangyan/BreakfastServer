package com.beyondh.breakfast.contractImpl;

import com.beyondh.breakfast.contract.IRoomService;
import com.beyondh.breakfast.interceptor.RequestCallContext;
import com.beyondh.breakfast.network.Model.HotelBreakfastSummaryModel;
import com.beyondh.breakfast.network.Model.PmsPageModel;
import com.beyondh.breakfast.network.Model.PmsResultModel;
import com.beyondh.breakfast.network.Model.RoomModel;
import com.beyondh.breakfast.network.PmsRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jliang on 7/31/2017.
 */
@Service
public class RoomService implements IRoomService {

    @Autowired
    private PmsRestClient pmsRestClient;

    @Autowired
    private RequestCallContext requestCallContext;

    @Override
    public List<RoomModel> GetRoomsByRoomNumber(String roomNumber) {
        ParameterizedTypeReference<PmsResultModel<PmsPageModel<RoomModel>>> typeRef = new ParameterizedTypeReference<PmsResultModel<PmsPageModel<RoomModel>>>() { };
        PmsResultModel<PmsPageModel<RoomModel>> result = pmsRestClient.GetClient().exchange(requestCallContext.GetUser().getUrl()+"/API/Configure/GetRooms?OrgId="+requestCallContext.GetUser().getOrgId()+"&Keywords="+roomNumber+"&PageSize=100&PageIndex=1", HttpMethod.GET, null, typeRef).getBody();
        if (result.getCode() != 0) {
            throw new IllegalArgumentException(result.getMessage());
        }

        return result.getContent().getContent();
    }
}
