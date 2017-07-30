package com.beyondh.breakfast.contract;

import com.beyondh.breakfast.model.auth.UserModel;
import com.beyondh.breakfast.network.Model.OrgInfoModel;

/**
 * Created by jliang on 7/31/2017.
 */
public interface IOrgService {
    /**
     * 获取可用酒店
     * @return
     */
    OrgInfoModel[] GetAvailiableOrgsByUser();

    /**
     * 切换酒店
     * @return
     */
    UserModel ChangeOrg();
}
