package com.svitlana_karapuhina.core.constants;

import com.svitlana_karapuhina.core.utils.CommonUtils;

import java.time.Duration;

import static com.svitlana_karapuhina.core.constants.Constants.DriverType.ANDROID;
import static com.svitlana_karapuhina.core.constants.Constants.DriverType.IOS;

public class Constants {
    public final static String TEST_PLATFORM = CommonUtils.getCentralData("PlatformName").toUpperCase();
    public final static Duration IMPLICIT_WAIT = Duration.ofSeconds(0);
    public final static boolean IS_IOS = TEST_PLATFORM.equals(IOS.toString());
    public final static boolean IS_ANDROID = TEST_PLATFORM.equals(ANDROID.toString());

    public enum DriverType {
        ANDROID,
        IOS
    }
}
