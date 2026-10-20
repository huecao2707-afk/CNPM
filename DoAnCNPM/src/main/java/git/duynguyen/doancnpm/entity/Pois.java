package git.duynguyen.doancnpm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Pois {
@Id
@GeneratedValue(strategy= GenerationType.UUID)
  private String poiId;
  private String poiNameVi;
  private double latitude;
  private double longitude;
  private double proximityRadius;
  private String thumbnailUrl;
  private String status;
  @CreationTimestamp
  private java.sql.Timestamp createdAt;
  private String historicalPeriod;

  public String getHistoricalPeriod() {
    return historicalPeriod;
  }

  public void setHistoricalPeriod(String historicalPeriod) {
    this.historicalPeriod = historicalPeriod;
  }
  public String getPoiId() {
    return poiId;
  }

  public void setPoiId(String poiId) {
    this.poiId = poiId;
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


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
