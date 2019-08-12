package kotlins.basic.q31.models.db

import androidx.room.TypeConverter
import kotlins.basic.q31.models.entities.Image

class ImageTypeConverter {
    @TypeConverter
    fun toUrl(image: Image?): String? {
        return image?.url
    }

    @TypeConverter
    fun toImage(url: String?): Image? {
        if (url == null) {
            return null
        }
        val image = Image()
        image.url = url
        return image
    }
}