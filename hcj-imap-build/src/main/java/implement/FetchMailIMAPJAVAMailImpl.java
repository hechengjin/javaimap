package implement;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import common.ErrorCode;
import common.ErrorMessage;
import handel.CaculateStream;
import interfaces.IFetchMailProcess;
import interfaces.IMailProcLogic;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by hechengjin on 18-1-16.
 */
public class FetchMailIMAPJAVAMailImpl implements IFetchMailProcess {
    private static Logger logger = LoggerFactory.getLogger("FetchMailIMAPJAVAMailImpl");

    Session session = null;
    IMAPFolder folder = null;
    IMAPStore store = null;
    Folder[] allFolder = null;
    List<FolderInfo> localＦolders = null;
    List<FolderInfo> localtoＤelＦolders=new ArrayList<FolderInfo>();
    List<FolderInfo> localtoＡddＦolders=new ArrayList<FolderInfo>();
    List<MimeMessageEx> tofetchＭails = new ArrayList<MimeMessageEx>();
    List<MailInfo> localtoＤelMails = new ArrayList<MailInfo>();
    IMailProcLogic mailＰroclogic = null;
    UserInfo userInfo = null;
    FetchMailIMAPJAVAMailImpl(IMailProcLogic maillogic) {
        mailＰroclogic = maillogic;
    }


    public ErrorMessage login(UserInfo user, ProxyInfo proxyInfo) throws MessagingException {
        userInfo = user;
        mailＰroclogic.setUserInfo(user);
        logger.info("FetchMailIMAPJAVAMailImpl login for user {} using proxy {}:{} ({}).", userInfo.getFullname(), proxyInfo.getIp(), proxyInfo.getPort());
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
        props.setProperty("mail.imap.socks.host", proxyInfo.getIp());
        props.setProperty("mail.imap.socks.port", String.valueOf(proxyInfo.getPort()));
        session = Session.getDefaultInstance(props,null);
        session.setDebug(true);
//        try {
            store=(IMAPStore)session.getStore(protocol);  // 使用imap会话机制，连接服务器
            store.connect(userInfo.getHost(),userInfo.getPort(),userInfo.getFullname(),userInfo.getPassword());
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return ErrorCode.SUCCESS;
    }

    private boolean isＤelＦolder(String path) {
        for (int j = 0; j < allFolder.length; j++) {
            if(allFolder[j].getFullName().equals(path)){
                return false;
            }
        }
        return true;
    }
    private boolean isＡddＦolder(String path) {
        if (localＦolders == null){
            return true;
        }
        for (int i = 0; i < localＦolders.size(); i++) {
            if(localＦolders.get(i).getPath().equals(path)){
                return false;
            }
        }
        return true;
    }
    public ErrorMessage folderProce() throws MessagingException {

        Folder defaultFolder = store.getDefaultFolder();
        allFolder = defaultFolder.list();
         localＦolders = mailＰroclogic.getＡllＦolder(userInfo);
         if (localＦolders != null){
             for (int i = 0; i < localＦolders.size(); i++) {
                 if(isＤelＦolder(localＦolders.get(i).getPath())){
                     localtoＤelＦolders.add(localＦolders.get(i));
                 }
             }
         }
        for (int i = 0; i < allFolder.length; i++) {
            if(isＡddＦolder(allFolder[i].getFullName())){
                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setFolderＮame(allFolder[i].getName());
                folderInfo.setPath(allFolder[i].getFullName());
                localtoＡddＦolders.add(folderInfo);
            }
        }
        //对添加和删除的邮件夹分别进行本地处理和jar包处理
        for (FolderInfo folderInfo :localtoＤelＦolders ) {
            mailＰroclogic.delFolder(folderInfo);
            //jar
        }
        for (FolderInfo folderInfo :localtoＡddＦolders ) {
            mailＰroclogic.addFolder(folderInfo);
            //jar
        }
        return ErrorCode.SUCCESS;
    }

    public ErrorMessage mailProce() throws IOException,  MessagingException{
        TaskInfo taskInfo = mailＰroclogic.getTaskInfo();
//        try {
            for (int i = 0; i < allFolder.length; i++) {
//                if (!allFolder[i].getFullName().equals("mytest3")){
//                    continue;))
//                }
                folder = (IMAPFolder)store.getFolder(allFolder[i].getFullName());
                // 使用只读方式打开邮件夹
                folder.open(Folder.READ_WRITE);
//                int size = folder.getMessageCount();
                Message[] messages = folder.getMessages();

                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setFolderＮame(allFolder[i].getName());
                folderInfo.setPath(allFolder[i].getFullName());
                for (int j = 0; j < messages.length; j++) {
//                    Message mimeMessage = messages[j];
                    MailInfo mailInfo = new MailInfo();
                    MimeMessage mimeMessage = (MimeMessage) messages[j];
//                    String from = mimeMessage.getFrom()[0].toString();
//                    String subject = mimeMessage.getSubject();
//                    Date date = mimeMessage.getSentDate();
                    int size = mimeMessage.getSize();
                    Long Uid = folder.getUID(mimeMessage);
                    mailInfo.setPath(allFolder[i].getFullName());
                    mailInfo.setUid(Uid.toString());
                    mailInfo.setUserＮame(userInfo.getFullname());
                    if(mailＰroclogic.mailExist(mailInfo)){
                        continue;
                    }
                    if (taskInfo.getTotal() > taskInfo.getLimt() ){
                        break;
                    }
                    if (taskInfo.getCount() > 0 && size >= taskInfo.getLimt()){
                        continue;
                    }
                    if (taskInfo.getCount() > 0 && (taskInfo.getTotal() + size >= taskInfo.getLimt())){
                        continue;
                    }
                    MimeMessageEx mimeＭessageEx = new MimeMessageEx();
                    mimeＭessageEx.setMimeMessage(mimeMessage);
                    mimeＭessageEx.setMailInfo(mailInfo);
                    mimeＭessageEx.setFolderInfo(folderInfo);
                    tofetchＭails.add(mimeＭessageEx);
                    taskInfo.setCount(taskInfo.getCount()+1);
//                    taskInfo.setFinished(taskInfo.getFinished()+size);
                    taskInfo.setTotal(taskInfo.getTotal()+size);
                    //如何判断出来有没有删除的----当没有要下载的新邮件时，取出本地的所有邮件，与服务器上的进行对比，查找不到代表删除
//                    System.out.println("UID: "  + Uid.toString() +" Subject: " + subject + " Size: " + size + " Date: " + date);
//                    File directory = new File("");//设定为当前文件夹    -------------
//                    String filename = directory.getAbsolutePath() + "/testmail/" + Uid.toString();
//                    File file = new File(filename);
//                    FileOutputStream out = null;
//                    out = new FileOutputStream(file);
////                    MyStream myOut = new MyStream(out);
//
////                        multipart.writeTo(out);
////                    out.write(mimeMessage.getContent().toString().getBytes()); //这样写入的是html内容
//                    mimeMessage.writeTo(out);
//                    if(out != null) {
//                        out.close();
//                    }
//                    if(j >= 10){
//                        break;
//                    }
                }
            }
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return ErrorCode.SUCCESS;
    }

    public ErrorMessage mailbodyFetch() throws IOException,  MessagingException{
        for (MimeMessageEx mimeMessageex : tofetchＭails){
            mailＰroclogic.setFolderInfo(mimeMessageex.getFolderInfo());
            //jar包处理
            File directory = new File("");//设定为当前文件夹    -------------
            String filename = directory.getAbsolutePath() + "/testmail/" +userInfo.getFullname() + "/" + mimeMessageex.getFolderInfo().getFolderＮame()+"/" + mimeMessageex.getMailInfo().getUid().toString();
            File file = new File(filename);
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            CaculateStream out = null;
            out = new CaculateStream(file);
            out.setMailＰroclogic(mailＰroclogic);
//            CaculateStream myOut = new CaculateStream(out);
            mimeMessageex.getMimeMessage().writeTo(out);
            //写完后，要把邮件更新到数据库
            if(out != null) {
                out.close();
            }
            logger.info( mailＰroclogic.getTaskInfo().getProcＦinished() + "/" + mailＰroclogic.getTaskInfo().getTotal());
            mailＰroclogic.addMail(mimeMessageex.getMailInfo());
        }
        return ErrorCode.SUCCESS;
    }

    public ErrorMessage close(){
        try {
            if (folder != null) {
                folder.close(false);
            }
            if (store != null) {
                store.close();
            }
            return ErrorCode.SUCCESS;
        } catch (MessagingException e) {
//            e.printStackTrace();
            logger.error(" clolse " + e.getMessage());
            return ErrorCode.UNKNOWN;
        }
    }

    private boolean existMail(IMAPFolder folder, Message[] messages, MailInfo mailInfo) throws MessagingException{
        for (int j = 0; j < messages.length; j++) {
            MimeMessage mimeMessage = (MimeMessage) messages[j];
            Long Uid = folder.getUID(mimeMessage);
            if (mailInfo.getUid().equals(Uid.toString())){
                return true;
            }
        }
        return false;
    }

    public ErrorMessage clearErase() throws MessagingException{
        if (tofetchＭails.size() <= 0) {
            for (int i = 0; i < allFolder.length; i++) {
                folder = (IMAPFolder)store.getFolder(allFolder[i].getFullName());
                folder.open(Folder.READ_WRITE);
                Message[] messages = folder.getMessages();
                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setPath(folder.getFullName());
                folderInfo.setFolderＮame(folder.getName());
                folderInfo.setUserFullName(userInfo.getFullname());
                List<MailInfo> folderMails = mailＰroclogic.getFolderMails(folderInfo);
                for (MailInfo mailInfo : folderMails){
                    if(!existMail(folder,messages, mailInfo)){
                        localtoＤelMails.add(mailInfo);
                    }
                }
            }
        }
        for (MailInfo mailInfo : localtoＤelMails){
            //jar
            //本地
            mailＰroclogic.delMail(mailInfo);
        }
        return ErrorCode.SUCCESS;
    }
}
