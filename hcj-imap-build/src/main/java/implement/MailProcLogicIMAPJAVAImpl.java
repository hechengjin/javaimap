package implement;

import interfaces.MailProcLogic;
import model.FolderInfoImap;
import model.MailInfoImap;
import model.UserInfo;
import model.TaskInfo;

import java.util.List;

/**
 * Created by hechengjin on 18-1-16.
 */
public class MailProcLogicIMAPJAVAImpl implements MailProcLogic {
    UserInfo userInfo;
    FolderInfoImap folderInfo;
    TaskInfo taskInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public FolderInfoImap getFolderInfo() {
        return folderInfo;
    }

    public void setFolderInfo(FolderInfoImap folderInfo) {
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

    public boolean folderExist(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public boolean addFolder(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public boolean delFolder(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public boolean renameFolder(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public List<FolderInfoImap> getＡllＦolder(UserInfo userInfo) {
        return null;
    }

    public boolean mailExist(MailInfoImap mailInfo) {
        return false;
    }

    public boolean addMail(MailInfoImap mailInfo) {
        return false;
    }

    public boolean delMail(MailInfoImap mailInfo) {
        return false;
    }

    public List<MailInfoImap> getFolderMails(FolderInfoImap folderInfo) {
        return null;
    }

    public void addFlag() {

    }

    public void delFlag() {

    }

    public void close() {

    }
}
