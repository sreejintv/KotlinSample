package ae.farabi.test

import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.parcel.Parcelize

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            onButtonClick("")
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        text.setOnClickListener{
            text.setText("U clicked here....")
        }


        //Handler hand = new Handler()


        text.setOnLongClickListener {
            text.text.toString().equals("U clicked here....", true)
            text.setText("U Long clicked here....")
            text.setText("U Long clicked here....")

            text.setText("U Long clicked here....")
            true;
        }
    }

    /**
     * USefull Operators.
     */
    private fun demoNullChecks(str : String) : Boolean{

        var length = str?.length  //  null safety check
        length = str?.length ?: 0   // pass left value for null... pass right on non null cases

        length = str!!.length // no null checks... beleiving str will not be null in any case
        return true

    }

    private fun demoExpressions(valueFirst : Any, valueSecond: Int) : Boolean {

        // Instance Of -> is
        // IF expression
        if(valueFirst is Int && valueFirst > valueSecond) true else false

        // Switch case removed with when
        when(valueFirst) {

            // Each cases
            1 -> true
            10 -> false
            is Boolean -> true
            // last case
            else -> false;

        }

        // Check the Ranges
        for (valueFirst in 1..100)
            return true

        // DownTo
        for (number in 100 downTo 1)
            print(number)

        // Loop From 100 to 1 with +5 next item
        for (i in 100 downTo 1 step 5) {
            println(i)
        }

        return true
    }

    // Parcelable
    @Parcelize
    data class PersonParcelize(val name: String,
                               val age: Int,
                               val email: String,
                               val phone: Long) : Parcelable


    private  fun  demoDataClasses(){

        data class Person(var name : String, val email : String , var age : Int)

        var   per1 : Person =  Person("","",10)

        per1.name = "khfkshfsd"
        data class PersonWithValue(val name :  String = "Man" , val email : String = "man@universe.com" , val age : Int= 26 )
        val   per21 : PersonWithValue =  PersonWithValue()

        val strr : String = per21.email
        per1.age = 30;

        // Copy of person data with passing one value
        val personData :  Person = per1.copy(name = "heeelloo")

    }

    private fun onButtonClick(str : String) : Boolean{

        text.setText("helloooo")
        if(str.equals("")){
            return false;
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
