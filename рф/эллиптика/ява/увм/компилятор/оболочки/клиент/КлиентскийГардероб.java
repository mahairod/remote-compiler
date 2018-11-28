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
package рф.эллиптика.ява.увм.компилятор.оболочки.клиент;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Словарь;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.DiagnosticListener;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

import sun.security.util.SecurityConstants;
import рф.эллиптика.ява.увм.ИнструментыПрокси;
import рф.эллиптика.ява.увм.КонстПарсера;
import рф.эллиптика.ява.увм.ФабрикаОболочки;
import рф.эллиптика.ява.увм.ШлюзовойКласс;
import рф.эллиптика.ява.увм.компилятор.вопл.ТелеВоплощение;
import рф.эллиптика.ява.увм.компилятор.маркеры.*;
import рф.эллиптика.ява.увм.компилятор.оболочки.ОболочкаТелеКласса;
import рф.эллиптика.ява.увм.компилятор.оболочки.Оболочки;
import рф.эллиптика.ява.увм.компилятор.оболочки.ТелеУпаковщик;
import рф.эллиптика.ява.увм.компилятор.оболочки.Оболочки.ФабрикаКлиентскойОболочки;

import com.sun.source.util.TaskListener;
import com.sun.tools.javac.api.ClientCodeWrapper;
import com.sun.tools.javac.api.ClientCodeWrapper.WrappedClientCode;
import com.sun.tools.javac.util.Context;

/**
 * Тип <code>КлиентскийГардероб</code> предназначен для
 * оборачивания клиентского кода, в данном случае удалённого,
 * перед передачей его в работу компилятору.
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class КлиентскийГардероб {
	private static final Logger LOGGER = Logger.getLogger(КлиентскийГардероб.class.getName());

	final ClientCodeWrapper ccw;

	public КлиентскийГардероб() {
		ccw = ClientCodeWrapper.instance(new Context());
	}

	@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
	private <ЛокальныйТип, ТипПрокси extends СопряжениеТелеМаркер, ЛокОболочка extends WrappedClientCode<ЛокальныйТип>, ТелеОболочка extends СопряжениеТелеМаркер & ОболочкаТелеКласса<ЛокальныйТип, ТипПрокси>>
	ТелеОболочка unwrapSafely(Class<WrappedClientCode<ЛокальныйТип>> klass, ЛокОболочка значение){
		Строка строкаТипа = klass.getSimpleName().substring("Wrapped".length());
		Строка имяПоля = "client" + строкаТипа;
			
		try{
			Field поле = klass.getDeclaredField(имяПоля);
			поле.setAccessible(true);
			return (ТелеОболочка) поле.get(значение);
		} catch ( NoSuchFieldException | IllegalAccessException ex){
			Строка msg = "Проблема при развёртывании клиентского кода класса " + klass.toString();
			LOGGER.log(Level.SEVERE, msg, ex);
			throw new IllegalStateException(msg, ex);
		}
		
	}

	public interface ДополнительноеДействие<ЛокТип, Тип extends СопряжениеТелеМаркер> {
		Тип выполни(ОболочкаТелеКласса<ЛокТип, Тип> значение);
	}
	
	public <ЛокальныйТип, ТипПрокси extends СопряжениеТелеМаркер, ТипОболочки extends СопряжениеТелеМаркер & ОболочкаТелеКласса<ЛокальныйТип, ТипПрокси>>
	ТипПрокси переоденьДляСети(WrappedClientCode<ЛокальныйТип> значение, ДополнительноеДействие<ЛокальныйТип, ТипПрокси> дополнительноеДействие){
		Class<WrappedClientCode<ЛокальныйТип>> valueClass = (Class<WrappedClientCode<ЛокальныйТип>>) значение.getClass();

		final ТипПрокси внешнийТип;
		{
			ТипОболочки ядро = this.<ЛокальныйТип, ТипПрокси, WrappedClientCode<ЛокальныйТип>, ТипОболочки>unwrapSafely(valueClass, значение);
			if (дополнительноеДействие != null){
				внешнийТип = дополнительноеДействие.выполни(ядро);
			} else {
				внешнийТип = (ТипПрокси) ядро;
			}
		}

		Class<? extends СопряжениеТелеМаркер> klass = ИнструментыПрокси.поискГлавногоСопряжения(внешнийТип);
		synchronized (фабрикиНарядов) {
			if (фабрикиНарядов.содержитКлюч(klass)){
				Наряженный<? extends СопряжениеТелеМаркер> наряд = фабрикиНарядов.дай(klass).создай(внешнийТип);
				return (ТипПрокси) наряд;
			} else {
				return (ТипПрокси) значение;
			}
		}
	}

// ======= Фабрики нарядов ==================

	private static final Словарь<Class<? extends СопряжениеТелеМаркер>, ФабрикаНаряда<? extends СопряжениеТелеМаркер> > фабрикиНарядов = new HashMap<>();

	private static <Ядро extends СопряжениеТелеМаркер>
	void добавьФабрику(Class<Ядро> классЯдра, ФабрикаНаряда<Ядро> фабрика){
		фабрикиНарядов.клади(классЯдра, фабрика);
	}

	static {
		Class<ТелеДиагностирующийСлушатель<Object>> cl = (Class<ТелеДиагностирующийСлушатель<Object>>) (Class<?>) ТелеДиагностирующийСлушатель.class;
		добавьФабрику(cl,								НарядDiagnosticListener<Object>::new	);
		добавьФабрику(ТелеРаспорядительФайлов.class,		НарядJavaFileManager::new		);
		добавьФабрику(ТелеОбъектФайла.class,				НарядFileObject::new		);
		добавьФабрику(ТелеОбъектЯваФайла.class,			НарядJavaFileObject::new		);
		добавьФабрику(ТелеСлушательЗадачи.class,		НарядTaskListener::new		);
	}

	private static interface ФабрикаНаряда<Ядро extends СопряжениеТелеМаркер> extends ФабрикаОболочки<СопряжениеТелеМаркер, Ядро, Наряженный<Ядро>> {
		@Подмени
		default void сообщиОбОшибке(RemoteException ex, СопряжениеТелеМаркер база){
			LOGGER.log(Level.SEVERE, "Проблема при создании Наряда для " + база.getClass().getName() , ex);
			throw new IllegalStateException(ex);
		}
	}
/*	
	protected enum WrapperId {
		WrappedFileObject, WrappedJavaFileObject, WrappedJavaFileManager, WrappedTaskListener,
		WrappedDiagnosticListener
	}

	private final static Словарь<Строка, Integer> wrapperSelectors = initselectors();

	private final static Словарь<Строка, Integer> initselectors() {
		Словарь<Строка, Integer> selectors = new HashMap<Строка, Integer>(WrapperId.values().length);
		for (WrapperId wrapperId : WrapperId.values()) {
			selectors.клади(wrapperId.name(), wrapperId.ordinal());
		}
		return selectors;
	}

	protected WrapperId selector(Строка value) {
		if (wrapperSelectors.содержитКлюч(value)) {
			return WrapperId.values()[wrapperSelectors.дай(value).intValue()];
		} else {
			return null;
		}
	}
*/
}
