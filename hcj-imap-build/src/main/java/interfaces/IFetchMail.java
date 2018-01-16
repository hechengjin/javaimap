package interfaces;

import model.FolderInfo;
import model.UserInfo;

/**
 * Created by hechengjin on 18-1-16.
 */
public abstract interface IFetchMail {
    UserInfo userInfo = null;
    FolderInfo folderInfo = null;
    String mailUids = null;

    //登录接口
    public abstract void login(UserInfo userInfo);

    //邮件夹处理 判断要收取哪个邮件夹
    public abstract void folderProce();


    //判断要收取哪些邮件
    public abstract void mailProce();


    //收取指定的邮件
    public abstract void mailbodyFetch();

    //关闭连接
    public abstract void close();

}
