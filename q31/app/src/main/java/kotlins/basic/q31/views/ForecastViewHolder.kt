package kotlins.basic.q31.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlins.basic.q31.models.entities.Forecast
import kotlinx.android.synthetic.main.forecast_cell.view.*

class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val iconImageView = itemView.iconImageView
    private val dateLabelTextView = itemView.dateLabelTextView
    private val telopTextView = itemView.telopTextView

    fun setForecast(forecast: Forecast) {
        val datelabelText = "${forecast.dateLabel}(${forecast.date})"
        dateLabelTextView.text = datelabelText
        telopTextView.text = forecast.telop

        Glide.with(itemView)
            .load(forecast.image?.url)
            .into(iconImageView)
    }
}