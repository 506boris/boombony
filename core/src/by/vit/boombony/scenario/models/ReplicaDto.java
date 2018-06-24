package by.vit.boombony.scenario.models;

import java.util.Map;

public class ReplicaDto {
    private ReplicaDto parent;
    private int replicaNumber;
    private int replicaText;
    /**
     * key it is a condition like expected hero answer: Yes - No;
     * Depends on condition we should call next replica;
     */
    private Map<String, ReplicaDto> children;

    public ReplicaDto getParent() {
        return parent;
    }

    public void setParent(ReplicaDto parent) {
        this.parent = parent;
    }

    public int getReplicaNumber() {
        return replicaNumber;
    }

    public void setReplicaNumber(int replicaNumber) {
        this.replicaNumber = replicaNumber;
    }

    public int getReplicaText() {
        return replicaText;
    }

    public void setReplicaText(int replicaText) {
        this.replicaText = replicaText;
    }

    public Map<String, ReplicaDto> getChildren() {
        return children;
    }

    public void setChildren(Map<String, ReplicaDto> children) {
        this.children = children;
    }
}
