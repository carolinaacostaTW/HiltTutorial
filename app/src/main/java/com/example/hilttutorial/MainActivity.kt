package com.example.hilttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.hilttutorial.database.DatabaseAdapter
import com.example.hilttutorial.database.DatabaseService
import com.example.hilttutorial.hilt.CallInterceptor
import com.example.hilttutorial.network.NetworkAdapter
import com.example.hilttutorial.network.NetworkService
import com.example.hilttutorial.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var databaseAdapter: DatabaseAdapter
//    @Inject lateinit var networkAdapter: NetworkAdapter

    @CallInterceptor
    @Inject lateinit var networkService: NetworkService

    private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Database Adapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        networkService.performNetworkCall()
//        networkAdapter.log("Interface binding")

        statsViewModel.statsLiveData.observe(this) {
            stats -> Log.d(TAG, "New stat coming in: $stats ")
        }
        statsViewModel.startStatsCollection()
    }

    @Inject
    fun directToDatabase(databaseService: DatabaseService){
        databaseService.log("method injection")
    }
}