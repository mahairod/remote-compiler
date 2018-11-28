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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.rmi.RemoteException;

import javax.tools.FileObject;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОбъектФайла;

/**
 * Тип <code>НарядFileObject</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */

class НарядFileObject extends НарядFileObjectОбщий<FileObject, ТелеОбъектФайла> {
	protected НарядFileObject(ТелеОбъектФайла клиент) {
		super(клиент);
	}
}

class НарядFileObjectОбщий<Проксируемый extends FileObject, ТелеКласс extends ТелеОбъектФайла> extends НаряженныйВопл<ТелеКласс> implements ТелеОбъектФайла {
	ТелеКласс impl;

	protected НарядFileObjectОбщий(ТелеКласс клиент) {
		super(клиент);
		impl = клиент;
	}

	@Подмени @Подмени
	public URI toUri() {
		try {
			return impl.toUri();
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return null;
		}
	}

	@Подмени @Подмени
	public Строка getName() {
		try {
			return impl.getName();
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return null;
		}
	}

	@Подмени @Подмени
	public InputStream openInputStream() throws IOException {
		return impl.openInputStream();
	}

	@Подмени @Подмени
	public OutputStream openOutputStream() throws IOException {
		return impl.openOutputStream();
	}

	@Подмени @Подмени
	public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
		return impl.openReader(ignoreEncodingErrors);
	}

	@Подмени @Подмени
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return impl.getCharContent(ignoreEncodingErrors);
	}

	@Подмени @Подмени
	public Writer openWriter() throws IOException {
		return impl.openWriter();
	}

	@Подмени @Подмени
	public long getLastModified() {
		try {
			return impl.getLastModified();
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return 0;
		}
	}

	@Подмени @Подмени
	public boolean delete() {
		try {
			return impl.delete();
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return false;
		}
	}

}
