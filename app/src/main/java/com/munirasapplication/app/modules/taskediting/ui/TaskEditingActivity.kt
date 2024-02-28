package com.munirasapplication.app.modules.taskediting.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.munirasapplication.app.R
import android.widget.EditText
import android.widget.Button
import android.widget.ImageView
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity
import com.munirasapplication.app.modules.register.ui.RegisterActivity

class TaskEditingActivity : AppCompatActivity() {

  private lateinit var etGroupFifteen: EditText
  private lateinit var etGroupSeventeen: EditText
  private lateinit var btnSave1: Button
  private lateinit var imageThumbsup: ImageView
  private lateinit var imageHome: ImageView
  private lateinit var imageUser: ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_task_editing)

    etGroupFifteen = findViewById(R.id.etGroupFifteen)
    etGroupSeventeen = findViewById(R.id.etGroupSeventeen)
    btnSave1 = findViewById(R.id.btnSave1)
    imageThumbsup = findViewById(R.id.imageThumbsup)
    imageHome = findViewById(R.id.imageHome)
    imageUser = findViewById(R.id.imageUser)

    // Retrieve task ID from intent extras
    val taskId = intent.getStringExtra("taskId")

    // Fetch task details based on the task ID
    val taskDetails = fetchTaskDetails(taskId)

    // Populate UI element with task details
    populateUI(taskDetails)

    btnSave1.setOnClickListener {
      // TODO: Save the edited task details
      // Navigate back to the home screen after saving
      startActivity(HomescreenActivity.getIntent(this))
      finish()
    }


// will move the user to the register activity
    imageUser.setOnClickListener {
      startActivity(Intent(this, RegisterActivity::class.java))
    }
//it will move the user to the homescreen
    imageHome.setOnClickListener {
      startActivity(Intent(this, HomescreenActivity::class.java))
       }
  }

  // Method to fetch task details based on task ID
  private fun fetchTaskDetails(taskId: String?): TaskDetails {
    // Implement my logic to fetch task details from data source firebase
    // Return data for that task
    return TaskDetails("Task Title", "Task Description")
  }

  // Method to populate UI elements with task details
  private fun populateUI(taskDetails: TaskDetails) {
    etGroupFifteen.setText(taskDetails.title)
    etGroupSeventeen.setText(taskDetails.description)
  }

  companion object {
    fun getIntent(context: Context, taskId: String): Intent {
      val intent = Intent(context, TaskEditingActivity::class.java)
      intent.putExtra("taskId", taskId)
      return intent
    }
  }
}

data class TaskDetails(val title: String, val description: String)
