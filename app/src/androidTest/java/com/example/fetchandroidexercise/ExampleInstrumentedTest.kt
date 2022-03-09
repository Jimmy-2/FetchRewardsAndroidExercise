package com.example.fetchandroidexercise

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fetchandroidexercise.ui.name.FetchNamesFragment
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest: BaseInstrumentalTest() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun isNamesListVisible() {
        onView(withId(R.id.names_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFirst4Items() {
        launchFragmentInContainer<FetchNamesFragment>(themeResId = R.style.Theme_FetchAndroidExercise)
        waitForView(ViewMatchers.withText("Item 0")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        waitForView(ViewMatchers.withText("Item 101")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        waitForView(ViewMatchers.withText("Item 110")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        waitForView(ViewMatchers.withText("Item 136")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }




    @Test
    fun scroll_to_item() {
        launchFragmentInContainer<FetchNamesFragment>(themeResId = R.style.Theme_FetchAndroidExercise)
        Espresso.onView(withId(R.id.names_list)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(20))

        waitForView(ViewMatchers.withText("Item 196")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }


}