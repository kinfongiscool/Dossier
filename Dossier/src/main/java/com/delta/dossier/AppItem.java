package com.delta.dossier;

/**
 * Created by Kin on 8/16/13.
 */
public class AppItem {

    String appName = "";
    String appDescription = "";
    String appPackageName = "";
    String appActivityName = "";

    public AppItem(String appName, String appDescription, String appPackageName, String appActivityName) {
        this.appName = appName;
        this.appDescription = appDescription;
        this.appPackageName = appPackageName;
        this.appActivityName = appActivityName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }
}
