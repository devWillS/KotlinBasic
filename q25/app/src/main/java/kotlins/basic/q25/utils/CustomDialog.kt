package kotlins.basic.q15

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class CustomDialog( mc: Context) {
    // テキスト入力用のダイアログ
    private val mDialog = MyDialog()
    // タイトル
    var dialogTitle : String
        get() {
            return mDialog.mTitle
        }
        set(value) {
            mDialog.mTitle = value
        }
    // メッセージ
    var dialogMessage : String
        get() {
            return mDialog.mMsg
        }
        set(value) {
            mDialog.mMsg = value
        }
    // OK時の処理
    var onOkClickListener : DialogInterface.OnClickListener
        get() {
            // 実際には使用しない
            return DialogInterface.OnClickListener {_, _ -> }
        }
        set(value) {
            mDialog.isOkButton = true
            mDialog.onOkClickListener = value
        }
    // キャンセルボタンの使用
    var isCancelButton : Boolean
        get() {
            return mDialog.isCancelButton
        }
        set(value) {
            mDialog.isCancelButton = value
        }
    // キャンセル時の処理
    var onCancelClickListener : DialogInterface.OnClickListener
        get() {
            // 実際には使用しない
            return DialogInterface.OnClickListener {_, _ -> }
        }
        set(value) {
            mDialog.isCancelButton = true
            mDialog.onCancelClickListener = value
        }
    // ダイアログの表示
    fun openDialog(manager: FragmentManager) {
        mDialog.show( manager,"dialog")
    }
    class MyDialog : DialogFragment() {
        // パラメータ未設定時の基本状態
        var mTitle : String = ""
        var mMsg  : String = ""
        var mTextData : String = ""
        var isOkButton : Boolean = false
        var onOkClickListener      : DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> }
        var isCancelButton : Boolean = false
        var onCancelClickListener : DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> }
        //
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            // 実際は AlertDialog を使用
            val dialogBuilder = AlertDialog.Builder(activity!!)
            // ここで、設定　
            this.isCancelable = false
            if (mTitle.isNotEmpty()) {
                dialogBuilder.setTitle(mTitle)
            } else {
                dialogBuilder.setTitle("dialog")
            }
            if (mMsg.isNotEmpty()) {
                dialogBuilder.setMessage(mMsg)
            }
            if (isOkButton) {
                dialogBuilder.setPositiveButton(getString(android.R.string.ok), onOkClickListener)
            }
            if (isCancelButton) {
                dialogBuilder.setNegativeButton(getString(android.R.string.cancel), onCancelClickListener)
            }
            return dialogBuilder.create()
        }
        // onPause でダイアログを閉じている
        override fun onPause() {
            super.onPause()
            dismiss()
        }
    }
}