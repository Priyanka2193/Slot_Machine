package com.priyanka.slotmachine

import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_endgame.*

class EndGameActivity: AppCompatActivity() {
    private lateinit var PointsDB: DatabaseReference
    private var Points:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_endgame)
        PointsDB = FirebaseDatabase.getInstance().getReference("Points")
        Points  = intent?.extras?.getInt("Game Score")!!

        endgame_view.text="Game Score :"+Points.toString()
        val databaserefuser = FirebaseAuth.getInstance().currentUser?.email
        val points = endgame_view.text.toString()

        if (databaserefuser != null) {
            saveMessage(databaserefuser, points)
        }


    }

    private fun saveMessage(sender: String, messageBody: String) {
        val key = PointsDB.push().key
        key ?: return

        val message = Message(sender, messageBody)

        PointsDB.child(key).setValue(message)
    }
}
data class Message(
    var sender: String = "",
    var messageBody: String = "")