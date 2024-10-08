package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
@ConfigurationProperties(prefix = "info.app1")
public class ProjectInfo {

	private String name;
	private String id;
	private String version;
	private String createdBy;
	private String stable;
	private String team_name;
	private String size;
	private String vendor;
}
