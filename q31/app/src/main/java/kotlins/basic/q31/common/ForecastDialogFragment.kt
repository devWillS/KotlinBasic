package kotlins.basic.q31.common

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ForecastDialogFragment(
    private val items: Array<CharSequence>,
    private val listener: DialogInterface.OnClickListener
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(context as Context)
        builder.setItems(items,listener)
        return builder.create()
    }
}