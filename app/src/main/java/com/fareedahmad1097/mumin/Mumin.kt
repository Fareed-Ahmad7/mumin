package com.fareedahmad1097.mumin

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.res.Resources
import android.widget.RemoteViews
import androidx.annotation.RawRes
import java.io.File
import java.io.RandomAccessFile

/**
 * Implementation of App Widget functionality.
 */
class Mumin : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}



internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
//    val message = "salaam"
//    var message = File("reminders.txt").readLines().random()
//    var message = File("reminders.txt").readLines().random()
//    var file = File("/reminders.txt")
//    var message = RandomAccessFile("/reminders.txt", "r")
//    println(message)
//    val widgetText = message

    val array = context.resources.getStringArray(R.array.planets_array)
//    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.mumin)
    views.setTextViewText(R.id.appwidget_text, array.random())

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}