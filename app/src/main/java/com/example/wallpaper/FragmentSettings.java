package com.example.wallpaper;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class FragmentSettings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.settings,rootKey);
    }
}
