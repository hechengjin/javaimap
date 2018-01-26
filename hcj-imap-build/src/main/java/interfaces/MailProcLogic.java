package interfaces;

import model.FolderInfoImap;
import model.MailInfoImap;
import model.UserInfo;
import model.TaskInfo;

import java.util.List;

/**
 * Created by hechengjin on 18-1-16.
 */
public interface MailProcLogic {
//    UserInfo userInfo = null;
//    FolderInfoImap fetchFolderInfo = null;
    TaskInfo taskInfo = new TaskInfo();

    public abstract TaskInfo getTaskInfo();
    public abstract void setUserInfo(UserInfo userInfo);
    public abstract void setFolderInfo(FolderInfoImap folderInfo);
    //////////////缓存中判断//////////////////
    //先判断此用户邮件是否在收取中
    public abstract boolean infetching(UserInfo userInfo);
    public abstract boolean addfetching(UserInfo userInfo);
    public abstract boolean delfetching(UserInfo userInfo);


    ////////////数据库中判断////////////////
    //邮件夹是否存在
    public abstract boolean folderExist(FolderInfoImap fetchFolderInfo);
    public abstract boolean addFolder(FolderInfoImap fetchFolderInfo);
    public abstract boolean delFolder(FolderInfoImap fetchFolderInfo);
    public abstract boolean renameFolder(FolderInfoImap fetchFolderInfo);
    public abstract List<FolderInfoImap> getＡllＦolder(UserInfo userInfo);

    //邮件体是否已经下载完成
    public abstract boolean mailExist(MailInfoImap mailInfo);
    public abstract boolean addMail(MailInfoImap mailInfo);
    public abstract boolean delMail(MailInfoImap mailInfo);
    public abstract List<MailInfoImap> getFolderMails(FolderInfoImap folderInfo);

    //邮件标志处理
    public abstract void addFlag();
    public abstract void delFlag();

    //关闭数据库
    public abstract void close();

}
