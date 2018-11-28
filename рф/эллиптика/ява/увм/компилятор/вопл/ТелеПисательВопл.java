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

package рф.эллиптика.ява.увм.компилятор.вопл;

import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеПисатель;

/**
 * Тип <code>ТелеПисательВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеПисательВопл extends ТелеВоплощение<Writer> implements ТелеПисатель {
	private final Writer вопл;

	/**
	 * @throws RemoteException
	 */
	public ТелеПисательВопл(Writer writer) throws RemoteException {
		super(writer);
		вопл = writer;
	}

	@Подмени @Override
	public void write(char[] симбуф, int смещ, int длина) throws IOException {
		вопл.write(симбуф, смещ, длина);
	}

	@Подмени @Override
	public Writer append(CharSequence спосл) throws IOException {
		return вопл.append(спосл);
	}

	@Подмени @Override
	public Writer append(CharSequence спосл, int начало, int конец) throws IOException {
		return вопл.append(спосл, начало, конец);
	}

	@Подмени @Override
	public Writer append(char с) throws IOException {
		return вопл.append(с);
	}

	@Подмени @Override
	public void flush() throws IOException {
		вопл.flush();
	}

	@Подмени @Override
	public void close() throws IOException {
		вопл.close();
	}

}
