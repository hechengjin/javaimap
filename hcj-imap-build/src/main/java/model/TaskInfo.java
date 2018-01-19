package model;

/**
 * Created by hechengjin on 18-1-18.
 */
public class TaskInfo {
    String userＮame;
    String path;
    String folderＮame;
//    long finished = 0;
    long total = 0;
    long limt = 0;
    int count = 0;
    long procＦinished = 0;
//    long procＴotal = 0;


    public String getUserＮame() {
        return userＮame;
    }

    public void setUserＮame(String userＮame) {
        this.userＮame = userＮame;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFolderＮame() {
        return folderＮame;
    }

    public void setFolderＮame(String folderＮame) {
        this.folderＮame = folderＮame;
    }

//    public long getFinished() {
//        return finished;
//    }
//
//    public void setFinished(long finished) {
//        this.finished = finished;
//    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getLimt() {
        return limt;
    }

    public void setLimt(long limt) {
        this.limt = limt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getProcＦinished() {
        return procＦinished;
    }

    public void setProcＦinished(long procＦinished) {
        this.procＦinished = procＦinished;
    }

//    public long getProcＴotal() {
//        return procＴotal;
//    }
//
//    public void setProcＴotal(long procＴotal) {
//        this.procＴotal = procＴotal;
//    }
}
