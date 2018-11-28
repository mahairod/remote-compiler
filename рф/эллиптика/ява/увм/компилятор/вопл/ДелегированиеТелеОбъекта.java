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

package рф.эллиптика.ява.увм.компилятор.вопл;

import рф.эллиптика.ява.увм.ДелегатОбщий;
import рф.эллиптика.ява.увм.ДелегированиеМетодов;
import рф.эллиптика.ява.увм.ОбработчикТелеВызова;
import рф.эллиптика.ява.увм.КлассыДелегирования.Процедура0__;
import рф.эллиптика.ява.увм.КлассыДелегирования.Функтор0__;

/**
 *
 * @author Антон Астафьев
 */
class ДелегированиеТелеОбъекта extends ДелегированиеМетодов {
	ДелегированиеТелеОбъекта(ТелеВоплощение<?> шлюз) {
		super(шлюз);
	}
	
	@Подмени
	protected <Рез, Откл extends Throwable, ОбщОткл extends Throwable> ОбработчикТелеВызова<Рез, Откл, ОбщОткл> об(ДелегатОбщий<Рез, Откл, ОбщОткл> функ) {
		ДелегатОбщий<Рез, Откл, RuntimeException> делегат = (ДелегатОбщий<Рез, Откл, RuntimeException>) функ;
		return (ОбработчикТелеВызова<Рез, Откл, ОбщОткл>) new ОболочкаДелегата<Рез, Откл>(делегат, шлюз);
	}
	public
	<Откл extends Throwable, ОбщОткл extends Throwable>
	void простойТелеВызов(final Процедура0__<Откл, ОбщОткл> д) throws Откл
	{
		Процедура0__<Откл, RuntimeException> до = (Процедура0__<Откл, RuntimeException>)д;
		до.вызов();
	}
	

	public
	<Рез, Откл extends Throwable, ОбщОткл extends Throwable>
	Рез простаяТелеФункция(final Функтор0__<Рез, Откл, ОбщОткл> д) throws Откл
	{
		Функтор0__<Рез, Откл, RuntimeException> до = (Функтор0__<Рез, Откл, RuntimeException>)д;
		return до.вызов();
	}
}
