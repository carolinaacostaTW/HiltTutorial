package com.example.hilttutorial.database

import android.util.Log
import com.example.hilttutorial.TAG
import javax.inject.Inject

class DatabaseService @Inject constructor() {

    fun log(message: String){
        Log.d(TAG, "Database Service message: $message")
    }
}