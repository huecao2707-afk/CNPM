package git.duynguyen.doancnpm.entity;

public class PoiTranslations {

  private long translationId;
  private long poiId;
  private String languageCode;
  private String translatedTitle;
  private String translatedText;
  private String audioMp3Url;
  private String pipelineStatus;
  private java.sql.Timestamp createdAt;


  public long getTranslationId() {
    return translationId;
  }

  public void setTranslationId(long translationId) {
    this.translationId = translationId;
  }


  public long getPoiId() {
    return poiId;
  }

  public void setPoiId(long poiId) {
    this.poiId = poiId;
  }


  public String getLanguageCode() {
    return languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }


  public String getTranslatedTitle() {
    return translatedTitle;
  }

  public void setTranslatedTitle(String translatedTitle) {
    this.translatedTitle = translatedTitle;
  }


  public String getTranslatedText() {
    return translatedText;
  }

  public void setTranslatedText(String translatedText) {
    this.translatedText = translatedText;
  }


  public String getAudioMp3Url() {
    return audioMp3Url;
  }

  public void setAudioMp3Url(String audioMp3Url) {
    this.audioMp3Url = audioMp3Url;
  }


  public String getPipelineStatus() {
    return pipelineStatus;
  }

  public void setPipelineStatus(String pipelineStatus) {
    this.pipelineStatus = pipelineStatus;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
