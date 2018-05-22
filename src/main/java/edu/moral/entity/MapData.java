package edu.moral.entity;

import java.util.List;

/**
 *
 * @author MoralIntegrity
 * @date 2018-01-10
 */
public class MapData {

    private String origin;

    private String destination;

    private List<MapPlan> paths;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<MapPlan> getPaths() {
        return paths;
    }

    public void setPaths(List<MapPlan> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"origin\":\"")
                .append(origin).append('\"');
        sb.append(",\"destination\":\"")
                .append(destination).append('\"');
        sb.append(",\"paths\":")
                .append(paths);
        sb.append('}');
        return sb.toString();
    }
}
