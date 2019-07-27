package kotlins.basic.q2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // ArrayList
        var arrayList: ArrayList<String> = arrayListOf("りんご", "みかん", "バナナ")

        println(arrayList)

        arrayList.add("スイカ")
        arrayList.add("メロン")
        arrayList.add("いちご")

        println(arrayList)

        // HashMap
        var hashMap: HashMap<String, Int> = hashMapOf("one" to 1, "two" to 2, "three" to 3)

        println(hashMap)

        hashMap["four"] = 4
        hashMap["one"] = 0

        println(hashMap)

        // HashSet
        var hashSet: HashSet<Int> = hashSetOf(1, 2, 3)

        println(hashSet)

        hashSet.add(4)
        hashSet.add(5)
        hashSet.add(6)

        println(hashSet)
    }
}
