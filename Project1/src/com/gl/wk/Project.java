package com.gl.wk;

import java.io.Serializable;

public class Project implements Serializable{

		String projectCode;
		String projectName;
		int projectStrength;
		
		public Project() {
			super();
		}

		public Project(String projectCode, String projectName, int projectStrength) {
			super();
			this.projectCode = projectCode;
			this.projectName = projectName;
			this.projectStrength = projectStrength;
		}

		public String getProjectCode() {
			return projectCode;
		}

		public void setProjectCode(String projectCode) {
			this.projectCode = projectCode;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public int getProjectStrength() {
			return projectStrength;
		}

		public void setProjectStrength(int projectStrength) {
			this.projectStrength = projectStrength;
		}

		@Override
		public String toString() {
			return "Project [projectCode=" + projectCode + ", projectName=" + projectName + ", projectStrength="
					+ projectStrength + "]";
		}
		
		
		
}

