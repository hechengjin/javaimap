package interfaces;

import common.ErrorMessage;
import model.FolderInfoImap;
import model.ProxyInfo;
import model.UserInfo;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by hechengjin on 18-1-16.
 */
public abstract interface FetchMailProcess {
    UserInfo userInfo = null;
    FolderInfoImap folderInfo = null;
    String mailUids = null;

    //登录接口
    public abstract ErrorMessage login(UserInfo user, ProxyInfo proxyInfo) throws MessagingException;

    //邮件夹处理 判断要收取哪个邮件夹
    public abstract ErrorMessage folderProce() throws MessagingException;


    //判断要收取哪些邮件
    public abstract ErrorMessage mailProce() throws IOException,  MessagingException;


    //收取指定的邮件
    public abstract ErrorMessage mailbodyFetch() throws IOException,  MessagingException;

    //关闭连接
    public abstract ErrorMessage close();

    //清理已删除的邮件
    public abstract ErrorMessage clearErase() throws MessagingException;

}
