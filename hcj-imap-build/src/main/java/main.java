import common.ErrorCode;
import common.ErrorMessage;
import implement.FetchMailIMAP;
import interfaces.IFetchMail;
import model.ProxyInfo;
import model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hechengjin on 18-1-16.
 */
public class main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("mail");
        System.out.println("main started!");
        logger.info("main started!");
        UserInfo userInfo = new UserInfo();
        userInfo.setSsl(true);
        userInfo.setPort(993);//143
        userInfo.setProtocol("imap");
        userInfo.setHost("imap.126.com");
        userInfo.setFullname("kso_test@126.com");
        userInfo.setPassword("xiaoyingxilu33");
        ProxyInfo proxyInfo = new ProxyInfo();
        IFetchMail fetchMail = new FetchMailIMAP();
        ErrorMessage errorMessage = fetchMail.fetchMail(userInfo, proxyInfo);
        if(!errorMessage.getCode().equals(ErrorCode.SUCCESS)){
            logger.error("code :{} mesg:{}!", errorMessage.getCode(), errorMessage.getResult());
        }


    }
}
