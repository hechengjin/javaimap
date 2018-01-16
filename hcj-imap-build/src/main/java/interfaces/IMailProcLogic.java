package interfaces;

import model.FolderInfo;
import model.MailInfo;
import model.UserInfo;

/**
 * Created by hechengjin on 18-1-16.
 */
public interface IMailProcLogic {
    UserInfo userInfo = null;
    FolderInfo fetchFolderInfo = null;

    //////////////缓存中判断//////////////////
    //先判断此用户邮件是否在收取中
    public abstract boolean infetching(UserInfo userInfo);
    public abstract boolean addfetching(UserInfo userInfo);
    public abstract boolean delfetching(UserInfo userInfo);


    ////////////数据库中判断////////////////
    //邮件夹是否存在
    public abstract boolean folderExist(FolderInfo fetchFolderInfo);
    public abstract boolean addFolder(FolderInfo fetchFolderInfo);
    public abstract boolean delFolder(FolderInfo fetchFolderInfo);
    public abstract boolean renameFolder(FolderInfo fetchFolderInfo);

    //邮件体是否已经下载完成
    public abstract boolean mailBodyFineshed(MailInfo mailInfo);
    public abstract boolean addMailBody(MailInfo mailInfo);
    public abstract boolean delMailBody(MailInfo mailInfo);

    //邮件标志处理
    public abstract void addFlag();
    public abstract void delFlag();

}