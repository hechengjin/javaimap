package implement;

import interfaces.IMailProcLogic;
import model.FolderInfo;
import model.MailInfo;
import model.UserInfo;

/**
 * Created by hechengjin on 18-1-16.
 */
public class MailProcLogicJAVAImpl implements IMailProcLogic {

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

    public boolean mailBodyFineshed(MailInfo mailInfo) {
        return false;
    }

    public boolean addMailBody(MailInfo mailInfo) {
        return false;
    }

    public boolean delMailBody(MailInfo mailInfo) {
        return false;
    }

    public void addFlag() {

    }

    public void delFlag() {

    }
}
