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
package рф.эллиптика.ява.увм.компилятор.оболочки;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Словарь;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileManager;

import рф.эллиптика.ява.увм.ФабрикаОболочки;
import рф.эллиптика.ява.увм.ШлюзовойКласс;
import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеДиагностирующийСлушатель;

import com.sun.tools.javac.api.ClientCodeWrapper;
import com.sun.tools.javac.api.ClientCodeWrapper.WrappedClientCode;
import com.sun.tools.javac.util.Context;

/**
 * Тип <code>Оболочки</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public final class Оболочки {

	public static <ТелеБаза extends СопряжениеТелеМаркер> ФабрикаКлиентскойОболочки<?, ? extends СопряжениеТелеМаркер>
	дайФабрику(Class<?> klass){
		synchronized (фабрикиКлиентскихОболочек) {
			return фабрикиКлиентскихОболочек.дай(klass);
		}
	}

	private Оболочки(){}
	private static final Logger LOGGER = Logger.getLogger(Оболочки.class.getName());

	private static final Словарь<Class<?>, ФабрикаКлиентскойОболочки<?, ? extends СопряжениеТелеМаркер> > фабрикиКлиентскихОболочек = new HashMap<>();

	public static interface ФабрикаКлиентскойОболочки<База, ТелеБаза extends СопряжениеТелеМаркер>
				extends ФабрикаОболочки<СопряжениеТелеМаркер, ТелеБаза,  База > {
		@Подмени
		default void сообщиОбОшибке(RemoteException ex, СопряжениеТелеМаркер база){
			LOGGER.log(Level.SEVERE, "Проблема при создании клиентской оболочки для класса " + база.getClass().getName() , ex);
			throw new IllegalStateException(ex);
		}
	}

	private static <База, ТелеБаза extends СопряжениеТелеМаркер>
	void добавьФабрику(Class<? extends ОболочкаТелеКласса<База, ? extends СопряжениеТелеМаркер>> классЯдра, ФабрикаКлиентскойОболочки<База, ТелеБаза> фабрика){
		фабрикиКлиентскихОболочек.клади(классЯдра, фабрика);
	}
	
	static {
//		Оболочки.<Context, ОболочкаОкружения> добавьФабрику(ОболочкаОкружения.class,		ClientCodeWrapper::wrap		);

		ClientCodeWrapper ccw = ClientCodeWrapper.instance(new Context());

		Оболочки.<DiagnosticListener<Object>, ОболочкаДиагностирующегоСлушателя<Object>>
		добавьФабрику(cast(ОболочкаДиагностирующегоСлушателя.class),	ccw::wrap	);
		Оболочки.<JavaFileManager, ОболочкаРаспорядителяФайлов>
		добавьФабрику(ОболочкаРаспорядителяФайлов.class,				ccw::wrap		);
	}
	
	private static <Тип> Class<Тип> cast(Class<?> c){
		return (Class<Тип>) c;
	}

}
