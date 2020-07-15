package com.example.tddtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.runners.MethodSorters

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 순서 설정 : 이름순
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tddtest", appContext.packageName)
    }

    @Test
    fun main_01_typeEmail() {
        onView(withId(R.id.inputEmail)).perform(typeText("test@gmail.com"))
    }

    @Test
    fun main_02_typePassword() {
        onView(withId(R.id.inputPassword)).perform(typeText("!qwer1234"))
    }

    @Test
    fun main_03_submitOK() {
        onView(withId(R.id.inputEmail)).perform(typeText("test@gmail.com"))
        onView(withId(R.id.inputPassword)).perform(typeText("!qwer1234"))
        // 클릭 처리
        onView(withId(R.id.btnSignin)).perform(click())
        // 클릭 후 메시지 확인
        onView(withId(R.id.textMessage)).check(matches(withText("test@gmail.com 으로 로그인 성공!!")))
    }

    @Test
    fun main_04_emptyEmail() {
        onView(withId(R.id.inputPassword)).perform(typeText("!qwer1234"))
        onView(withId(R.id.btnSignin)).perform(click())
        onView(withId(R.id.textMessage)).check(matches(withText("이메일을 입력하세요")))
    }

    @Test
    fun main_05_emptyPassword() {
        onView(withId(R.id.inputEmail)).perform(typeText("test@gmail.com"))
        onView(withId(R.id.btnSignin)).perform(click())
        onView(withId(R.id.textMessage)).check(matches(withText("비밀번호를 입력하세요")))
    }
}