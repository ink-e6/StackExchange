
package com.tz.stackexchange.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "owner",
        "is_answered",
        "creation_date",
        "link",
        "title"
})
public class SimpleItem {

  @JsonProperty("owner")
  private String owner;
  @JsonProperty("is_answered")
  private Boolean isAnswered;
  @JsonProperty("creation_date")
  private String creationDate;
  @JsonProperty("link")
  private String link;
  @JsonProperty("title")
  private String title;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("owner")
  public String getOwner() {
    return owner;
  }

  @JsonProperty("owner")
  public void setOwner(String owner) {
    this.owner = owner;
  }

  @JsonProperty("is_answered")
  public Boolean getIsAnswered() {
    return isAnswered;
  }

  @JsonProperty("is_answered")
  public void setIsAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
  }

  @JsonProperty("creation_date")
  public String getCreationDate() {
    return creationDate;
  }

  @JsonProperty("creation_date")
  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  @JsonProperty("link")
  public String getLink() {
    return link;
  }

  @JsonProperty("link")
  public void setLink(String link) {
    this.link = link;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public SimpleItem(String owner, Boolean isAnswered, String creationDate, String link, String title) {
    this.owner = owner;
    this.isAnswered = isAnswered;
    this.creationDate = creationDate;
    this.link = link;
    this.title = title;
  }
}