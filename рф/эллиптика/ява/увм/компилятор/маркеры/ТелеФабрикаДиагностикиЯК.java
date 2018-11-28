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

import java.rmi.RemoteException;
import com.sun.tools.javac.code.Lint;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.*;

/**
 *
 * @author Антон Астафьев
 */
public interface ТелеФабрикаДиагностикиЯК extends СопряжениеТелеМаркер {

	JCDiagnostic create(DiagnosticType kind, Lint.LintCategory lc, java.util.Множество<DiagnosticFlag> flags, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic create(DiagnosticType kind, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic fragment(Строка key, Object... args) throws RemoteException;

	JCDiagnostic note(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic note(Строка key, Object... args) throws RemoteException;

	JCDiagnostic mandatoryNote(DiagnosticSource source, Строка key, Object... args) throws RemoteException;

	JCDiagnostic warning(Lint.LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic warning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic warning(Lint.LintCategory lc, Строка key, Object... args) throws RemoteException;

	JCDiagnostic mandatoryWarning(Lint.LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic mandatoryWarning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

	JCDiagnostic error(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) throws RemoteException;

}
