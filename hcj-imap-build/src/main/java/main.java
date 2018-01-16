import implement.FetchMailJAVAMailImpl;
import interfaces.IFetchMail;
import model.UserInfo;

/**
 * Created by hechengjin on 18-1-16.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("main started!");
        UserInfo userInfo = new UserInfo();
        userInfo.setSsl(true);
        userInfo.setPort(993);//143
        userInfo.setProtocol("imap");
        userInfo.setHost("imap.126.com");
        userInfo.setFullname("test@126.com");
        userInfo.setPassword("test");
        IFetchMail fetchMail = new FetchMailJAVAMailImpl();
        fetchMail.login(userInfo);
        fetchMail.folderProce();
        fetchMail.mailProce();

        fetchMail.close();


    }
}
