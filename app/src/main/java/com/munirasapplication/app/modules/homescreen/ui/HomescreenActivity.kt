package com.munirasapplication.app.modules.homescreen.ui
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.addingnewtask.ui.AddingNewTaskActivity
import com.munirasapplication.app.modules.taskediting.ui.TaskEditingActivity

class HomescreenActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_homescreen)

    //creating my object for the button to move
    //user to adding new task activity
    val txtDentistappoint: TextView = findViewById(R.id.txtDentistappoint)
    val btnNewTask2: Button = findViewById(R.id.btnNewTask2)


// 1. move the user to the adding task activity
    txtDentistappoint.setOnClickListener {
      val intent = Intent(this, AddingNewTaskActivity::class.java)
      startActivity(intent)
    }

    // handle logic  task from firebase
    txtDentistappoint.setOnClickListener {
      // i will Replace "taskId" with the actual task ID of the clicked task
      val taskId = "your_task_id_here"

      val intent = TaskEditingActivity.getIntent(this, taskId)
      startActivity(intent)
    }
  }

  companion object {
    fun getIntent(context: Context): Intent {
      return Intent(context, HomescreenActivity::class.java)
    }
  }
}
