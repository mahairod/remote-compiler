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
import java.util.Итератор;
import java.util.Множество;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеРаспорядительФайлов;


/**
 * Тип <code>ОболочкаРаспорядителяФайлов</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ОболочкаРаспорядителяФайлов extends БазаОболочки<JavaFileManager, ТелеРаспорядительФайлов> implements JavaFileManager {
	ОболочкаРаспорядителяФайлов(ТелеРаспорядительФайлов распорядительФайлов) {
		super(распорядительФайлов);
	}

	@Подмени
	public ClassLoader getClassLoader(Location lctn) {
		return ди.телеФункция(база::getClassLoader, lctn);
	}

	@Подмени
	public Iterable<JavaFileObject> list(Location lctn, Строка string, Множество<JavaFileObject.Kind> set, boolean bln) throws IOException {
		return ди.телеФункция(база::list, lctn, string, set, bln);
	}

	@Подмени
	public Строка inferBinaryName(Location lctn, JavaFileObject jfo) {
		return ди.телеФункция(база::inferBinaryName, lctn, jfo);
	}

	@Подмени
	public boolean isSameFile(FileObject fo, FileObject fo1) {
		return ди.телеФункция(база::isSameFile, fo, fo1);
	}

	@Подмени
	public boolean handleOption(Строка string, Итератор<Строка> itrtr) {
		return ди.телеФункция(база::handleOption, string, itrtr);
	}

	@Подмени
	public boolean hasLocation(Location lctn) {
		return ди.телеФункция(база::hasLocation, lctn);
	}

	@Подмени
	public JavaFileObject getJavaFileForInput(Location lctn, Строка string, JavaFileObject.Kind kind) throws IOException {
		return ди.телеФункция(база::getJavaFileForInput, lctn, string, kind);
	}

	@Подмени
	public JavaFileObject getJavaFileForOutput(Location lctn, Строка string, JavaFileObject.Kind kind, FileObject fo) throws IOException {
		return ди.телеФункция(база::getJavaFileForOutput, lctn, string, kind, fo);
	}

	@Подмени
	public FileObject getFileForInput(Location lctn, Строка string, Строка string1) throws IOException {
		return ди.телеФункция(база::getFileForInput, lctn, string, string1);
	}

	@Подмени
	public FileObject getFileForOutput(Location lctn, Строка string, Строка string1, FileObject fo) throws IOException {
		return ди.телеФункция(база::getFileForOutput, lctn, string, string1, fo);
	}

	@Подмени
	public void flush() throws IOException {
		база.flush();
	}

	@Подмени
	public void close() throws IOException {
		база.close();
	}

	@Подмени
	public int isSupportedOption(Строка string) {
		return ди.телеФункция(база::isSupportedOption, string);
	}
}
