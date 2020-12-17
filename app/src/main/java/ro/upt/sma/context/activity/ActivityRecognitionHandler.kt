package ro.upt.sma.context.activity

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityRecognitionClient

class ActivityRecognitionHandler(context: Context) {

    private val client: ActivityRecognitionClient = ActivityRecognition.getClient(context)
    private val context = context
    private val intent = Intent(context, ActivityRecognitionService::class.java)

    fun registerPendingIntent(): PendingIntent {

        // TODO 5: Create a pending intent for ActivityRecognitionService and register for updates to activity recognition client.
        val pendingIntent = PendingIntent.getService(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        client.requestActivityUpdates(100000, pendingIntent)
        return pendingIntent
        return null!!
    }

    fun unregisterPendingIntent(pendingIntent: PendingIntent) {
        client.removeActivityUpdates(pendingIntent)
    }

}
