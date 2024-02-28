package com.munirasapplication.app.modules.addingnewtask.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.addingnewtask.data.model.AddingNewTaskModel
import com.munirasapplication.app.modules.addingnewtask.data.model.Task
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity

class AddingNewTaskActivity : AppCompatActivity() {

  private lateinit var etGroupThirteen: EditText
  private lateinit var txtDescription: TextView
  private lateinit var btnSave: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_adding_new_task)

    etGroupThirteen = findViewById(R.id.etGroupThirteen)
    txtDescription = findViewById(R.id.txtDescription)
    btnSave = findViewById(R.id.btnSave)

    btnSave.setOnClickListener {
      saveTaskToFirebase()
    }
  }

  private fun saveTaskToFirebase() {
    val activityName = etGroupThirteen.text.toString().trim()
    val description = txtDescription.text.toString().trim()

    if (activityName.isEmpty() || description.isEmpty()) {
      // code to handle an error listener
      return
    }

    // Created a Task object with user input
    val task = Task(activityName, description)

    // Save the task to Firebase
    val database = FirebaseDatabase.getInstance()
    val tasksRef = database.getReference("tasks")
    val taskId = tasksRef.push().key ?: return
    tasksRef.child(taskId).setValue(task)

    // Optionally, you can also save the AddingNewTaskModel with task details
    // val addingNewTaskModel = AddingNewTaskModel(
    //     etGroupThirteenValue = activityName,
    //     task = task
    // )
    // Save addingNewTaskModel to Firebase or perform any other actions as needed

    // Navigate to the home screen
    navigateToHomeScreen()
  }

  private fun navigateToHomeScreen() {
    val intent = Intent(this, HomescreenActivity::class.java)
    startActivity(intent)
    finish() //  keeping this activity in the back stack
  }

  companion object {
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddingNewTaskActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
