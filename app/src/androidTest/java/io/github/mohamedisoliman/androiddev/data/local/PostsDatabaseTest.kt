package io.github.mohamedisoliman.androiddev.data.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Arrays

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@RunWith(AndroidJUnit4::class)
class PostsDatabaseTest {

  private lateinit var database: PostsDatabase

  @Before
  fun setUp() {
    database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
        PostsDatabase::class.java)
        .build()
  }

  @Test
  fun doNothing() {

  }

  @Test
  fun insert_item_should_retrieve_same_item() {
    val title = "new_item"
    val post = RedditPost(0, "", title)
    val test = database.insertPosts(Arrays.asList(post)).test()
    test.assertSubscribed()
    test.assertComplete()

    val testTitle = database.getTopPosts().blockingSingle()[0].title
    Assert.assertEquals(title, testTitle)
  }
}