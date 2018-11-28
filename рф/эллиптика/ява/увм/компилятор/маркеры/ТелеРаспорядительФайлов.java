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

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Итератор;
import java.util.Множество;
import javax.tools.FileObject;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;

/**
 *
 * @author Антон Астафьев
 */
public interface ТелеРаспорядительФайлов extends СопряжениеТелеМаркер {

	public void close() throws IOException;

	public void flush() throws IOException;

	public FileObject getFileForOutput(Location lctn, Строка string, Строка string1, FileObject fo) throws IOException;

	public FileObject getFileForInput(Location lctn, Строка string, Строка string1) throws IOException;

	public JavaFileObject getJavaFileForOutput(Location lctn, Строка string, JavaFileObject.Kind kind, FileObject fo) throws IOException;

	public JavaFileObject getJavaFileForInput(Location lctn, Строка string, JavaFileObject.Kind kind) throws IOException;

	public boolean hasLocation(Location lctn) throws RemoteException;

	public boolean handleOption(Строка string, Итератор<Строка> itrtr) throws RemoteException;

	public boolean isSameFile(FileObject fo, FileObject fo1) throws RemoteException;

	public Строка inferBinaryName(Location lctn, JavaFileObject jfo) throws RemoteException;

	public Iterable<JavaFileObject> list(Location lctn, Строка string, Множество<JavaFileObject.Kind> set, boolean bln) throws IOException;

	public ClassLoader getClassLoader(Location lctn) throws RemoteException;

	public int isSupportedOption(Строка string) throws RemoteException;

}
