package com.example.themoviepro

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.hamcrest.Description
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runners.model.Statement

//@ExperimentalCoroutinesApi
//class TestCoroutineRule(
//
//    private val dispatcher : CoroutineDispatcher = TestCoroutineDispatcher()
//
//): TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher){
//
//    override fun starting(description: org.junit.runner.Description?) {
//        super.starting(description)
//        Dispatchers.setMain(dispatcher)
//    }
//
//    override fun finished(description: org.junit.runner.Description?) {
//        super.finished(description)
//        cleanupTestCoroutines()
//        Dispatchers.resetMain()
//    }
//}
