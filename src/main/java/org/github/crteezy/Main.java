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
 *
 */
public class Main {
	
	public static String LANGUAGE_COMBINATION = "Any-Eng"; // Any language to English
	public static String LANGUAGE_COMBINATION_NO_ACCENTS = LANGUAGE_COMBINATION+"; nfd; [:nonspacing mark:] remove; nfc";

	public static void main(String[] args) {

		String originalText = "오늘의 좋은 글";

		try {

			String originalLocale = GoogleTranslate.detectLanguage(originalText);

			System.out.println("Original Locale : " + originalLocale);
			System.out.println("Original Text : " + originalText);
			String unicodeCodes = StringEscapeUtils.escapeJava(originalText);
			System.out.println("Unicode codes : " + unicodeCodes);
			
			
			System.out.println();
			
			// Translator
			System.out.println("Translated : " + GoogleTranslate.translate("en", originalText));

			// Transliterator
			Transliterator transliterator = Transliterator.getInstance(LANGUAGE_COMBINATION);
			String result1 = transliterator.transliterate(originalText);
			System.out.println("Transliterated : " + result1);
			
			Transliterator transliteratorNoAccent = Transliterator.getInstance(LANGUAGE_COMBINATION_NO_ACCENTS);
			String result2 = transliteratorNoAccent.transliterate(originalText);
			System.out.println("Transliterated (no accents) : " + result2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
