package kotlins.basic.q16

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class TestDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf<CharSequence>("Facebook", "Twitter", "Line")


        val builder = AlertDialog.Builder(context as Context)
        builder.setItems(items) { _, which ->
            when (which) {
                0 -> println("TestDialogFragment: Facebookが押されました。")
                1 -> println("TestDialogFragment: Twitterが押されました。")
                2 -> println("TestDialogFragment: Lineが押されました。")
                else -> {
                }
            }
        }
        return builder.create()
    }
}