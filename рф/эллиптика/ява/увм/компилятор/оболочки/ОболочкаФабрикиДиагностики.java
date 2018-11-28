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

import com.sun.tools.javac.code.Lint.LintCategory;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.DiagnosticSource;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.*;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеДиагностика;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеПисатель;

/**
 * Тип <code>ОболочкаФабрикиДиагностики</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ОболочкаФабрикиДиагностики extends JCDiagnostic.Factory implements ОболочкаТелеКласса<JCDiagnostic.Factory, ТелеДиагностика.ТелеФабрика>, ТелеДиагностика.ТелеФабрика {
	private final ТелеДиагностика.ТелеФабрика ядро;
	private final ДелегированиеОболочки об;

	ОболочкаФабрикиДиагностики(ТелеДиагностика.ТелеФабрика основа) {
		super(вспомогательныйКонтекст);
		this.ядро = основа;
		this.об = делегатИсполнитель();
	}

	@Подмени
	public JCDiagnostic create(DiagnosticType kind, LintCategory lc, java.util.Множество<DiagnosticFlag> flags, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::create, kind, lc, flags, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic create(DiagnosticType kind, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::create, kind, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic fragment(Строка key, Object... args) {
		return об.телеФункция(ядро::fragment, key, args);
	}

	@Подмени
	public JCDiagnostic note(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::note, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic note(Строка key, Object... args) {
		return об.телеФункция(ядро::note, key, args);
	}

	@Подмени
	public JCDiagnostic mandatoryNote(DiagnosticSource source, Строка key, Object... args) {
		return об.телеФункция(ядро::mandatoryNote, source, key, args);
	}

	@Подмени
	public JCDiagnostic warning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::warning, lc, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic warning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::warning, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic warning(LintCategory lc, Строка key, Object... args) {
		return об.телеФункция(ядро::warning, lc, key, args);
	}

	@Подмени
	public JCDiagnostic mandatoryWarning(LintCategory lc, DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::mandatoryWarning, lc, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic mandatoryWarning(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::mandatoryWarning, source, pos, key, args);
	}

	@Подмени
	public JCDiagnostic error(DiagnosticSource source, DiagnosticPosition pos, Строка key, Object... args) {
		return об.телеФункция(ядро::error, source, pos, key, args);
	}

	@Подмени
	public ТелеДиагностика.ТелеФабрика дайОснову() {
		return ядро;
	}

}
