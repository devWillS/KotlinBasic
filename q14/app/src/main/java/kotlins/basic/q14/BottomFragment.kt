package kotlins.basic.q14


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bottom.*

/**
 * A simple [Fragment] subclass.
 *
 */
class BottomFragment : Fragment(), TextTransferInterface {
    override fun transferText(text: String) {
        text_view.text = text
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }
}
