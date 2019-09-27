/**
 * 
 */
package org.github.crteezy;

import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import com.darkprograms.speech.translator.GoogleTranslate;
import com.ibm.icu.text.Transliterator;

/**
 * @author crteezy
 * @since 24-SEP-2019
 */
public class Main {
	
	public static String LANGUAGE_COMBINATION = "Any-Eng"; // Any language to English
	public static String LANGUAGE_COMBINATION_NO_ACCENTS = LANGUAGE_COMBINATION+"; nfd; [:nonspacing mark:] remove; nfc";

	public static void main(String[] args) {

		String originalText = "سامي الغامدي";//오늘의 좋은 글

		try {

			String originalLocale = GoogleTranslate.detectLanguage(originalText);

			System.out.println("Original Locale\t: " + originalLocale);
			System.out.println("Original Text\t: " + originalText);
			String unicodeCodes = StringEscapeUtils.escapeJava(originalText);
			System.out.println("Unicode codes\t: " + unicodeCodes);
			
			
			System.out.println();
			
			// Translator
			System.out.println("Translated\t: " + GoogleTranslate.translate("en", originalText));

			// Transliterator
			Transliterator transliterator = Transliterator.getInstance(LANGUAGE_COMBINATION);
			String result1 = transliterator.transliterate(originalText);
			System.out.println("Transliterated\t: " + result1);
			
			Transliterator transliteratorNoAccent = Transliterator.getInstance(LANGUAGE_COMBINATION_NO_ACCENTS);
			String result2 = transliteratorNoAccent.transliterate(originalText);
			System.out.println("No accents\t: " + result2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
