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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.rmi.RemoteException;

/**
 * Тип <code>ТелеОбъектФайла</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеОбъектФайла extends СопряжениеТелеМаркер {

	URI toUri() throws RemoteException;

	Строка getName() throws RemoteException;

	InputStream openInputStream() throws IOException, RemoteException;

	OutputStream openOutputStream() throws IOException, RemoteException;

	Reader openReader(boolean ignoreEncodingErrors) throws IOException, RemoteException;

	CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException, RemoteException;

	Writer openWriter() throws IOException, RemoteException;

	long getLastModified() throws RemoteException;

	boolean delete() throws RemoteException;

}
