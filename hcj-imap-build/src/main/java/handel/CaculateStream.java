package handel;

import interfaces.MailProcLogic;

import java.io.*;

/**
 * Created by hechengjin on 18-1-19.
 */
public class CaculateStream extends FileOutputStream {
    MailProcLogic mailＰroclogic = null;

    public MailProcLogic getMailＰroclogic() {
        return mailＰroclogic;
    }

    public void setMailＰroclogic(MailProcLogic mailＰroclogic) {
        this.mailＰroclogic = mailＰroclogic;
    }

    public CaculateStream(String name) throws FileNotFoundException {
        super(name);
    }

    public CaculateStream(String name, boolean append) throws FileNotFoundException {
        super(name, append);
    }

    public CaculateStream(File file) throws FileNotFoundException {
        super(file);
    }

    public CaculateStream(File file, boolean append) throws FileNotFoundException {
        super(file, append);
    }

    public CaculateStream(FileDescriptor fdObj) {
        super(fdObj);
    }


    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        mailＰroclogic.getTaskInfo().setProcＦinished(mailＰroclogic.getTaskInfo().getProcＦinished() + len);
        super.write(b, off, len);
    }
}
