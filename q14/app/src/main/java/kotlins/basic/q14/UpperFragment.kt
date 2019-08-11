package kotlins.basic.q14


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_upper.*

/**
 * A simple [Fragment] subclass.
 *
 */
class UpperFragment : Fragment() {
    private lateinit var textTransferInterface: TextTransferInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        button.setOnClickListener {
            val text = editText.text.toString()
            textTransferInterface.transferText(text)
        }
    }

    fun setInterface(textTransferInterface: TextTransferInterface) {
        this.textTransferInterface = textTransferInterface
    }
}
