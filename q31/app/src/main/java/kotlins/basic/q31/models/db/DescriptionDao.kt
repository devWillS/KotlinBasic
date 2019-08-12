package kotlins.basic.q31.models.db

import androidx.room.*
import kotlins.basic.q31.models.entities.Description

@Dao
interface DescriptionDao {
    @Query("SELECT description_id,text FROM Description")
    fun getNewest(): Description

    @Insert
    fun insertEntity(descriptionEntity: Description)

    @Query("DELETE FROM Description")
    fun deleteALL()
}