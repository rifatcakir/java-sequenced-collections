package playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class PlaylistManagerJava17 {

  private final LinkedHashSet<Song> playlist = new LinkedHashSet<>();

  public void addSong(Song song) {
    playlist.add(song); // Add a new song
  }

  public void addSongToTop(Song song) {
    LinkedHashSet<Song> newPlaylist = new LinkedHashSet<>();
    newPlaylist.add(song); // Add the new song
    newPlaylist.addAll(playlist); // Add the existing songs
    playlist.clear();  // Clear the existing playlist
    playlist.addAll(newPlaylist); // Update the playlist
  }

  public void removeFirstSong() {
    if (!playlist.isEmpty()) {
      Iterator<Song> iterator = playlist.iterator();
      iterator.next(); // Manually access the first song
      iterator.remove(); // Remove the first song
    }
  }

  public void removeLastSong() {
    if (!playlist.isEmpty()) {
      Song lastSong = null;
      for (Song song : playlist) {
        lastSong = song; // Iterate to find the last song
      }
      playlist.remove(lastSong); // Remove the last song
    }
  }

  public void removeSong(Song song) {
    playlist.remove(song); // Remove a song
  }

  public Song playFirstSong() {
    if (!playlist.isEmpty()) {
      Iterator<Song> iterator = playlist.iterator();
      return iterator.next(); // Manually access the first song
    }
    return null;
  }

  public Song playLastSong() {
    if (!playlist.isEmpty()) {
      Song lastSong = null;
      for (Song song : playlist) {
        lastSong = song; // Iterate to find the last song
      }
      return lastSong;
    }
    return null;
  }

  public Set<Song> revertPlaylist() {
    List<Song> songList = new ArrayList<>(playlist);
    Collections.reverse(songList); // Reverse the playlist

    return new LinkedHashSet<>(songList); // Return the reversed playlist
  }

}


