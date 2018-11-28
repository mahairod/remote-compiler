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
import java.util.Словарь;

import com.sun.tools.javac.util.Context;

/**
 *
 * @author Антон Астафьев
 */
public interface ТелеОкружение extends СопряжениеТелеМаркер {

	void clear() throws RemoteException;

	void dump() throws RemoteException;

	<T> T get(Context.Key<T> key) throws RemoteException;

	<T> void put(Context.Key<T> key, Context.Factory<T> fac) throws RemoteException;

	<T> void put(Context.Key<T> key, T data) throws RemoteException;

	<T> T get(Class<T> clazz) throws RemoteException;

	<T> void put(Class<T> clazz, Context.Factory<T> fac) throws RemoteException;

	<T> void put(Class<T> clazz, T data) throws RemoteException;

	void согласуйСтатическиеКлючи(Словарь<? extends Context.Key<?>, Field> ключи) throws RemoteException;
}
