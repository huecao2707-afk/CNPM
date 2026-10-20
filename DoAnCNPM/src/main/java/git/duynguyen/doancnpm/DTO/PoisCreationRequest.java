package git.duynguyen.doancnpm.DTO;

import java.sql.Timestamp;

public class PoisCreationRequest {
    private String poiNameVi;
    private double latitude;
    private double longitude;
    private double proximityRadius;
    private String thumbnailUrl;
    private String status;

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public void setHistoricalPeriod(String historicalPeriod) {
        this.historicalPeriod = historicalPeriod;
    }

    private String historicalPeriod;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public double getProximityRadius() {
        return proximityRadius;
    }

    public void setProximityRadius(double proximityRadius) {
        this.proximityRadius = proximityRadius;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPoiNameVi() {
        return poiNameVi;
    }

    public void setPoiNameVi(String poiNameVi) {
        this.poiNameVi = poiNameVi;
    }

    private java.sql.Timestamp createdAt;

}
