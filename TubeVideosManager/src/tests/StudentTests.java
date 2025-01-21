package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tubeVideosManager.Genre;
import tubeVideosManager.Playlist;
import tubeVideosManager.TubeVideosManager;
import tubeVideosManager.Video;

/**
 * 
 * You need student tests if you are asking for help during office hours about
 * bugs in your code. Feel free to use tools available in TestingSupport.java
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void playlistGettersTest() {
		Playlist playlist = new Playlist("Donda");
		System.out.println(playlist.getName());
		playlist.addToPlaylist("Moon");
		playlist.addToPlaylist("Off the grid");
		System.out.println(playlist.getPlaylistVideosTitles());

	}

	@Test
	public void playlistShuffleTest() {
		Playlist playlist = new Playlist("bangers");
		playlist.addToPlaylist("Moon");
		playlist.addToPlaylist("Off the grid");
		playlist.addToPlaylist("Juice");
		playlist.addToPlaylist("Kanye");
		playlist.addToPlaylist("Focus");
		playlist.addToPlaylist("rat");
		System.out.println(playlist.getPlaylistVideosTitles());
		playlist.shuffleVideoTitles(null);
		System.out.println(playlist.getPlaylistVideosTitles());
		playlist.removeFromPlaylistAll("Moon");
		System.out.println(playlist.getPlaylistVideosTitles());
	}

	@Test
	public void playlistRemoveTest() {
		Playlist playlist = new Playlist("Donda");
		playlist.addToPlaylist("Moon");
		playlist.addToPlaylist("Off the grid");
		System.out.println(playlist.getPlaylistVideosTitles());
		playlist.removeFromPlaylistAll("Moon");
		System.out.println(playlist.getPlaylistVideosTitles());
	}

	@Test
	public void playlistCopyConstructorTest() {
		Playlist playlist = new Playlist("Donda");
		playlist.addToPlaylist("Moon");
		playlist.addToPlaylist("Off the grid");
		Playlist playlist2 = new Playlist(playlist);
		playlist.removeFromPlaylistAll("Moon");
		System.out.println(playlist.getPlaylistVideosTitles());
		System.out.println(playlist2.getPlaylistVideosTitles());
	}

	@Test
	public void videoGettersTest() {
		Video movie = new Video("Inception", "dream", 120, Genre.Music);
		movie.addComments("GOAT");
		System.out.println(movie.getComments());
		System.out.println(movie.getDurationInMinutes());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		System.out.println(movie.getGenre());
	}

	@Test
	public void videoCompareToAndEqualsTest() {
		Video movie = new Video("Inception", "dream", 120, Genre.Music);
		Video show = new Video("Attack on titan", "eren", 4, Genre.FilmAnimation);
		System.out.println(movie.compareTo(show));
		System.out.println(movie.equals(show));

		Video movie2 = new Video("Inception", "dream", 120, Genre.Music);
		System.out.println(movie.compareTo(movie2));
		System.out.println(movie.equals(movie2));
	}

	@Test
	public void videoCopyConstructorTest() {
		Video show = new Video("Attack on titan", "eren", 4, Genre.FilmAnimation);
		show.addComments("masterpiece");
		Video aot = new Video(show);
		aot.addComments("armin da goat");
		System.out.println(show.getComments());
		System.out.println(aot.getComments());
	}

	@Test
	public void TubeVideosManagarVideosTest() {
		TubeVideosManager man = new TubeVideosManager();
		man.addVideoToDB("Attack on titan", "eren", 4, Genre.FilmAnimation);
		man.addVideoToDB("Inception", "dream", 120, Genre.Music);
		man.addComments("Inception", "greatness");
		System.out.println(man.getAllVideosInDB());
		System.out.println(man.findVideo("Inception").getComments());

	}

	@Test
	public void TubeVideosManagarPlaylistTest() {
		TubeVideosManager man = new TubeVideosManager();
		man.addPlaylist("Donda");
		System.out.println(man.getPlaylistsNames().toString());

	}

}
