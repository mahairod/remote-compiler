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

import com.sun.tools.javac.api.DiagnosticFormatter;
import com.sun.tools.javac.code.Lint;
import com.sun.tools.javac.tree.EndPosTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.Log;
import java.io.PrintWriter;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import java.rmi.RemoteException;

/**
 *
 * @author Антон Астафьев
 */
public interface ТелеРегистратор extends СопряжениеТелеМаркер {
	public boolean hasDiagnosticListener() throws RemoteException;

	public void setEndPosTable(JavaFileObject name, EndPosTable endPosTable) throws RemoteException;

	public void startPartialReparse() throws RemoteException;

	public void endPartialReparse() throws RemoteException;

	public JavaFileObject currentSourceFile() throws RemoteException;

	public DiagnosticListener<? super JavaFileObject> getDiagnosticListener() throws RemoteException;

	public void setDiagnosticListener(DiagnosticListener<? super JavaFileObject> diagListener) throws RemoteException;

	public DiagnosticFormatter<JCDiagnostic> getDiagnosticFormatter() throws RemoteException;

	public void setDiagnosticFormatter(DiagnosticFormatter<JCDiagnostic> diagFormatter) throws RemoteException;

	public PrintWriter getWriter(Log.WriterKind kind) throws RemoteException;

	public void setWriter(Log.WriterKind kind, PrintWriter pw) throws RemoteException;

	public void setWriters(PrintWriter pw) throws RemoteException;

	public void initRound(Log other) throws RemoteException;

	public void popDiagnosticHandler(Log.DiagnosticHandler h) throws RemoteException;

	public void flush() throws RemoteException;

	public void flush(Log.WriterKind kind) throws RemoteException;

	public void prompt() throws RemoteException;

	public void printNewline() throws RemoteException;

	public void printNewline(Log.WriterKind wk) throws RemoteException;

	public void printLines(Строка key, Object... args) throws RemoteException;

	public void printLines(Log.PrefixKind pk, Строка key, Object... args) throws RemoteException;

	public void printLines(Log.WriterKind wk, Строка key, Object... args) throws RemoteException;

	public void printLines(Log.WriterKind wk, Log.PrefixKind pk, Строка key, Object... args) throws RemoteException;

	public void printRawLines(Строка msg) throws RemoteException;

	public void printRawLines(Log.WriterKind kind, Строка msg) throws RemoteException;

	public void printVerbose(Строка key, Object... args) throws RemoteException;

	public void strictWarning(JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void report(JCDiagnostic diagnostic) throws RemoteException;

	public Строка localize(Строка key, Object... args) throws RemoteException;

	public Строка localize(Log.PrefixKind pk, Строка key, Object... args) throws RemoteException;

	public void rawError(int pos, Строка msg) throws RemoteException;

	public void rawWarning(int pos, Строка msg) throws RemoteException;

	public JCDiagnostic getErrDiag(JCTree tree) throws RemoteException;

	public JavaFileObject useSource(JavaFileObject file) throws RemoteException;

	public DiagnosticSource currentSource() throws RemoteException;

	public void error(Строка key, Object... args) throws RemoteException;

	public void error(JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void error(JCDiagnostic.DiagnosticFlag flag, JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void error(int pos, Строка key, Object... args) throws RemoteException;

	public void error(JCDiagnostic.DiagnosticFlag flag, int pos, Строка key, Object... args) throws RemoteException;

	public void warning(Строка key, Object... args) throws RemoteException;

	public void warning(Lint.LintCategory lc, Строка key, Object... args) throws RemoteException;

	public void warning(JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void warning(Lint.LintCategory lc, JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void warning(int pos, Строка key, Object... args) throws RemoteException;

	public void mandatoryWarning(JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void mandatoryWarning(Lint.LintCategory lc, JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void note(Строка key, Object... args) throws RemoteException;

	public void note(JCDiagnostic.DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	public void note(int pos, Строка key, Object... args) throws RemoteException;

	public void note(JavaFileObject file, Строка key, Object... args) throws RemoteException;

	public void mandatoryNote(JavaFileObject file, Строка key, Object... args) throws RemoteException;

}
