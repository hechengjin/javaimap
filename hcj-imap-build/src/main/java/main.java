import com.mongodb.MongoClientURI;
import common.ErrorCode;
import common.ErrorMessage;
import implement.FetchMailIMAPImpl;
import interfaces.FetchMail;
import model.ProxyInfo;
import model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.io.IOException;

/**
 * Created by hechengjin on 18-1-16.
 */
public class main {
    public static void main(String[] args) throws IOException {
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
//        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClientURI("mongodb://gather:gather123@192.168.134.106:27017/agent_gather"));
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        FetchMail fetchMail = new FetchMailIMAPImpl();
        ErrorMessage errorMessage = fetchMail.fetchMail(userInfo, proxyInfo);
        if(!errorMessage.getCode().equals(ErrorCode.SUCCESS)){
            logger.error("code :{} mesg:{}!", errorMessage.getCode(), errorMessage.getResult());
        }


    }
}
