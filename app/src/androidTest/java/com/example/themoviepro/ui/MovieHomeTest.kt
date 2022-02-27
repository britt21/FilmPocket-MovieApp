package com.example.themoviepro.ui


import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.example.data.moviedata.Result
import com.example.themoviepro.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.verify
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


@HiltAndroidTest
@MediumTest
class MovieHomeTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
    }



    @Test
    fun test_selected_navigte_toDetail_fragment() {

       val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<MovieHomeFragment>{
            Navigation.setViewNavController(requireView(), navController)

    }
       Thread.sleep(2000)

        onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MovieViewHolder>(
            0, click()
        ))

        verify(navController).navigate(
            MovieHomeFragmentDirections.actionMovieHomeFragmentToMovieDetail()
        )
    }
}