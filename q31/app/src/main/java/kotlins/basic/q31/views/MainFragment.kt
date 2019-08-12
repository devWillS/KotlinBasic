package kotlins.basic.q31.views


import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlins.basic.q31.R
import kotlins.basic.q31.common.ForecastDialogFragment
import kotlins.basic.q31.util.guard
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainContracts.View, DialogInterface.OnClickListener {

    private lateinit var presenter: MainContracts.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun setPresenter(presenter: MainContracts.Presenter) {
        this.presenter = presenter
    }

    override fun setupView() {
        button.setOnClickListener {
            val items: Array<CharSequence> = guard(presenter.getItems()) {
                println("DateLabel Error")
            }

            val dialogFragment = ForecastDialogFragment(items, this)
            dialogFragment.show(fragmentManager,"forecast")
        }
    }
    override fun onClick(p0: DialogInterface?, p1: Int) {
        presenter.forecastSelected(p1)
    }
}
