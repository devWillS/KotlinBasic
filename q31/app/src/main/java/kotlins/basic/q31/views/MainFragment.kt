package kotlins.basic.q31.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlins.basic.q31.R
import kotlins.basic.q31.common.DividerItemDecoration
import kotlins.basic.q31.models.entities.Forecast
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainContracts.View {

    private lateinit var presenter: MainContracts.Presenter
    private lateinit var adapter : ForecastAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun setPresenter(presenter: MainContracts.Presenter) {
        this.presenter = presenter
    }

    override fun setupView(forecastList: List<Forecast>) {

        adapter = ForecastAdapter(forecastList)

        val llm = LinearLayoutManager(context)
        forecastRecyclerView.addItemDecoration(DividerItemDecoration(context!!))
        forecastRecyclerView.setHasFixedSize(true)
        forecastRecyclerView.layoutManager = llm
        forecastRecyclerView.adapter = adapter
    }

    override fun reloadForecastListData() {
        adapter.notifyDataSetChanged()
    }

    override fun setDescriptionText(text: String) {
        descriptionTextView.text = text
    }
}
