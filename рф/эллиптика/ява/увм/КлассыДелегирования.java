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

/**
 *
 * @author Антон Астафьев
 */
public class КлассыДелегирования {

	// ========== Классы делегатов ==========

	private abstract static
	interface
	ПроцедураОбщая<Откл extends Throwable, ОбщОткл extends Throwable>
	extends
	ДелегатОбщий<Void,Откл,ОбщОткл> {
		default
		@Подмени @Подмени
		Void общийВызов(Object[] п) throws ОбщОткл, Откл {
			процедура(п); return null;
		}
		abstract void процедура(Object[] п) throws ОбщОткл, Откл;
	}

	private abstract static
	interface
	ФункцияОбщая<Рез, Откл extends Throwable, ОбщОткл extends Throwable>
	extends
	ДелегатОбщий<Рез,Откл,ОбщОткл> {
	}

	@FunctionalInterface abstract static public
	interface
	Процедура0__<Откл extends Throwable, ОбщОткл extends Throwable> extends ПроцедураОбщая<Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		void процедура(Object[] п) throws ОбщОткл, Откл {
			вызов();
		}
		public abstract void вызов() throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Процедура1__<Пар0, Откл extends Throwable, ОбщОткл extends Throwable> extends ПроцедураОбщая<Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		void процедура(Object[] п) throws ОбщОткл, Откл {
			вызов((Пар0)п[0]);
		}
		public abstract void вызов(Пар0 парам0) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Процедура2__<Пар0, Пар1, Откл extends Throwable, ОбщОткл extends Throwable> extends ПроцедураОбщая<Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		void процедура(Object[] п) throws ОбщОткл, Откл {
			вызов((Пар0)п[0],(Пар1)п[1]);
		}
		public abstract void вызов(Пар0 парам0, Пар1 парам1) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Процедура3__<Пар0, Пар1, Пар2, Откл extends Throwable, ОбщОткл extends Throwable> extends ПроцедураОбщая<Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		void процедура(Object[] п) throws ОбщОткл, Откл {
			вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2]);
		}
		public abstract void вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Процедура4__<Пар0, Пар1, Пар2, Пар3, Откл extends Throwable, ОбщОткл extends Throwable> extends ПроцедураОбщая<Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		void процедура(Object[] п) throws ОбщОткл, Откл {
			вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2], (Пар3)п[3]);
		}
		public abstract void вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2, Пар3 парам3) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор0__<Рез, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов();
		}
		public abstract Рез вызов() throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор1__<Рез, Пар0, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0]);
		}
		public abstract Рез вызов(Пар0 пар) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор2__<Рез, Пар0, Пар1, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0],(Пар1)п[1]);
		}
		public abstract Рез вызов(Пар0 парам0, Пар1 парам1) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор3__<Рез, Пар0, Пар1, Пар2, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2]);
		}
		public abstract Рез вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор4__<Рез, Пар0, Пар1, Пар2, Пар3, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2],(Пар3)п[3]);
		}
		public abstract Рез вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2, Пар3 парам3) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор5__<Рез, Пар0, Пар1, Пар2, Пар3, Пар4, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2],(Пар3)п[3],(Пар4)п[4]);
		}
		public abstract Рез вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2, Пар3 парам3, Пар4 парам4) throws ОбщОткл, Откл;
	}

	@FunctionalInterface abstract static public
	interface
	Функтор7__<Рез, Пар0, Пар1, Пар2, Пар3, Пар4, Пар5, Пар6, Откл extends Throwable, ОбщОткл extends Throwable> extends ФункцияОбщая<Рез, Откл, ОбщОткл> {
		default
		@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
		@Подмени @Подмени
		Рез общийВызов(Object[] п) throws ОбщОткл, Откл {
			return вызов((Пар0)п[0],(Пар1)п[1],(Пар2)п[2],(Пар3)п[3],(Пар4)п[4],(Пар5)п[5],(Пар6)п[6]);
		}
		public abstract Рез вызов(Пар0 парам0, Пар1 парам1, Пар2 парам2, Пар3 парам3, Пар4 парам4, Пар5 парам5, Пар6 парам6) throws ОбщОткл, Откл;
	}

}
