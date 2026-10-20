package git.duynguyen.doancnpm.DTO;

public class PoisUpdateRequest {
    private String poiNameVi;
    private double latitude;
    private double longitude;
    private double proximityRadius;
    private String thumbnailUrl;
    private String status;
    private String historicalPeriod;

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public void setHistoricalPeriod(String historicalPeriod) {
        this.historicalPeriod = historicalPeriod;
    }

    public String getPoiNameVi() {
        return poiNameVi;
    }

    public void setPoiNameVi(String poiNameVi) {
        this.poiNameVi = poiNameVi;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getProximityRadius() {
        return proximityRadius;
    }

    public void setProximityRadius(double proximityRadius) {
        this.proximityRadius = proximityRadius;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
