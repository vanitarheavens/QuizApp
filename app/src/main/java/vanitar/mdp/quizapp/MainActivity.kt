package vanitar.mdp.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import vanitar.mdp.quizapp.databinding.ActivityMainBinding
import vanitar.mdp.quizapp.R
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var one = findViewById<RadioButton>(R.id.one);
        var two = findViewById<RadioButton>(R.id.two);
        var three = findViewById<RadioButton>(R.id.three);

        var kampala = findViewById<CheckBox>(R.id.kampala);
        var minnesota = findViewById<CheckBox>(R.id.minnesota);
        var iowa = findViewById<CheckBox>(R.id.iowa);

        val rg = findViewById<RadioGroup>(R.id.rg);
        val sub = findViewById<Button>(R.id.btnSub);
        val cancel = findViewById<Button>(R.id.reset);

        var totalMark=0;


        cancel.setOnClickListener {
            rg.clearCheck();
            kampala.isChecked=false
            minnesota.isChecked=false
            iowa.isChecked=false
            totalMark=0;

        }


        sub.setOnClickListener {



            val selectedOption: Int = rg!!.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedOption)
            var number: String = radioButton.text.toString();
            if(number.equals("Two")){
                totalMark= totalMark+50;
            }

            if(one!!.isChecked){
                totalMark= totalMark+0;
            }
            if(two.isChecked){
                totalMark= totalMark+25;
            }
            if(three.isChecked){
                totalMark= totalMark+25;
            }

            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Quiz Results as at "+ LocalDate.now().toString())
            builder.setMessage("Congulatulations you scored "+totalMark+" %")


            builder.setPositiveButton("Yes"){
                    dialogInterface, which ->
                dialogInterface.dismiss()
                totalMark=0;
                finish()
            }

            builder.setNegativeButton("Cancel"){
                    dialogInterface, which ->
                totalMark=0;
                dialogInterface.dismiss()
            }

            val dialog: AlertDialog = builder.create();
            dialog.show();
        }

    }
}