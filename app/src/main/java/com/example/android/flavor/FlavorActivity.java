/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.flavor;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link FlavorActivity} shows a list of Android platform releases.
 * For each release, display the name, version number, and image.
 */
public class FlavorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Blue Hoodie", "€55", R.drawable.bluehoodie));
        androidFlavors.add(new AndroidFlavor("Black Short Sleeve Hoodie", "€50", R.drawable.blackshortsleevehoodie));
        androidFlavors.add(new AndroidFlavor("Green Hoodie", "€50", R.drawable.greenhoodie));
        androidFlavors.add(new AndroidFlavor("Grey Short Sleeve Hoodie", "€50", R.drawable.greyshortsleeve));
        androidFlavors.add(new AndroidFlavor("Short Sleeve Hoodie", "€45", R.drawable.shortsleevehoodie));
        androidFlavors.add(new AndroidFlavor("White Hoodie", "€45", R.drawable.whitehoodie));
        androidFlavors.add(new AndroidFlavor("White T-Shirt", "€45", R.drawable.whitetshirt));
        androidFlavors.add(new AndroidFlavor("Black Long Sleeve Hoodie", "€45", R.drawable.blacklongsleevehoodie));
        androidFlavors.add(new AndroidFlavor("Sleevless Hoodie", "€30", R.drawable.sleevelesshoodie));
        androidFlavors.add(new AndroidFlavor("Green T-Shirt", "€30", R.drawable.greentshirt));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);

        //Set an setOnItemClickListener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = view.findViewById(R.id.version_name);
                // Display a Toast message indicting the selected item
                Toast.makeText(FlavorActivity.this,
                        textView.getText(), Toast.LENGTH_SHORT).show();
            }

        });

    }

}

