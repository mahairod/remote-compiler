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
package рф.эллиптика.ява.увм.компилятор.оболочки.клиент;

import java.rmi.RemoteException;
import java.util.Множество;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.Options;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОпции;

/**
 * Тип <code>НарядOptions</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class НарядOptions extends НаряженныйВопл<ТелеОпции> implements ТелеОпции {
	ТелеОпции impl;

	protected НарядOptions(ТелеОпции клиент) {
		super(клиент);
		impl = клиент;
	}

	public Строка get(Option name) throws RemoteException {
		return impl.get(name);
	}

	public Строка get(Строка name) throws RemoteException {
		return impl.get(name);
	}

	public boolean getBoolean(Строка name, boolean defaultValue) throws RemoteException {
		return impl.getBoolean(name, defaultValue);
	}

	public boolean getBoolean(Строка name) throws RemoteException {
		return impl.getBoolean(name);
	}

	public boolean isSet(Option name, Строка value) throws RemoteException {
		return impl.isSet(name, value);
	}

	public boolean isSet(Option name) throws RemoteException {
		return impl.isSet(name);
	}

	public boolean isSet(Строка name) throws RemoteException {
		return impl.isSet(name);
	}

	public boolean isUnset(Option name, Строка value) throws RemoteException {
		return impl.isUnset(name, value);
	}

	public boolean isUnset(Option name) throws RemoteException {
		return impl.isUnset(name);
	}

	public boolean isUnset(Строка name) throws RemoteException {
		return impl.isUnset(name);
	}

	public Множество<Строка> keySet() throws RemoteException {
		return impl.keySet();
	}

	public boolean lint(Строка s) throws RemoteException {
		return impl.lint(s);
	}

	public void put(Option name, Строка value) throws RemoteException {
		impl.put(name, value);
	}

	public void put(Строка name, Строка value) throws RemoteException {
		impl.put(name, value);
	}

	public void putAll(Options options) throws RemoteException {
		impl.putAll(options);
	}

	public void remove(Строка name) throws RemoteException {
		impl.remove(name);
	}

	public int size() throws RemoteException {
		return impl.size();
	}

}
