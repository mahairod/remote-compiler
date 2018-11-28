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

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеСообщенияЯвак;

import com.sun.tools.javac.util.JavacMessages;
import com.sun.tools.javac.util.List;

/**
 *
 * @author Антон Астафьев
 */
public class ОболочкаСообщенийЯвак extends JavacMessages implements ОболочкаТелеКласса<JavacMessages,ТелеСообщенияЯвак>, ТелеСообщенияЯвак {
	private final ТелеСообщенияЯвак база;
	private final ДелегированиеОболочки об = делегатИсполнитель();

	public ОболочкаСообщенийЯвак(ТелеСообщенияЯвак основа) {
		super(вспомогательныйКонтекст);
		база = основа;
	}

	private ДелегированиеОболочки начДелегат(){
		return об!=null? об : ХолостоеДелегирование.дайЭкземпляр();
	}

	@Подмени
	public Locale getCurrentLocale() {
		return об.телеФункция(база::getCurrentLocale);
	}

	@Подмени
	public void setCurrentLocale(Locale locale) {
		if (база!=null)
			об.телеВызов(база::setCurrentLocale, locale);
	}

	@Подмени
	public void add(Строка bundleName) throws MissingResourceException {
		if (база!=null)
			начДелегат().телеВызов(база::add, bundleName);
	}

	@Подмени
	public List<ResourceBundle> getBundles(Locale locale) {
		return об.телеФункция(база::getBundles, locale);
	}

	@Подмени
	public Строка getLocalizedString(Строка key, Object... args) {
		return об.телеФункция(база::getLocalizedString, key, args);
	}

	@Подмени
	public Строка getLocalizedString(Locale l, Строка key, Object... args) {
		return об.телеФункция(база::getLocalizedString, l, key, args);
	}

	@Подмени @Подмени
	public ТелеСообщенияЯвак дайОснову() {
		return база;
	}

}
