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

package рф.эллиптика.ява.увм;

import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;
import com.sun.tools.javac.api.ClientCodeWrapper.WrappedClientCode;

/**
 * Тип <code>МетодыДелегированияСпец</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
abstract class МетодыДелегированияСпец implements РасширениеШлюза {
	protected abstract ШлюзовойКласс дайШлюз();

	public <ТипПрокси extends СопряжениеТелеМаркер, WrappedCode extends WrappedClientCode<Object> >
	СопряжениеТелеМаркер внешнееПредставление(WrappedCode оболочка) {
		return дайШлюз().внешнееПредставление(оболочка);
	}

}
