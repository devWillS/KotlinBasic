package kotlins.basic.q31.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlins.basic.q31.R
import kotlins.basic.q31.models.entities.Forecast

class ForecastAdapter(
    private val forecastList: List<Forecast>
) : RecyclerView.Adapter<ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_cell, parent, false))
    }

    override fun getItemCount(): Int {
         return forecastList.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.setForecast(forecastList[position])
    }

}