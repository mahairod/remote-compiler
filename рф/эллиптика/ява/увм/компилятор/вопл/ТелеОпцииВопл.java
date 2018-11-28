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
import java.util.Множество;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОпции;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.Options;

/**
 * Тип <code>ТелеОпцииВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеОпцииВопл extends ТелеВоплощение<Options> implements ТелеОпции {
	private static final long serialVersionUID = -6679698489824421747L;
	
	private final Options вопл;

	public ТелеОпцииВопл(Options options) throws RemoteException {
		super(options);
		вопл = options;
	}
	
	public Строка get(Option name) {
		return вопл.get(name);
	}

	public Строка get(Строка name) {
		return вопл.get(name);
	}

	public boolean getBoolean(Строка name, boolean defaultValue) {
		return вопл.getBoolean(name, defaultValue);
	}

	public boolean getBoolean(Строка name) {
		return вопл.getBoolean(name);
	}

	public boolean isSet(Option name, Строка value) {
		return вопл.isSet(name, value);
	}

	public boolean isSet(Option name) {
		return вопл.isSet(name);
	}

	public boolean isSet(Строка name) {
		return вопл.isSet(name);
	}

	public boolean isUnset(Option name, Строка value) {
		return вопл.isUnset(name, value);
	}

	public boolean isUnset(Option name) {
		return вопл.isUnset(name);
	}

	public boolean isUnset(Строка name) {
		return вопл.isUnset(name);
	}

	public Множество<Строка> keySet() {
		return вопл.keySet();
	}

	public boolean lint(Строка s) {
		return вопл.lint(s);
	}

	public void put(Option name, Строка value) {
		вопл.put(name, value);
	}

	public void put(Строка name, Строка value) {
		вопл.put(name, value);
	}

	public void putAll(Options options) {
		вопл.putAll(options);
	}

	public void remove(Строка name) {
		вопл.remove(name);
	}

	public int size() {
		return вопл.size();
	}
}
