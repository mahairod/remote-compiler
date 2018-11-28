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
package рф.эллиптика.ява.увм.компилятор.оболочки;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.rmi.RemoteException;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.api.ClientCodeWrapper.WrappedClientCode;

import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОбъектЯваФайла;

/**
 * Тип <code>ОболочкаОбъектаЯваФайла</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ОболочкаОбъектаЯваФайла extends БазаОболочки<JavaFileObject, ТелеОбъектЯваФайла> implements ТелеОбъектЯваФайла, JavaFileObject {

	private final ТелеОбъектЯваФайла база;
	
	ОболочкаОбъектаЯваФайла(ТелеОбъектЯваФайла база) {
		super(база);
		this.база = база;
	}

	public Kind getKind() {
		return ди.телеФункция(база::getKind);
	}

	public URI toUri() {
		return ди.телеФункция(база::toUri);
	}

	public boolean isNameCompatible(Строка simpleName, Kind kind) {
		return ди.телеФункция(база::isNameCompatible, simpleName, kind);
	}

	public Строка getName() {
		return ди.телеФункция(база::getName);
	}

	public InputStream openInputStream() throws IOException {
		return ди.телеФункция(база::openInputStream);
	}

	public NestingKind getNestingKind() {
		return ди.телеФункция(база::getNestingKind);
	}

	public OutputStream openOutputStream() throws IOException {
		return ди.телеФункция(база::openOutputStream);
	}

	public Modifier getAccessLevel() {
		return ди.телеФункция(база::getAccessLevel);
	}

	public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
		return ди.телеФункция(база::openReader, ignoreEncodingErrors);
	}

	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return ди.телеФункция(база::getCharContent, ignoreEncodingErrors);
	}

	public Writer openWriter() throws IOException, RemoteException {
		return ди.телеФункция(база::openWriter);
	}

	public long getLastModified() {
		return ди.телеФункция(база::getLastModified);
	}

	public boolean delete() {
		return ди.телеФункция(база::delete);
	}

}
