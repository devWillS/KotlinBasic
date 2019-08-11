package kotlins.basic.q15

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity

object AlertDialogUtil {
    interface DialogUtilListener {
        fun onPositive()
        fun onNegative()
    }

    fun createDialog(activity: AppCompatActivity, title: Int, messageId: Int, listener: DialogUtilListener?) {
        val customDialog = CustomDialog(activity)
        customDialog.dialogTitle = activity.getString(title)
        customDialog.dialogMessage = activity.getString(messageId)
        customDialog.isCancelButton = true
        customDialog.onOkClickListener = DialogInterface.OnClickListener { _, _ ->
            listener?.onPositive()
        }
        customDialog.onCancelClickListener = DialogInterface.OnClickListener { _, _ ->
            listener?.onNegative()
        }
        customDialog.openDialog(activity.supportFragmentManager)
    }
}