package socialmedia;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class Main {

  private static final SequencedSet<Post> FEED_LIST = new LinkedHashSet<>();

  // What does reversed() return copy or view? ( Social media content ) ?
  public static void main(String[] args) {
    createInitialFeed();

    SequencedSet<Post> chronologicalFeed = FEED_LIST; // original feed
    SequencedSet<Post> reverseChronologicalFeed = FEED_LIST.reversed(); // view of the original feed

    System.out.printf("Are these chronologicalFeed and reverseChronologicalFeed same? %s \n",
        chronologicalFeed == reverseChronologicalFeed.reversed());

    Post newPost = new Post("New Post"); // Create a new post
    chronologicalFeed.addFirst(newPost); // Add the new post at the beginning

    System.out.printf("Does any change on a view affect the original object? %s \n", reverseChronologicalFeed);

  }

  static void createInitialFeed() {
    FEED_LIST.add(new Post("First Post"));
    FEED_LIST.add(new Post("Second Post"));
    FEED_LIST.add(new Post("Third Post"));
    System.out.println("\n");
  }
}
