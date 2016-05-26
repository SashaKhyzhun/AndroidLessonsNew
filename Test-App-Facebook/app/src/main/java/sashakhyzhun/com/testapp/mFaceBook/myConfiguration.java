package sashakhyzhun.com.testapp.mFaceBook;

import com.facebook.FacebookSdk;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebookConfiguration;

public class myConfiguration  {

    static final String APP_ID = "498823913660603";
    Permission[] permissions = new Permission[] { Permission.EMAIL };

    public SimpleFacebookConfiguration getMyConfigs() {
        SimpleFacebookConfiguration configs = new SimpleFacebookConfiguration.Builder()
                .setAppId(APP_ID)
                .setNamespace("Facebook Start")
                .setPermissions(permissions)
                .build();

        return configs;
    }


}
