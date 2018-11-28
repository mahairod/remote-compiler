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

import java.rmi.RemoteException;
import рф.эллиптика.ява.увм.ДелегатОбщий;
import рф.эллиптика.ява.увм.КлассыДелегирования;

/**
 *
 * @author Антон Астафьев
 */
class Делегаты extends КлассыДелегирования {

	interface ДелегатОболочкиОбщий<Рез, Откл extends Throwable> extends ДелегатОбщий<Рез, Откл, RemoteException> {
	}

	private interface
	ПроцедураОболочкиОбщая<Откл extends Throwable> extends ДелегатОболочкиОбщий<Void,Откл> {
	}
	private interface
	ФункцияОболочкиОбщая<Рез, Откл extends Throwable> extends ДелегатОболочкиОбщий<Рез,Откл>{
	}

	@FunctionalInterface abstract static
	interface
	Процедура0<Откл extends Throwable> extends Процедура0__<Откл,RemoteException>
	,
		ПроцедураОболочкиОбщая<Откл> {}

	@FunctionalInterface abstract static
	interface
	Процедура1<Пар, Откл extends Throwable> extends Процедура1__<Пар, Откл, RemoteException>
	,
		ПроцедураОболочкиОбщая<Откл> {}

	@FunctionalInterface abstract static
	interface
	Процедура2<Пар1, Пар2, Откл extends Throwable> extends Процедура2__<Пар1, Пар2, Откл, RemoteException>
	,
		ПроцедураОболочкиОбщая<Откл> {}

	@FunctionalInterface abstract static
	interface
	Процедура3<Пар1, Пар2, Пар3, Откл extends Throwable> extends Процедура3__<Пар1, Пар2, Пар3, Откл, RemoteException>
	,
		ПроцедураОболочкиОбщая<Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор0<Рез, Откл extends Throwable> extends Функтор0__<Рез, Откл, RemoteException>
	,
		ФункцияОболочкиОбщая<Рез, Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор1<Рез, Пар, Откл extends Throwable> extends Функтор1__<Рез, Пар, Откл, RemoteException>
	,
		ФункцияОболочкиОбщая<Рез, Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор2<Рез, Пар1, Пар2, Откл extends Throwable> extends Функтор2__<Рез, Пар1, Пар2, Откл, RemoteException>
	,
		ФункцияОболочкиОбщая<Рез, Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор3<Рез, Пар1, Пар2, Пар3, Откл extends Throwable> extends Функтор3__<Рез, Пар1, Пар2, Пар3, Откл, RemoteException>
	,
		ФункцияОболочкиОбщая<Рез, Откл> {}

	@FunctionalInterface abstract static
	interface
	Функтор4<Рез, Пар1, Пар2, Пар3, Пар4, Откл extends Throwable> extends Функтор4__<Рез, Пар1, Пар2, Пар3, Пар4, Откл, RemoteException>
	,
		ФункцияОболочкиОбщая<Рез, Откл> {}

}
