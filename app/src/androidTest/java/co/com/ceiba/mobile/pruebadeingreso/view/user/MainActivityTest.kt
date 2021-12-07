package co.com.ceiba.mobile.pruebadeingreso.view.user


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import co.com.ceiba.mobile.pruebadeingreso.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {

        val editText = onView(
            allOf(
                withId(R.id.editTextSearch),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayoutSearch),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText.perform(click())
        editText.perform(replaceText("test"), closeSoftKeyboard())
        editText.check(matches(withText("test")))
        editText.perform(replaceText(""))
        editText.perform(closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.btn_view_post), withText("Ver publicaciones"),
                childAtPosition(
                    allOf(
                        withId(R.id.contentBtnViewPost),
                        childAtPosition(
                            withId(R.id.contentCard),
                            3
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
