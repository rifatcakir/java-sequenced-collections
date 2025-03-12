package playlist;

public class Main {


  // How effective new changes? ( Playlist Manager )
  public static void main(String[] args) {

    System.out.println("--------------");
    System.out.println("JAVA 17");
    PlaylistManagerJava17 playlistManagerJava17 = new PlaylistManagerJava17();
    playlistManagerJava17.addSong(new Song("A"));
    playlistManagerJava17.addSong(new Song("AB"));
    playlistManagerJava17.addSongToTop(new Song("Z"));
    playlistManagerJava17.removeLastSong();

    playlistManagerJava17.revertPlaylist()
        .forEach(song -> System.out.printf("Song name: %s%n", song.name()));

    System.out.println("--------------");
    System.out.println("JAVA 21");
    PlaylistManagerJava21 playlistManagerJava21 = new PlaylistManagerJava21();

    playlistManagerJava21.addSong(new Song("A"));
    playlistManagerJava21.addSong(new Song("AB"));
    playlistManagerJava21.addSongToTop(new Song("Z"));
    playlistManagerJava21.removeLastSong();

    playlistManagerJava21.revertPlaylist()
        .forEach(song -> System.out.printf("Song name: %s%n", song.name()));
  }
}
