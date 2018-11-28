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
import рф.эллиптика.ява.увм.КлассыДелегирования;

/**
 *
 * @author Антон Астафьев
 */
class Делегаты extends КлассыДелегирования {

	protected interface ДелегатТелеОбъектаОбщий<Рез, Откл extends Throwable> extends ДелегатОбщий<Рез, Откл, RuntimeException> {
	}

	protected interface
	ПроцедураТелеОбъектаОбщая<Откл extends Throwable> extends ДелегатТелеОбъектаОбщий<Void,Откл> {
	}
	protected interface
	ФункцияТелеОбъектаОбщая<Рез, Откл extends Throwable> extends ДелегатТелеОбъектаОбщий<Рез,Откл>{
	}

	protected @FunctionalInterface abstract static
	interface
	Процедура0<Откл extends Throwable> extends Процедура0__<Откл,RuntimeException>
	,
		ПроцедураТелеОбъектаОбщая<Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Процедура1<Пар, Откл extends Throwable> extends Процедура1__<Пар, Откл, RuntimeException>
	,
		ПроцедураТелеОбъектаОбщая<Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Процедура2<Пар1, Пар2, Откл extends Throwable> extends Процедура2__<Пар1, Пар2, Откл, RuntimeException>
	,
		ПроцедураТелеОбъектаОбщая<Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Процедура3<Пар1, Пар2, Пар3, Откл extends Throwable> extends Процедура3__<Пар1, Пар2, Пар3, Откл, RuntimeException>
	,
		ПроцедураТелеОбъектаОбщая<Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Функтор0<Рез, Откл extends Throwable> extends Функтор0__<Рез, Откл, RuntimeException>
	,
		ФункцияТелеОбъектаОбщая<Рез, Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор1<Рез, Пар, Откл extends Throwable> extends Функтор1__<Рез, Пар, Откл, RuntimeException>
	,
		ФункцияТелеОбъектаОбщая<Рез, Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Функтор2<Рез, Пар1, Пар2, Откл extends Throwable> extends Функтор2__<Рез, Пар1, Пар2, Откл, RuntimeException>
	,
		ФункцияТелеОбъектаОбщая<Рез, Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Функтор3<Рез, Пар1, Пар2, Пар3, Откл extends Throwable> extends Функтор3__<Рез, Пар1, Пар2, Пар3, Откл, RuntimeException>
	,
		ФункцияТелеОбъектаОбщая<Рез, Откл> {}

	protected @FunctionalInterface abstract static
	interface
	Функтор4<Рез, Пар1, Пар2, Пар3, Пар4, Откл extends Throwable> extends Функтор4__<Рез, Пар1, Пар2, Пар3, Пар4, Откл, RuntimeException>
	,
		ФункцияТелеОбъектаОбщая<Рез, Откл> {}

}
