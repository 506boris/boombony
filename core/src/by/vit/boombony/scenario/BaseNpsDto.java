package by.vit.boombony.scenario;

import by.vit.boombony.helpers.Coo;

public abstract class BaseNpsDto {
    private String name;
    private String description;
    private Coo startPosition;
    private String mapTextureName;
    private String bigTextureName;
    private ReplicaDto replicaDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coo getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Coo startPosition) {
        this.startPosition = startPosition;
    }

    public String getMapTextureName() {
        return mapTextureName;
    }

    public void setMapTextureName(String mapTextureName) {
        this.mapTextureName = mapTextureName;
    }

    public String getBigTextureName() {
        return bigTextureName;
    }

    public void setBigTextureName(String bigTextureName) {
        this.bigTextureName = bigTextureName;
    }

    public ReplicaDto getReplicaDto() {
        return replicaDto;
    }

    public void setReplicaDto(ReplicaDto replicaDto) {
        this.replicaDto = replicaDto;
    }
}
