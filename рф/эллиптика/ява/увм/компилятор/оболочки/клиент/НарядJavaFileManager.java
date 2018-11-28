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
import java.rmi.RemoteException;
import java.util.Итератор;
import java.util.Множество;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеРаспорядительФайлов;

/**
 * Тип <code>НарядJavaFileManager</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class НарядJavaFileManager extends НаряженныйВопл<ТелеРаспорядительФайлов> implements ТелеРаспорядительФайлов, JavaFileManager {
	private static final long serialVersionUID = 7619845911091104967L;
	private ТелеРаспорядительФайлов impl;

	public НарядJavaFileManager(ТелеРаспорядительФайлов client) {
		super(client);
	}

	@Подмени @Подмени
	public int isSupportedOption(Строка option) {
		try {
			return impl.isSupportedOption(option);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return 0;
		}
	}

	@Подмени @Подмени
	public ClassLoader getClassLoader(Location location) {
		try {
			return impl.getClassLoader(location);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return null;
		}
	}

	public Iterable<JavaFileObject> list(Location location, Строка packageName, Множество<Kind> kinds, boolean recurse)
			throws IOException {
		return impl.list(location, packageName, kinds, recurse);
	}

	@Подмени @Подмени
	public Строка inferBinaryName(Location location, JavaFileObject file) {
		try {
			return impl.inferBinaryName(location, file);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return null;
		}
	}

	@Подмени @Подмени
	public boolean isSameFile(FileObject a, FileObject b) {
		try {
			return impl.isSameFile(a, b);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return false;
		}
	}

	@Подмени @Подмени
	public boolean handleOption(Строка current, Итератор<Строка> remaining) {
		try {
			return impl.handleOption(current, remaining);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return false;
		}
	}

	@Подмени @Подмени
	public boolean hasLocation(Location location) {
		try {
			return impl.hasLocation(location);
		} catch (RemoteException ex) {
			сообщиОбОшибке(ex);
			return false;
		}
	}

	@Подмени @Подмени
	public JavaFileObject getJavaFileForInput(Location location, Строка className, Kind kind) throws IOException {
		return impl.getJavaFileForInput(location, className, kind);
	}

	@Подмени @Подмени
	public JavaFileObject getJavaFileForOutput(Location location, Строка className, Kind kind, FileObject sibling)
			throws IOException {
		return impl.getJavaFileForOutput(location, className, kind, sibling);
	}

	@Подмени @Подмени
	public FileObject getFileForInput(Location location, Строка packageName, Строка relativeName) throws IOException {
		return impl.getFileForInput(location, packageName, relativeName);
	}

	@Подмени @Подмени
	public FileObject getFileForOutput(Location location, Строка packageName, Строка relativeName, FileObject sibling)
			throws IOException {
		return impl.getFileForOutput(location, packageName, relativeName, sibling);
	}

	@Подмени @Подмени
	public void flush() throws IOException {
		impl.flush();
	}

	@Подмени @Подмени
	public void close() throws IOException {
		impl.close();
	}

}
