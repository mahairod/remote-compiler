/*
 * Авторские права ↄ⃝ 2015, Антон Астафьев Ѱ҃
 *
 * Этот код — свободное программное обеспечение. Вы можете распространять и/или изменять его
 * при условии соблюдения положений Универсальной общественной лицензии GNU только 2-й версии, как
 * опубликовано Фондом Свободных Программ.
 *
 * Этот код распространяется с надеждой на то, что он будет полезен,
 * но БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ, даже без подразумеваемой гарантии КОММЕРЧЕСКОЙ ЦЕННОСТИ или
 * СООТВЕТСТВИЯ КОНКРЕТНОМУ ПРЕДНАЗНАЧЕНИЮ. Смотрите текст Универсальной общественной лицензии GNU
 * 2-й версии для подробного объяснения (копия включена в файл ЛИЦЕНЗИЯ, поставляемый с этим кодом).
 *
 */

/**
 * 
 */
package рф.эллиптика.ява.увм.компилятор.вопл;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеСообщенияЯвак;

import com.sun.tools.javac.api.Messages;
import com.sun.tools.javac.util.JavacMessages;
import com.sun.tools.javac.util.List;

/**
 * Тип <code>ОболочкаСообщенийЯвак</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеСообщенияЯвакВопл extends ТелеВоплощение<JavacMessages> implements ТелеСообщенияЯвак, Messages {
	private final JavacMessages вопл;

	/**
	 * @throws RemoteException
	 */
	public ТелеСообщенияЯвакВопл(JavacMessages javacMessages) throws RemoteException {
		super(javacMessages);
		вопл = javacMessages;
	}

	public Locale getCurrentLocale() {
		return вопл.getCurrentLocale();
	}

	public void setCurrentLocale(Locale locale) {
		вопл.setCurrentLocale(locale);
	}

	public void add(Строка bundleName) throws MissingResourceException {
		вопл.add(bundleName);
	}

	public List<ResourceBundle> getBundles(Locale locale) {
		return вопл.getBundles(locale);
	}

	public Строка getLocalizedString(Строка key, Object... args) {
		return вопл.getLocalizedString(key, args);
	}

	public Строка getLocalizedString(Locale l, Строка key, Object... args) {
		return вопл.getLocalizedString(l, key, args);
	}

}
