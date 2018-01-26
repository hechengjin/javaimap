package interfaces;

import common.ErrorMessage;
import model.ProxyInfo;
import model.UserInfo;

/**
 * Created by hechengjin on 18-1-17.
 */
public abstract interface FetchMail {
    UserInfo userInfo = new UserInfo();
    ProxyInfo proxyInfo = new ProxyInfo();
    //
    public abstract ErrorMessage fetchMail(UserInfo userInfo, ProxyInfo proxyInfo);
}
