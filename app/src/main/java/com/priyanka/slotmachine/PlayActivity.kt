package com.priyanka.slotmachine



import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_play.*


class PlayActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        login_button.setOnClickListener {
            startActivity(AuthActivity.newIntent(AuthMode.Login, this))
        }

        register_button.setOnClickListener {
            startActivity(AuthActivity.newIntent(AuthMode.Register, this))
        }
    }
}

sealed class AuthMode() : Parcelable {
    @Parcelize
    object Login : AuthMode()

    @Parcelize
    object Register : AuthMode()
}