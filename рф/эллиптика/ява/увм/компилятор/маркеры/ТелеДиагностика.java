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

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.Множество;

import com.sun.tools.javac.code.Lint.LintCategory;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticFlag;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticPosition;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticType;

/**
 * Тип <code>ТелеДиагностика</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеДиагностика<Исх> extends СопряжениеТелеМаркер {

	javax.tools.Diagnostic.Kind getKind() throws RemoteException;

	Исх getSource() throws RemoteException;

	long getPosition() throws RemoteException;

	long getStartPosition() throws RemoteException;

	long getEndPosition() throws RemoteException;

	long getLineNumber() throws RemoteException;

	long getColumnNumber() throws RemoteException;

	Строка getCode() throws RemoteException;

	Строка getMessage(Locale locale) throws RemoteException;

	public interface ТелеФабрика extends СопряжениеТелеМаркер {

		JCDiagnostic error(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic mandatoryWarning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic mandatoryWarning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic warning(LintCategory lc, Строка key, Object... args) throws RemoteException;

		JCDiagnostic warning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic warning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic mandatoryNote(DiagnosticSource source, Строка key, Object... args) throws RemoteException;

		JCDiagnostic note(Строка key, Object... args) throws RemoteException;

		JCDiagnostic note(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic fragment(Строка key, Object... args) throws RemoteException;

		JCDiagnostic create(DiagnosticType kind, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

		JCDiagnostic create(DiagnosticType kind, LintCategory lc, Множество<DiagnosticFlag> flags, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	}

}
