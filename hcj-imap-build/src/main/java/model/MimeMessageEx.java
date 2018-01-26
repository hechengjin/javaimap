package model;

import javax.mail.internet.MimeMessage;

/**
 * Created by hechengjin on 18-1-18.
 */
public class MimeMessageEx {
    MimeMessage mimeMessage;
    MailInfoImap mailInfo;
    FolderInfoImap folderInfo;

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }

    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }

    public MailInfoImap getMailInfo() {
        return mailInfo;
    }

    public void setMailInfo(MailInfoImap mailInfo) {
        this.mailInfo = mailInfo;
    }

    public FolderInfoImap getFolderInfo() {
        return folderInfo;
    }

    public void setFolderInfo(FolderInfoImap folderInfo) {
        this.folderInfo = folderInfo;
    }
}
