/*
 * Copyright (C) 2012-2014 Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.darkslide;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.UserHandle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.provider.Settings;

import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class LockscreenInterface extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String LOCKSCREEN_GENERAL_CATEGORY = "lockscreen_general_category";
    private static final String LOCKSCREEN_WIDGETS_CATEGORY = "lockscreen_widgets_category";
    private static final String KEY_LOCK_CLOCK = "lock_clock";

    private ChooseLockSettingsHelper mChooseLockSettingsHelper;
    private LockPatternUtils mLockUtils;
    private DevicePolicyManager mDPM;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.lockscreen_interface_settings);

        mChooseLockSettingsHelper = new ChooseLockSettingsHelper(getActivity());
        mLockUtils = mChooseLockSettingsHelper.utils();
        mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        // Find categories
        PreferenceCategory generalCategory = (PreferenceCategory)
                findPreference(LOCKSCREEN_GENERAL_CATEGORY);
        PreferenceCategory widgetsCategory = (PreferenceCategory)
                findPreference(LOCKSCREEN_WIDGETS_CATEGORY);
        // Remove cLock settings item if not installed
        if (!isPackageInstalled("com.darkslide.lockclock")) {
            widgetsCategory.removePreference(findPreference(KEY_LOCK_CLOCK));
        }

    }
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        final String key = preference.getKey();
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        ContentResolver cr = getActivity().getContentResolver();


        return false;
    }

}
