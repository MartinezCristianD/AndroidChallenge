package co.com.ceiba.mobile.pruebadeingreso.view.user


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
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
import org.hamcrest.core.IsInstanceOf
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
        val appCompatEditText = onView(
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
        appCompatEditText.perform(replaceText("c"), closeSoftKeyboard())

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
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
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
        appCompatButton2.perform(click())

        pressBack()

        pressBack()

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextSearch), withText("c"),
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
        appCompatEditText2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editTextSearch), withText("c"),
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
        appCompatEditText3.perform(replaceText(""))

        val appCompatEditText4 = onView(
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
        appCompatEditText4.perform(closeSoftKeyboard())

        val textView = onView(
            allOf(
                withId(R.id.textinput_placeholder),
                withParent(withParent(withId(R.id.textInputLayoutSearch))),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.textinput_placeholder),
                withParent(withParent(withId(R.id.textInputLayoutSearch))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("c")))

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerViewSearchResults),
                withParent(
                    allOf(
                        withId(R.id.content),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.btn_view_post), withText("VER PUBLICACIONES"),
                withParent(
                    allOf(
                        withId(R.id.contentBtnViewPost),
                        withParent(withId(R.id.contentCard))
                    )
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))
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
