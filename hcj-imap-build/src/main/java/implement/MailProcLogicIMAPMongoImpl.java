package implement;

import interfaces.MailProcLogic;
import model.FolderInfoImap;
import model.MailInfoImap;
import model.UserInfo;
import model.TaskInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 18-1-18.
 */
@Component
public class MailProcLogicIMAPMongoImpl implements MailProcLogic {
//    @Autowired
//    private FolderInfoImapService folderInfoImapService;

    MailProcLogicIMAPMongoImpl(){
//        folderInfoImapService = new FolderInfoImapServiceImpl();
    }

    public void setUserInfo(UserInfo userInfo) {
        this.taskInfo.setUserＮame(userInfo.getFullname());
        this.taskInfo.setLimt(1024);
    }

    public void setFolderInfo(FolderInfoImap folderInfo) {
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

    public boolean folderExist(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public boolean addFolder(FolderInfoImap fetchFolderInfo) {
        return true;
    }

    public boolean delFolder(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public List<MailInfoImap> getFolderMails(FolderInfoImap folderInfo) {
        List<MailInfoImap> FolderInfoＬist = new ArrayList<MailInfoImap>();
        return FolderInfoＬist;
    }

    public boolean renameFolder(FolderInfoImap fetchFolderInfo) {
        return false;
    }

    public List<FolderInfoImap> getＡllＦolder(UserInfo userInfo) {
        List<FolderInfoImap> FolderInfoＬist = new ArrayList<FolderInfoImap>();
        return FolderInfoＬist;
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

    public void addFlag() {

    }

    public void delFlag() {

    }

    public void close() {

    }
}
