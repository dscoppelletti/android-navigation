/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.example.android.codelabs.navigation

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

/**
 * App Widget that deep links you to the [DeepLinkFragment].
 */
class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    /* DOC STEP 10
    Navigation components also include deep link support. Deep links are a way
    to jump into the middle of your app's navigation, whether that's from an
    actual URL link or a pending intent from a notification.
    One benefit of using the navigation library to handle deep links is that it
    ensures users start on the right destination with the appropriate back stack
    from other entry points such as app widgets, notifications, or web links
    (covered in the next step).

    Navigation provides a NavDeepLinkBuilder class to construct a PendingIntent
    that will take the user to a specific destination.

    The backstack for a deep link is determined using the navigation graph you
    pass in. If the explicit Activity you've chosen has a parent activity, those
    parent Activities are also included.

    The backstack is generated using the destinations specified with
    app:startDestination. In this app we only have one activity and one level of
    navigation, so the backstack will take you to the home_dest destination.

    More complicated navigation can include nested navigation graphs. The
    app:startDestination at each level of the nested graphs determines the
    backstack.
    DOC END STEP 10 */

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(
            context.packageName,
            R.layout.deep_link_appwidget
        )

        val args = Bundle()
        args.putString("myarg", "From Widget")

        /* DOC STEP 10
        We'll use the NavDeepLinkBuilder to hook up an app widget to a
        destination.

        . setGraph includes the navigation graph.
        . setDestination specifies where the link goes to.
        . setArguments includes any arguments you want to pass into your deep
        link.

        By default NavDeepLinkBuilder will start your launcher Activity. You can
        override this behavior by passing in an activity as the context or set
        an explicit activity class via setComponentName().
        DOC END STEP 10 */

        // TODO Step 10 - construct and set a PendingIntent using DeepLinkBuilder
        val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.mobile_navigation)
                .setDestination(R.id.deeplink_dest)
                .setArguments(args)
                .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.deep_link_button, pendingIntent)
        // TODO END STEP 10

        /* DOC STEP 10
        As a convenience, you can also call NavController's createDeepLink()
        method that returns a NavDeepLinkBuilder to use the Context and current
        navigation graph from the NavController.
        DOC END STEP 10  */

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}
