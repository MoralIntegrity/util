package edu.moral.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 * @author MoralIntegrity
 * @date 2018-01-10
 */
public class MapPlan {


    private Double distance;

    private Long duration;

    private List<PlanStep> steps;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<PlanStep> getSteps() {
        return steps;
    }

    public void setSteps(List<PlanStep> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"distance\":")
                .append(distance);
        sb.append(",\"duration\":")
                .append(duration);
        sb.append(",\"steps\":")
                .append(steps);
        sb.append('}');
        return sb.toString();
    }

    private class PlanStep {

        private String instruction;
        private String road;
        private Double distance;
        private String orientation;
        private Long duration;
        private String polyline;
        private String action;

        @JsonProperty("assistant_action")
        private String assistantAction;

        public String getInstruction() {
            return instruction;
        }

        public void setInstruction(String instruction) {
            this.instruction = instruction;
        }

        public String getRoad() {
            return road;
        }

        public void setRoad(String road) {
            this.road = road;
        }

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public Long getDuration() {
            return duration;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }

        public String getPolyline() {
            return polyline;
        }

        public void setPolyline(String polyline) {
            this.polyline = polyline;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getAssistantAction() {
            return assistantAction;
        }

        public void setAssistantAction(String assistantAction) {
            this.assistantAction = assistantAction;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"instruction\":\"")
                    .append(instruction).append('\"');
            sb.append(",\"road\":\"")
                    .append(road).append('\"');
            sb.append(",\"distance\":")
                    .append(distance);
            sb.append(",\"orientation\":\"")
                    .append(orientation).append('\"');
            sb.append(",\"duration\":")
                    .append(duration);
            sb.append(",\"polyline\":\"")
                    .append(polyline).append('\"');
            sb.append(",\"action\":\"")
                    .append(action).append('\"');
            sb.append(",\"assistantAction\":\"")
                    .append(assistantAction).append('\"');
            sb.append('}');
            return sb.toString();
        }
    }
}
