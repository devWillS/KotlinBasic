package kotlins.basic.q25.models.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Todo: RealmObject() {
    @PrimaryKey
    var todoId: Int = 1
    var title: String = ""
    var contents: String = ""
    var created: Date = Date()
    var modified: Date = Date()
    var limitDate: Date = Date()
    var deleteFlg: Boolean = false
}