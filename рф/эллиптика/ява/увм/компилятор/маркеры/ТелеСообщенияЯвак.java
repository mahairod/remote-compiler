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
package рф.эллиптика.ява.увм.компилятор.маркеры;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.sun.tools.javac.util.List;

/**
 * Тип <code>ТелеСообщенияЯвак</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеСообщенияЯвак extends СопряжениеТелеМаркер {

	Locale getCurrentLocale() throws RemoteException;
	void setCurrentLocale(Locale locale) throws RemoteException;
	void add(Строка bundleName) throws MissingResourceException, RemoteException;
	List<ResourceBundle> getBundles(Locale locale) throws RemoteException;
	Строка getLocalizedString(Строка key, Object... args) throws RemoteException;
	Строка getLocalizedString(Locale l, Строка key, Object... args) throws RemoteException;
}
