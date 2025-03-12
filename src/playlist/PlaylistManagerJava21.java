package playlist;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

class PlaylistManagerJava21 {

  private final SequencedSet<Song> PLAYLIST = new LinkedHashSet<>();

  public void addSong(Song song) {
    PLAYLIST.add(song); // Add a new song at the end
  }

  public void addSongToTop(Song song) {
    PLAYLIST.addFirst(song); // Add the new song at the beginning
  }

  public void removeFirstSong() {
    PLAYLIST.removeFirst(); // Efficiently remove the first song
  }

  public void removeLastSong() {
    PLAYLIST.removeLast(); // Efficiently remove the last song
  }

  public void removeSong(Song song) {
    PLAYLIST.remove(song); // Remove a specific song
  }

  public Song playFirstSong() {
    return PLAYLIST.getFirst(); // Efficiently access the first song without removal
  }

  public Song playLastSong() {
    return PLAYLIST.getLast(); // Efficiently access the last song without removal
  }

  public SequencedSet<Song> revertPlaylist() {return PLAYLIST.reversed();} // Efficiently reverse the playlist
}
