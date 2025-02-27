package com.hao_xiao_zi.mybatis.pojo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-27
 * Time: 21:17
 */
public class Log {
    private Integer id;
    private String log;
    private String time;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", log='" + log + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Log(Integer id, String log, String time) {
        this.id = id;
        this.log = log;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
