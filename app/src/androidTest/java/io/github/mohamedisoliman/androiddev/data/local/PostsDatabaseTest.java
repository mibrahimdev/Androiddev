package io.github.mohamedisoliman.androiddev.data.local;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.reactivex.observers.TestObserver;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@RunWith(AndroidJUnit4.class)
public class PostsDatabaseTest {

  PostsDatabase database;

  @Before
  public void setUp() {
    database =
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), PostsDatabase.class)
            .build();
  }

  @Test
  public void doNothing() {

  }

  @Test
  public void insert_item_should_retrieve_same_item() {
    String title = "new_item";
    RedditPost post = new RedditPost(0, "", title);
    TestObserver<Void> test = database.insertPosts(Arrays.asList(post)).test();
    test.assertSubscribed();
    test.assertComplete();

    String testTitle = database.getTopPosts().blockingSingle().get(0).getTitle();
    Assert.assertEquals(title, testTitle);
  }
}