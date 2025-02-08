package com.example.f1standings


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
            allOf(
                withId(R.id.home_heading), withText("Next Race"),
                withParent(withParent(withId(R.id.fl_nav_wrapper))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Next Race")))

        val textView2 = onView(
            allOf(
                withId(R.id.next_race_name), withText("Abu Dhabi Grand Prix 2022"),
                withParent(
                    allOf(
                        withId(R.id.next_race_conlay),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Abu Dhabi Grand Prix 2022")))

        val textView3 = onView(
            allOf(
                withId(R.id.next_race_circuit), withText("Yas Marina Circuit"),
                withParent(
                    allOf(
                        withId(R.id.next_race_conlay),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Yas Marina Circuit")))

        val textView4 = onView(
            allOf(
                withId(R.id.top_stories), withText("Top Stories"),
                withParent(withParent(withId(R.id.fl_nav_wrapper))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Top Stories")))

        val textView5 = onView(
            allOf(
                withText("NEWS"),
                withParent(
                    allOf(
                        withId(R.id.first_story),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("NEWS")))

        val textView6 = onView(
            allOf(
                withText("Schumacher and Haas to part ways at the end of 2022"),
                withParent(
                    allOf(
                        withId(R.id.first_story),
                        withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("Schumacher and Haas to part ways at the end of 2022")))
    }
}
