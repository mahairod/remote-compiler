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
import java.util.logging.Level;
import java.util.logging.Logger;

import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;

/**
 * Тип <code>НаряженныйВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class НаряженныйВопл<Клиент extends СопряжениеТелеМаркер> implements Наряженный<Клиент> {
	static final Logger LOGGER = Logger.getLogger(НаряженныйВопл.class.getName());
	protected Клиент клиент;

	protected НаряженныйВопл(Клиент клиент) {
		this.клиент = клиент;
	}

	@Подмени
	@Подмени
	public Клиент разверни() {
		return клиент;
	}
	
	public Object основа(){
		return null;
	}

	protected void сообщиОбОшибке(RemoteException ex){
		LOGGER.log(Level.SEVERE, "Проблема при вызове телеметода ТелеКласса " + клиент.getClass().getName(), ex);
		throw new IllegalStateException(ex);
	}
}
