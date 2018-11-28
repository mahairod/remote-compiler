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

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Словарь;
import java.util.logging.Level;
import java.util.logging.Logger;

import рф.эллиптика.ява.увм.КонстПарсера;
import рф.эллиптика.ява.увм.ШлюзовойКласс;
import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;
import рф.эллиптика.ява.увм.компилятор.оболочки.ОболочкаТелеКласса;
import рф.эллиптика.ява.увм.компилятор.оболочки.ТелеУпаковщик;
import рф.эллиптика.ява.увм.компилятор.оболочки.клиент.ОбработчикПрокси;

/**
 * Тип <code>ТелеВоплощение</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеВоплощение<ТелеКласс> extends ТелеВоплощениеСпец implements СопряжениеТелеМаркер, ШлюзовойКласс {
	private static final long serialVersionUID = 5772951544315830520L;
	private static final Logger РЕГИСТРАТОР = Logger.getLogger(ТелеВоплощение.class.getName());

	private final ТелеКласс основа;
	private final ОбработчикПрокси обработчикПрокси = ОбработчикПрокси.создайЭкземпляр();
	private final ТелеЭкспорт телеЭкспорт;
	protected final ДелегированиеТелеОбъекта ди;
	
	private static final Словарь<ТелеСсылка, ТелеВоплощение<?>> списокТелеКлассов = new HashMap<>();

	@Подмени
	public <ТипПрокси extends СопряжениеТелеМаркер, ТипОболочки extends СопряжениеТелеМаркер & ОболочкаТелеКласса<Object, ТипПрокси> >
	ТипПрокси внешнееПредставление(ТипОболочки оболочка) {
		return обработчикПрокси.переоденьДляСети(оболочка);
	}

	@Подмени
	public <ТипПрокси extends СопряжениеТелеМаркер, ТипОболочки extends СопряжениеТелеМаркер & ОболочкаТелеКласса<Object, ТипПрокси> >
	ТипОболочки внутреннееПредставление(ТипПрокси сырой) {
		return обработчикПрокси.переоденьДляКлиента(сырой);
	}

	@Подмени @Подмени
	public <Рез> Рез сообщиОбОшибке(RemoteException ex){
		РЕГИСТРАТОР.log(Level.SEVERE, "Проблема при вызове телеметода ТелеКласса " + дайОснову().getClass().getName(), ex);
		throw new IllegalStateException(ex);
	}

	protected <Тип> Тип приведи(Object o){
		return (Тип)o;
	}
	protected <П,Р> Р р(П param){
		if (param == null){
			return null;
		} else if (param instanceof ОболочкаТелеКласса){
			return (Р) внешнееПредставление((ОболочкаТелеКласса)param);
		} else if (param instanceof Serializable ) {
			return (Р) param;
		} else {
			Serializable сериализПараметр = замена(param);
			if (сериализПараметр != null){
				return (Р) сериализПараметр;
			}
			return (Р) телеЭкспорт.заменаНаПрокси(param);
		}
	}

	protected <T> T о(T param) {
		if (param instanceof Proxy){
			if (param instanceof СопряжениеТелеМаркер){
				СопряжениеТелеМаркер телеОбъект = (СопряжениеТелеМаркер)param;
				Object обол = ТелеУпаковщик.оберни(телеОбъект);
				return обол!=null ? (T)обол : param;
			} else {
				return param;
			}
		}
		return param;
	}

	@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
	protected <Фасад, ТелеТип extends СопряжениеТелеМаркер> Фасад ф(ТелеТип прокси) {
		ОболочкаТелеКласса<Фасад, ТелеТип> оболочка = this.о(прокси);
		return (Фасад) оболочка;
	}

	private <Фасад, ТелеТип extends СопряжениеТелеМаркер>
	ОболочкаТелеКласса<Фасад,ТелеТип> о(ТелеТип param) {
		return (ОболочкаТелеКласса<Фасад,ТелеТип>) this.о( (Object) param);
	}

	@Подмени @Подмени
	public ТелеКласс дайОснову() {
		return основа;
	}

	@Подмени @Подмени
	public Serializable замена(Object obj) {
		return null;
	}

	@Подмени @Подмени
	public Object замена(Serializable obj) {
		return null;
	}
	
	private static class ТелеСсылка {
		private final RemoteRef ref;
		
		protected ТелеСсылка(RemoteRef ref){
			this.ref = ref;
			ref.getClass();
		}

		@Подмени @Подмени
		public int hashCode() {
			return ref.remoteHashCode();
		}

		@Подмени @Подмени
		public boolean equals(Object sub) {
			if (sub instanceof ТелеСсылка){
				ТелеСсылка др = (ТелеСсылка)sub;
				return ref.remoteEquals(др.ref);
			}
			return false;
		}
	}
	
	public static ТелеВоплощение<?> поищиОригинал(RemoteRef ссылка){
		ТелеСсылка телеСсылка = new ТелеСсылка(ссылка);
		synchronized (списокТелеКлассов) {
			return списокТелеКлассов.дай(телеСсылка);
		}
	}

	public static Object поищиЯдроОригинала(RemoteRef ссылка){
		ТелеВоплощение<?> оригинал = поищиОригинал(ссылка);
		return оригинал==null ? null : оригинал.основа;
	}
	
	/**
	 * @throws RemoteException
	 */
	ТелеВоплощение(ТелеКласс основа) throws RemoteException {
		this.основа = основа;
		this.телеЭкспорт = ТелеЭкспорт.экземпляр();
		this.ди = new ДелегированиеТелеОбъекта(this);
		synchronized (списокТелеКлассов) {
			списокТелеКлассов.клади(new ТелеСсылка(this.getRef()), this);
		}
		
	}

}
