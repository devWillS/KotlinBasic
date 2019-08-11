package kotlins.basic.q25.model.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Todo : RealmObject() {
    @PrimaryKey
    var todo_id: Int = 0
    var todo_title: String = ""
    var todo_contents: String = ""
    var created: Date = Date()
    var modified: Date = Date()
    var limit_date: Date = Date()
    var delete_flg: Boolean = false
}