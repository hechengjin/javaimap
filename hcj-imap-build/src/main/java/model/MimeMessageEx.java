package model;

import javax.mail.internet.MimeMessage;

/**
 * Created by hechengjin on 18-1-18.
 */
public class MimeMessageEx {
    MimeMessage mimeMessage;
    MailInfo mailInfo;
    FolderInfo folderInfo;

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }

    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }

    public MailInfo getMailInfo() {
        return mailInfo;
    }

    public void setMailInfo(MailInfo mailInfo) {
        this.mailInfo = mailInfo;
    }

    public FolderInfo getFolderInfo() {
        return folderInfo;
    }

    public void setFolderInfo(FolderInfo folderInfo) {
        this.folderInfo = folderInfo;
    }
}
