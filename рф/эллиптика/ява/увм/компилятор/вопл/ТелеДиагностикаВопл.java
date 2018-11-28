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
package рф.эллиптика.ява.увм.компилятор.вопл;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.Множество;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.code.Lint.LintCategory;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticFlag;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticPosition;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticType;
import com.sun.tools.javac.util.List;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеДиагностика;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеДиагностика.ТелеФабрика;

/**
 * Тип <code>ТелеДиагностикаВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеДиагностикаВопл extends ТелеВоплощение<JCDiagnostic> implements ТелеДиагностика<JavaFileObject>, Diagnostic<JavaFileObject> {
	private final JCDiagnostic вопл;

	public ТелеДиагностикаВопл(JCDiagnostic основа) throws RemoteException {
		super(основа);
		this.вопл = основа;
	}

	public Object[] getArgs() {
		return вопл.getArgs();
	}

	public Строка getCode() {
		return вопл.getCode();
	}

	public long getColumnNumber() {
		return вопл.getColumnNumber();
	}

	public DiagnosticSource getDiagnosticSource() {
		return вопл.getDiagnosticSource();
	}

	public long getEndPosition() {
		return вопл.getEndPosition();
	}

	public javax.tools.Diagnostic.Kind getKind() {
		return вопл.getKind();
	}

	public long getLineNumber() {
		return вопл.getLineNumber();
	}

	public LintCategory getLintCategory() {
		return вопл.getLintCategory();
	}

	public Строка getMessage(Locale locale) {
		return вопл.getMessage(locale);
	}

	public long getPosition() {
		return вопл.getPosition();
	}

	public Строка getPrefix() {
		return вопл.getPrefix();
	}

	public Строка getPrefix(DiagnosticType dt) {
		return вопл.getPrefix(dt);
	}

	public JavaFileObject getSource() {
		return вопл.getSource();
	}

	public long getStartPosition() {
		return вопл.getStartPosition();
	}

	public List<JCDiagnostic> getSubdiagnostics() {
		return вопл.getSubdiagnostics();
	}

	public DiagnosticType getType() {
		return вопл.getType();
	}

	public boolean hasLintCategory() {
		return вопл.hasLintCategory();
	}

	public boolean isFlagSet(DiagnosticFlag flag) {
		return вопл.isFlagSet(flag);
	}

	public boolean isMandatory() {
		return вопл.isMandatory();
	}

	public boolean isMultiline() {
		return вопл.isMultiline();
	}

	public void setFlag(DiagnosticFlag flag) {
		вопл.setFlag(flag);
	}

	public static class ТелеФабрикаВопл extends ТелеВоплощение<JCDiagnostic.Factory> implements ТелеФабрика {
		private final JCDiagnostic.Factory вопл;

		public ТелеФабрикаВопл(JCDiagnostic.Factory основа) throws RemoteException {
			super(основа);
			вопл = основа;
		}

		public JCDiagnostic create(DiagnosticType kind, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.create(kind, source, pos, key, args);
		}

		public JCDiagnostic create(DiagnosticType kind, LintCategory lc, Множество<DiagnosticFlag> flags, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.create(kind, lc, flags, source, pos, key, args);
		}

		public JCDiagnostic error(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.error(source, pos, key, args);
		}

		public JCDiagnostic fragment(Строка key, Object... args) {
			return вопл.fragment(key, args);
		}

		public JCDiagnostic mandatoryNote(DiagnosticSource source, Строка key, Object... args) {
			return вопл.mandatoryNote(source, key, args);
		}

		public JCDiagnostic mandatoryWarning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.mandatoryWarning(source, pos, key, args);
		}

		public JCDiagnostic mandatoryWarning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.mandatoryWarning(lc, source, pos, key, args);
		}

		public JCDiagnostic note(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.note(source, pos, key, args);
		}

		public JCDiagnostic note(Строка key, Object... args) {
			return вопл.note(key, args);
		}

		public JCDiagnostic warning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.warning(source, pos, key, args);
		}

		public JCDiagnostic warning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
			return вопл.warning(lc, source, pos, key, args);
		}

		public JCDiagnostic warning(LintCategory lc, Строка key, Object... args) {
			return вопл.warning(lc, key, args);
		}

	}

}
