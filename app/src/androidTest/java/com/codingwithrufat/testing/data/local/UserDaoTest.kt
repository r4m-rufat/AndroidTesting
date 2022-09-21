package com.codingwithrufat.testing.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.codingwithrufat.testing.TestDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.Throws

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    private lateinit var database: UserDatabase
    private lateinit var dao: UserDao

    @Before
    fun setup() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.userDao()

    }

    @After
    fun teardown() {
        database.close()
    }


    @Test
    @Throws(Exception::class)
    fun insertUser() = runTest {

        val user = UserEntity(1, "Rufat", "Nasirov")
        dao.insertUser(user)

        dao.getAllUsers().test {
            val users = awaitItem()
            assertTrue(users.contains(user))
            cancel()
        }

    }

}