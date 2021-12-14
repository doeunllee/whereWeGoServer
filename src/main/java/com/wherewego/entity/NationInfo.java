package com.wherewego.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "nation_info")
public class NationInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nation_info_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "continent_id")
  private Continent continent; //대륙id(fk)

  @Column
  private String nationName; //나라명

  @Column
  private String introduce; //소개

  @Column
  private String quarantinePolicy; //방역방침

  @Column
  private String imageUrl; //이미지

  @Builder
  public NationInfo(Continent continent, String nationName, String introduce,
      String quarantinePolicy, String imageUrl) {
    this.continent = continent;
    this.nationName = nationName;
    this.introduce = introduce;
    this.quarantinePolicy = quarantinePolicy;
    this.imageUrl = imageUrl;
  }
}