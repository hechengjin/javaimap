package implement;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import interfaces.IFetchMail;
import model.UserInfo;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by hechengjin on 18-1-16.
 */
public class FetchMailJAVAMailImpl implements IFetchMail {

    Session session = null;
    IMAPFolder folder = null;
    IMAPStore store = null;
    Folder[] allFolder = null;

    public void login(UserInfo userInfo) {

//        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
//        props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
//        props.setProperty("mail.imap.socketFactory.port", Integer.valueOf(userInfo.getPort()).toString());
        String protocol = userInfo.getProtocol();
        if(userInfo.isSsl()){
            protocol = userInfo.getProtocol() + "s";
        }
        props.setProperty("mail.store.protocol", protocol);

        props.setProperty("mail.imap.host", userInfo.getHost());
        props.setProperty("mail.imap.port", Integer.valueOf(userInfo.getPort()).toString());
//        props.setProperty("mail.imap.auth.login.disable", "false");
        session = Session.getDefaultInstance(props,null);
        session.setDebug(true);
        try {
            store=(IMAPStore)session.getStore(protocol);  // 使用imap会话机制，连接服务器
            store.connect(userInfo.getHost(),userInfo.getPort(),userInfo.getFullname(),userInfo.getPassword());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void folderProce() {
        try {
            Folder defaultFolder = store.getDefaultFolder();
            allFolder = defaultFolder.list();
            for (int i = 0; i < allFolder.length; i++) {
                System.out.println(allFolder[i].getFullName());
            }
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void mailProce() {
        try {
            for (int i = 0; i < allFolder.length; i++) {
                if (!allFolder[i].getFullName().equals("mytest3")){
                    continue;
                }
                folder = (IMAPFolder)store.getFolder(allFolder[i].getFullName());
                // 使用只读方式打开邮件夹
                folder.open(Folder.READ_WRITE);
//                int size = folder.getMessageCount();
                Message[] messages=folder.getMessages();
                for (int j = 0; j < messages.length; j++) {
//                    Message mimeMessage = messages[j];
                    MimeMessage mimeMessage = (MimeMessage) messages[j];
//                    String from = mimeMessage.getFrom()[0].toString();
                    String subject = mimeMessage.getSubject();
                    Date date = mimeMessage.getSentDate();
                    int size = mimeMessage.getSize();
                    Long Uid = folder.getUID(mimeMessage);
                    System.out.println("UID: "  + Uid.toString() +" Subject: " + subject + " Size: " + size + " Date: " + date);
                    //https://www.cnblogs.com/liuyitian/p/4051922.html
//                    Multipart multipart = (Multipart)mimeMessage.getContent();
                    File directory = new File("");//设定为当前文件夹
                    String filename = directory.getAbsolutePath() + "/testmail/" + Uid.toString();
                    File file = new File(filename);
                    FileOutputStream out = null;
                    out = new FileOutputStream(file);
//                        multipart.writeTo(out);
//                    out.write(mimeMessage.getContent().toString().getBytes()); //这样写入的是html内容
                    mimeMessage.writeTo(out);
                    if(out != null) {
                        out.close();
                    }
                    if(j >= 10){
                        break;
                    }
                }
            }
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mailbodyFetch() {

    }

    public void close() {
        try {
            if (folder != null) {
                folder.close(false);
            }
            if (store != null) {
                store.close();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
