package implement;

import interfaces.IMailProcLogic;
import model.FolderInfo;
import model.MailInfo;
import model.UserInfo;
import model.TaskInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 18-1-18.
 */
public class MailProcLogicIMAPMongoImpl implements IMailProcLogic {
    public void setUserInfo(UserInfo userInfo) {
        this.taskInfo.setUserＮame(userInfo.getFullname());
        this.taskInfo.setLimt(1024);
    }

    public void setFolderInfo(FolderInfo folderInfo) {
        this.taskInfo.setPath(folderInfo.getPath());
        this.taskInfo.setFolderＮame(folderInfo.getFolderＮame());
    }

    public TaskInfo getTaskInfo() {
        return taskInfo;
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
        return true;
    }

    public boolean delFolder(FolderInfo fetchFolderInfo) {
        return false;
    }

    public List<MailInfo> getFolderMails(FolderInfo folderInfo) {
        List<MailInfo> FolderInfoＬist = new ArrayList<MailInfo>();
        return FolderInfoＬist;
    }

    public boolean renameFolder(FolderInfo fetchFolderInfo) {
        return false;
    }

    public List<FolderInfo> getＡllＦolder(UserInfo userInfo) {
        List<FolderInfo> FolderInfoＬist = new ArrayList<FolderInfo>();
        return FolderInfoＬist;
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

    public void addFlag() {

    }

    public void delFlag() {

    }
}
