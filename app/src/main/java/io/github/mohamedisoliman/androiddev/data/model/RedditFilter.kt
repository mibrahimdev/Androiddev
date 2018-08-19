package io.github.mohamedisoliman.androiddev.data.model

enum class RedditFilter(val filterValue: String) {
  NEW("new"), HOT("hot"), CONTROVERSIAL("controversial"),
  TOP("top"), RISING("rising");
}
