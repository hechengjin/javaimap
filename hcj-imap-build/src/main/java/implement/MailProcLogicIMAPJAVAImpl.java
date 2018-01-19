package implement;

import interfaces.IMailProcLogic;
import model.FolderInfo;
import model.MailInfo;
import model.UserInfo;
import model.TaskInfo;

import java.util.List;

/**
 * Created by hechengjin on 18-1-16.
 */
public class MailProcLogicIMAPJAVAImpl implements IMailProcLogic {
    UserInfo userInfo;
    FolderInfo folderInfo;
    TaskInfo taskInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public FolderInfo getFolderInfo() {
        return folderInfo;
    }

    public void setFolderInfo(FolderInfo folderInfo) {
        this.folderInfo = folderInfo;
    }

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public boolean infetching(UserInfo userInfo) {
        return false;
    }

    public boolean addfetching(UserInfo userInfo) {
        return false;
    }

    public boolean delfetching(UserInfo userInfo) {
        return false;
    }

    public boolean folderExist(FolderInfo fetchFolderInfo) {
        return false;
    }

    public boolean addFolder(FolderInfo fetchFolderInfo) {
        return false;
    }

    public boolean delFolder(FolderInfo fetchFolderInfo) {
        return false;
    }

    public boolean renameFolder(FolderInfo fetchFolderInfo) {
        return false;
    }

    public List<FolderInfo> getＡllＦolder(UserInfo userInfo) {
        return null;
    }

    public boolean mailExist(MailInfo mailInfo) {
        return false;
    }

    public boolean addMail(MailInfo mailInfo) {
        return false;
    }

    public boolean delMail(MailInfo mailInfo) {
        return false;
    }

    public List<MailInfo> getFolderMails(FolderInfo folderInfo) {
        return null;
    }

    public void addFlag() {

    }

    public void delFlag() {

    }


}
