package org.example.helper;

public class Project {

    private String projectName;
    private String projectIdentifier;
    private boolean taskLimitsApply;
    private int taskLimit;

    public Project(String projectName, String projectIdentifier, boolean taskLimitsApply, int taskLimit) {
        this.projectName = projectName;
        this.projectIdentifier = projectIdentifier;
        this.taskLimitsApply = taskLimitsApply;
        this.taskLimit = taskLimit;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public boolean isTaskLimitsApply() {
        return taskLimitsApply;
    }

    public int getTaskLimit() {
        return taskLimit;
    }

    static public ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public static class ProjectBuilder {
        private String projectName;
        private String projectIdentifier;
        private boolean taskLimitsApply;
        private int taskLimit;

        public ProjectBuilder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public ProjectBuilder projectIdentifier(String projectIdentifier) {
            this.projectIdentifier = projectIdentifier;
            return this;
        }

        public ProjectBuilder taskLimitsApply(boolean taskLimitsApply) {
            this.taskLimitsApply = taskLimitsApply;
            return this;
        }

        public ProjectBuilder taskLimit (int taskLimit) {
            this.taskLimit = taskLimit;
            return this;
        }

        public Project build() {
            if (projectName == null){
                throw new RuntimeException("Project name must not be null");
            }
            return new Project(projectName, projectIdentifier, taskLimitsApply, taskLimit);
        }
    }
}
