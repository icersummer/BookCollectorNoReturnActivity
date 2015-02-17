package com.vjia.bookcollector.isbn;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;

import com.vjia.bookcollector.pojo.BookEntity;
import com.vjia.bookcollector.util.CsvWriterUtil;
import com.vjia.bookcollector.util.FileWriterUtil;


public class IsbnFileUtils {

	/*
	 * java 7, has a java.beans.PropertyDescriptor
	 */
	
	/**
	 * refer : http://docs.oracle.com/javase/tutorial/reflect/member/fieldValues.html
	 * @param xml
	 */
	public static void testReflect(String xml) {
		String aname = "author"; // attribute name
		String newValue = "test value" ;
		
		BookEntity book = new BookEntity();
		book.setAuthor("xyz");
		try {
			Class<?> c = book.getClass();
			Field field = c.getDeclaredField(aname);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			System.out.println("1="+field.get(book));
			field.set(book,newValue);
			System.out.println("2="+field.get(book));	
			field.setAccessible(accessible);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void generateResultInTextInDisk(String xml) {
		// TODO Auto-generated method stub
		BookEntity book = extractBookInfo(xml);
		
		String fileName = FileWriterUtil.createAndPersisteFile(book);
		
		// return a FLAG, and to prompt user of : success
		//TODO
	}
	

	/**
	 * @param xml
	 * @param bookInfoActivity 
	 * @return generate csv name
	 */
	public static String generateResultInCsvInDisk(String xml, Activity activity) {
		// TODO Auto-generated method stub
		BookEntity book = extractBookInfo(xml);
		
		String fileName = CsvWriterUtil.createAndPersisteFile(book, activity);
		
		// return a FLAG, and to prompt user of : success
		//TODO
		return fileName;
	}
	
	private static BookEntity extractBookInfo(String xml) {
		// TODO Auto-generated method stub
		BookEntity book = new BookEntity();
		book.setAuthor("Mark Twin");
		book.setIsbn13("909090909765");
		book.setLink("http://google.com/vj");
		book.setPrice("$100");
		
		return book;
	}
	
	public static void main(String[] args) {
		IsbnFileUtils main = new IsbnFileUtils();
		main.testReflect("");
	}

}
