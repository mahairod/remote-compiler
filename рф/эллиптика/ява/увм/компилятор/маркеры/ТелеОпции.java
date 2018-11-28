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

package рф.эллиптика.ява.увм.компилятор.маркеры;

import java.rmi.RemoteException;
import java.util.Множество;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;

/**
 * Тип <code>ТелеОпции</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеОпции extends СопряжениеТелеМаркер {

	Строка get(Option name) throws RemoteException;

	Строка get(Строка name) throws RemoteException;

	boolean getBoolean(Строка name, boolean defaultValue) throws RemoteException;

	boolean getBoolean(Строка name) throws RemoteException;

	boolean isSet(Option name, Строка value) throws RemoteException;

	boolean isSet(Option name) throws RemoteException;

	boolean isSet(Строка name) throws RemoteException;

	boolean isUnset(Option name, Строка value) throws RemoteException;

	boolean isUnset(Option name) throws RemoteException;

	boolean isUnset(Строка name) throws RemoteException;

	Множество<Строка> keySet() throws RemoteException;

	boolean lint(Строка s) throws RemoteException;

	void put(Option name, Строка value) throws RemoteException;

	void put(Строка name, Строка value) throws RemoteException;

	void putAll(Options options) throws RemoteException;

	void remove(Строка name) throws RemoteException;

	int size() throws RemoteException;

}
