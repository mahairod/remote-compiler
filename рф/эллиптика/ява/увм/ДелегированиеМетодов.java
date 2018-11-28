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

import java.io.Serializable;
import java.rmi.RemoteException;

import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;
import рф.эллиптика.ява.увм.компилятор.оболочки.ОболочкаТелеКласса;

/**
 *
 * @author Антон Астафьев
 */
public abstract class ДелегированиеМетодов extends МетодыДелегирования implements ОбъявлениеДелегирования, ШлюзовойКласс {
	protected final ШлюзовойКласс шлюз;

	protected ДелегированиеМетодов(ШлюзовойКласс шлюз){
		this.шлюз = шлюз;
	}

	@Подмени @Override
	public <ТипПрокси extends СопряжениеТелеМаркер, ТипОболочки extends СопряжениеТелеМаркер & ОболочкаТелеКласса<Object, ТипПрокси> > ТипПрокси внешнееПредставление(ТипОболочки оболочка) {
		return шлюз.внешнееПредставление(оболочка);
	}

	@Подмени @Override
	public <ТипПрокси extends СопряжениеТелеМаркер, ТипОболочки extends СопряжениеТелеМаркер & ОболочкаТелеКласса<Object, ТипПрокси> > ТипОболочки внутреннееПредставление(ТипПрокси сырой) {
		return шлюз.внутреннееПредставление(сырой);
	}

	@Подмени @Override
	public <Рез> Рез сообщиОбОшибке(RemoteException ex) {
		return шлюз.сообщиОбОшибке(ex);
	}

	@Подмени @Override
	public Object дайОснову() {
		return шлюз.дайОснову();
	}

	@Подмени @Override
	public Serializable замена(Object obj) {
		return шлюз.замена(obj);
	}

	@Подмени @Override
	public Object замена(Serializable obj) {
		return шлюз.замена(obj);
	}

	@Подмени @Override
	public ШлюзовойКласс дайШлюз() {
		return шлюз;
	}

}
