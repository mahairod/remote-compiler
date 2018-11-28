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

package рф.эллиптика.ява.увм.компилятор.оболочки;

import java.io.PrintWriter;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.api.DiagnosticFormatter;
import com.sun.tools.javac.code.Lint.LintCategory;
import com.sun.tools.javac.tree.EndPosTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticFlag;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticPosition;
import com.sun.tools.javac.util.Log;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеРегистратор;

/**
 * Тип <code>ОболочкаРегистратора</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ОболочкаРегистратора extends Log implements ОболочкаТелеКласса<Log, ТелеРегистратор>, ТелеРегистратор {
	private final ТелеРегистратор база;
	private final ДелегированиеОболочки об;

	protected ОболочкаРегистратора(ТелеРегистратор ядро) {
		super(вспомогательныйКонтекст);
		база = ядро;
		this.об = делегатИсполнитель();
	}

	@Подмени @Подмени
	public ТелеРегистратор дайОснову() {
		return база;
	}

	public boolean hasDiagnosticListener() {
		return об.телеФункция(база::hasDiagnosticListener);
	}

	@Подмени @Подмени
	public void setEndPosTable(JavaFileObject name, EndPosTable endPosTable) {
		об.телеВызов(база::setEndPosTable, name, endPosTable);
	}

	@Подмени @Подмени
	public void startPartialReparse() {
		об.телеВызов(база::startPartialReparse);
	}

	@Подмени @Подмени
	public void endPartialReparse() {
		об.телеВызов(база::endPartialReparse);
	}

	public JavaFileObject currentSourceFile() {
		return об.телеФункция(база::currentSourceFile);
	}

	public DiagnosticListener<? super JavaFileObject> getDiagnosticListener() {
		return об.телеФункция(база::getDiagnosticListener);
	}

	@Подмени @Подмени
	public void setDiagnosticListener(DiagnosticListener<? super JavaFileObject> diagListener) {
		об.телеВызов(база::setDiagnosticListener, diagListener);
	}

	public DiagnosticFormatter<JCDiagnostic> getDiagnosticFormatter() {
		return об.телеФункция(база::getDiagnosticFormatter);
	}

	@Подмени @Подмени
	public void setDiagnosticFormatter(DiagnosticFormatter<JCDiagnostic> diagFormatter) {
		об.телеВызов(база::setDiagnosticFormatter, diagFormatter);
	}

	public PrintWriter getWriter(WriterKind kind) {
		return об.телеФункция(база::getWriter, kind);
	}

	@Подмени @Подмени
	public void setWriter(WriterKind kind, PrintWriter pw) {
		об.телеВызов(база::setWriter, kind, pw);
	}

	@Подмени @Подмени
	public void setWriters(PrintWriter pw) {
		об.телеВызов(база::setWriters, pw);
	}

	@Подмени @Подмени
	public void initRound(Log other) {
		об.телеВызов(база::initRound, other);
	}

	@Подмени @Подмени
	public void popDiagnosticHandler(DiagnosticHandler h) {
		об.телеВызов(база::popDiagnosticHandler, h);
	}

	@Подмени @Подмени
	public void flush() {
		об.телеВызов(база::flush);
	}

	@Подмени @Подмени
	public void flush(WriterKind kind) {
		об.телеВызов(база::flush, kind);
	}

	@Подмени @Подмени
	public void prompt() {
		об.телеВызов(база::prompt);
	}

	@Подмени @Подмени
	public void printNewline() {
		об.телеВызов(база::printNewline);
	}

	@Подмени @Подмени
	public void printNewline(WriterKind wk) {
		об.телеВызов(база::printNewline, wk);
	}

	@Подмени @Подмени
	public void printLines(Строка key, Object... args) {
		об.телеВызов(база::printLines, key, args);
	}

	@Подмени @Подмени
	public void printLines(PrefixKind pk, Строка key, Object... args) {
		об.телеВызов(база::printLines, pk, key, args);
	}

	@Подмени @Подмени
	public void printLines(WriterKind wk, Строка key, Object... args) {
		об.телеВызов(база::printLines, wk, key, args);
	}

	@Подмени @Подмени
	public void printLines(WriterKind wk, PrefixKind pk, Строка key, Object... args) {
		об.телеВызов(база::printLines, wk, pk, key, args);
	}

	@Подмени @Подмени
	public void printRawLines(Строка msg) {
		об.телеВызов(база::printRawLines, msg);
	}

	@Подмени @Подмени
	public void printRawLines(WriterKind kind, Строка msg) {
		об.телеВызов(база::printRawLines, kind, msg);
	}

	@Подмени @Подмени
	public void printVerbose(Строка key, Object... args) {
		об.телеВызов(база::printVerbose, key, args);
	}

	@Подмени @Подмени
	public void strictWarning(DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::strictWarning, pos, key, args);
	}

	@Подмени @Подмени
	public void report(JCDiagnostic diagnostic) {
		об.телеВызов(база::report, diagnostic);
	}

	public Строка localize(Строка key, Object... args) {
		return об.телеФункция(база::localize, key, args);
	}

	public Строка localize(PrefixKind pk, Строка key, Object... args) {
		return об.телеФункция(база::localize, pk, key, args);
	}

	@Подмени @Подмени
	public void rawError(int pos, Строка msg) {
		об.телеВызов(база::rawError, pos, msg);
	}

	@Подмени @Подмени
	public void rawWarning(int pos, Строка msg) {
		об.телеВызов(база::rawWarning, pos, msg);
	}

	public JCDiagnostic getErrDiag(JCTree tree) {
		return об.телеФункция(база::getErrDiag, tree);
	}

	public JavaFileObject useSource(JavaFileObject file) {
		return об.телеФункция(база::useSource, file);
	}

	public DiagnosticSource currentSource() {
		return об.телеФункция(база::currentSource);
	}

	@Подмени @Подмени
	public void error(Строка key, Object... args) {
		об.телеВызов(база::error, key, args);
	}

	@Подмени @Подмени
	public void error(DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::error, pos, key, args);
	}

	@Подмени @Подмени
	public void error(DiagnosticFlag flag, DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::error, flag, pos, key, args);
	}

	@Подмени @Подмени
	public void error(int pos, Строка key, Object... args) {
		об.телеВызов(база::error, pos, key, args);
	}

	@Подмени @Подмени
	public void error(DiagnosticFlag flag, int pos, Строка key, Object... args) {
		об.телеВызов(база::error, flag, pos, key, args);
	}

	@Подмени @Подмени
	public void warning(Строка key, Object... args) {
		об.телеВызов(база::warning, key, args);
	}

	@Подмени @Подмени
	public void warning(LintCategory lc, Строка key, Object... args) {
		об.телеВызов(база::warning, lc, key, args);
	}

	@Подмени @Подмени
	public void warning(DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::warning, pos, key, args);
	}

	@Подмени @Подмени
	public void warning(LintCategory lc, DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::warning, lc, pos, key, args);
	}

	@Подмени @Подмени
	public void warning(int pos, Строка key, Object... args) {
		об.телеВызов(база::warning, pos, key, args);
	}

	@Подмени @Подмени
	public void mandatoryWarning(DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::mandatoryWarning, pos, key, args);
	}

	@Подмени @Подмени
	public void mandatoryWarning(LintCategory lc, DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::mandatoryWarning, lc, pos, key, args);
	}

	@Подмени @Подмени
	public void note(Строка key, Object... args) {
		об.телеВызов(база::note, key, args);
	}

	@Подмени @Подмени
	public void note(DiagnosticPosition pos, Строка key, Object... args) {
		об.телеВызов(база::note, pos, key, args);
	}

	@Подмени @Подмени
	public void note(int pos, Строка key, Object... args) {
		об.телеВызов(база::note, pos, key, args);
	}

	@Подмени @Подмени
	public void note(JavaFileObject file, Строка key, Object... args) {
		об.телеВызов(база::note, file, key, args);
	}

	@Подмени @Подмени
	public void mandatoryNote(JavaFileObject file, Строка key, Object... args) {
		об.телеВызов(база::mandatoryNote, file, key, args);
	}


}
