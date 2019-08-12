package kotlins.basic.q31.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Description {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "description_id")
    var id: Long = 0
    var text: String? = null
}