package edu.moral.entity;

/**
 *
 * @author MoralIntegrity
 * @date 2018-01-10
 */
public class MapResult {

    private Integer errcode;

    private String errdetail;

    private String errmsg;

    private MapData data;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrdetail() {
        return errdetail;
    }

    public void setErrdetail(String errdetail) {
        this.errdetail = errdetail;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public MapData getData() {
        return data;
    }

    public void setData(MapData data) {
        this.data = data;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"errcode\":")
                .append(errcode);
        sb.append(",\"errdetail\":\"")
                .append(errdetail).append('\"');
        sb.append(",\"errmsg\":\"")
                .append(errmsg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }
}
