package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import photomanager.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void constructorTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2020-10:10");

//		Photo photo2 = new Photo(" ", -10, 10, " ");
//
//		Photo photo3 = new Photo(null, 300, 400, "10/18/2020-17:10");
//
//		System.out.println("Program does not crash");
	}

	@Test
	public void toStringTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2020-10:10");

		Photo photo2 = new Photo("src", 1, 1, "10/18/2021-10:10");

		System.out.println(photo1);
		System.out.println(photo2);
	}

	@Test
	public void getMethodsTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2020-10:10");

		Photo photo2 = new Photo("src", 1, 1, "10/18/2021-10:10");

		System.out.println(photo1.getPhotoSource());
		System.out.println(photo1.getWidth());
		System.out.println(photo1.getHeight());
		System.out.println(photo1.getDate());

		System.out.println(photo2.getPhotoSource());
		System.out.println(photo2.getWidth());
		System.out.println(photo2.getHeight());
		System.out.println(photo2.getDate());
	}

	@Test
	public void CommentsTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2020-10:10");
		photo1.addComments("yur");
		// photo1.addComments(null);
		System.out.println(photo1.getComments());
	}

	@Test
	public void CopyOfPhotoTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2020-10:10");
		Photo photo2 = new Photo(photo1);
		System.out.println(photo1);
		System.out.println(photo2);
	}

	@Test
	public void CompareToTest() {
		Photo photo1 = new Photo("Source", 10, 10, "10/18/2021-10:10");
		Photo photo2 = new Photo("src", 1, 1, "10/18/2020-10:10");
		System.out.println(photo1.compareTo(photo2));

		Photo photo3 = new Photo("Source", 10, 10, "10/18/2009-20:10");
		Photo photo4 = new Photo("src", 1, 1, "09/18/2027-10:10");
		System.out.println(photo3.compareTo(photo4));
	}

	@Test
	public void AddInvalidPhotoTest() {
		PhotoManager photos = new PhotoManager();
		photos.addPhoto(" ", -10, 10, " ");
		photos.addPhoto(null, 300, 400, "10/18/2020-17:10");
		System.out.println("Program does not crash");
	}

	@Test
	public void FindPhotoTest() {
		PhotoManager photos = new PhotoManager();
		photos.addPhoto("Source", 10, 10, "10/18/2020-10:10");
		photos.addPhoto("src", 1, 1, "10/18/2021-10:10");
		System.out.println(photos.findPhoto("DNE"));
		System.out.println(photos.findPhoto("Source"));
		System.out.println(photos.findPhoto("src"));
	}

	@Test
	public void AddPhotoAndToStringTest() {
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "09/17/2020-17:10");
		photoManager.addPhoto("umcp/college8.jpg", 200, 200, "10/18/2020-18:10");
		System.out.println(photoManager);
	}

	@Test
	public void PMCommentTest() {
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("src", 300, 400, "09/17/2020-17:10");
		photoManager.addPhoto("Src", 200, 200, "10/18/2020-18:10");
		photoManager.addComment("src", "ye");
		photoManager.addComment("Src", "yuh");
		System.out.println(photoManager.getComments("src"));
		System.out.println(photoManager.getComments("Src"));
	}

	@Test
	public void removeTest() {
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("src", 300, 400, "09/17/2020-17:10");
		photoManager.addPhoto("Src", 200, 200, "10/18/2020-18:10");
		photoManager.addPhoto("SRC", 300, 400, "09/17/2020-17:10");
		photoManager.removePhoto("Src");
		System.out.println(photoManager);
		photoManager.removeAllPhotos();
		System.out.println("new" + photoManager);
	}

	@Test
	public void sortTest() {
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("SRC", 300, 400, "09/17/2027-17:10");
		photoManager.addPhoto("src", 200, 200, "10/18/2022-18:10");
		photoManager.addPhoto("SrC", 300, 400, "09/17/2021-17:10");
		photoManager.addPhoto("sRC", 300, 400, "09/17/2007-17:10");
		System.out.println(photoManager);
		photoManager.sortPhotosByDate();
		System.out.println(photoManager);
	}

	@Test
	public void loadPhotosTest() {
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("src", 300, 400, "09/17/2020-17:10");
		photoManager.addPhoto("Src", 200, 200, "10/18/2020-18:10");
		photoManager.loadPhotos("photoInfoToLoad.txt");
		System.out.println(photoManager);
	}

}