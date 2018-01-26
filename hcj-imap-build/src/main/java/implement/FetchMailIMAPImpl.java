package implement;

import common.ErrorCode;
import common.ErrorMessage;
import interfaces.FetchMail;
import interfaces.FetchMailProcess;
import interfaces.MailProcLogic;
import model.ProxyInfo;
import model.UserInfo;
import org.springframework.stereotype.Component;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import java.io.IOException;

/**
 * Created by hechengjin on 18-1-17.
 */
@Component
public class FetchMailIMAPImpl implements FetchMail {

    FetchMailProcess fetchMail = null;
    MailProcLogic mailＰroclogic = null;
    public ErrorMessage fetchMail(UserInfo userInfo, ProxyInfo proxyInfo) {
        ErrorMessage errorMessage = null;
        mailＰroclogic = new MailProcLogicIMAPMongoImpl();
        fetchMail = new FetchMailIMAPJAVAMailImpl(mailＰroclogic);

        try{
            errorMessage = fetchMail.login(userInfo, proxyInfo);
            if (!errorMessage.equals(ErrorCode.SUCCESS)){
                return errorMessage;
            }
            errorMessage = fetchMail.folderProce();
            if (!errorMessage.equals(ErrorCode.SUCCESS)){
                return errorMessage;
            }
            errorMessage = fetchMail.mailProce();
            if (!errorMessage.equals(ErrorCode.SUCCESS)){
                return errorMessage;
            }
            errorMessage = fetchMail.mailbodyFetch();
            if (!errorMessage.equals(ErrorCode.SUCCESS)){
                return errorMessage;
            }
            errorMessage = fetchMail.clearErase();
            if (!errorMessage.equals(ErrorCode.SUCCESS)){
                return errorMessage;
            }
            return ErrorCode.SUCCESS;
        }  catch (NoSuchProviderException e) {
//            e.printStackTrace();
            ErrorCode.BS_NOSUCHPROVIDEREXCEPTION.setResult(e.getMessage());
            return ErrorCode.BS_NOSUCHPROVIDEREXCEPTION;
        }catch (AuthenticationFailedException e) {
//            e.printStackTrace();
            ErrorCode.BS_AUTHENTICATIONFAILEDEXCEPTION.setResult(e.getMessage());
            return ErrorCode.BS_AUTHENTICATIONFAILEDEXCEPTION;
        }   catch (MessagingException e) {
//            e.printStackTrace();
            ErrorCode.BS_MESSAGINGEXCEPTION.setResult(e.getMessage());
            return ErrorCode.BS_MESSAGINGEXCEPTION;
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            ErrorCode.UNKNOWN.setResult(e.getMessage());
            return ErrorCode.UNKNOWN;
        }
        finally {
            fetchMail.close();
        }
        return ErrorCode.UNKNOWN;

    }
}
