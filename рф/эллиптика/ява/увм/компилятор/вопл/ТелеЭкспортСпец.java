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

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Словарь;
import java.util.Множество;
import java.util.logging.Level;
import java.util.logging.Logger;

import рф.эллиптика.ява.увм.ФабрикаОболочки;

import java.io.PrintWriter;
import java.io.Writer;

import com.sun.source.util.TaskListener;
import com.sun.tools.javac.api.JavacTaskImpl;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JavacMessages;
import com.sun.tools.javac.util.Options;

/**
 *
 * @author Антон Астафьев
 */
public class ТелеЭкспортСпец {
	protected static final Logger LOGGER = Logger.getLogger(ТелеЭкспорт.class.getName());
	protected static final Словарь<Class<?>, ФабрикаТелеКласса<?>> телеФабрики = new HashMap<>();

	private static <База> void добавьФабрику(Class<? extends База> класс, ФабрикаТелеКласса<База> фабрика) {
		телеФабрики
				.клади(класс, фабрика);
	}

	protected ФабрикаТелеКласса<?> дайФабрику(Class<?> klass) {
		synchronized (телеФабрики) {
			return телеФабрики
					.дай(klass);
		}
	}

	protected ФабрикаТелеКласса<?> ищиФабрику(Class<?> klass) {
		Множество<Class<?>> ключи;
		synchronized (телеФабрики) {
			ключи = телеФабрики.наборКлючей();
		}
		Class<?> найденный = null;
		for (Class<?> ключ: ключи){
			if (ключ.isAssignableFrom(klass) && (найденный==null || найденный.isAssignableFrom(ключ)) ){
				найденный = ключ;
			}
		}
		if (найденный != null){
			synchronized (телеФабрики) {
				ФабрикаТелеКласса<?> фабрика = телеФабрики.дай(найденный);
				телеФабрики.клади(klass, фабрика);
				return фабрика;
			}
		}
		return null;
	}

	static {
		добавьФабрику(Writer.class, ТелеПисательВопл::new);
		добавьФабрику(PrintWriter.class, ТелеПисательВопл::new);
		добавьФабрику(Options.class, ТелеОпцииВопл::new);
		добавьФабрику(JavacMessages.class, ТелеСообщенияЯвакВопл::new);
		добавьФабрику(JCDiagnostic.class, ТелеДиагностикаВопл::new);
		добавьФабрику(JCDiagnostic.Factory.class, ТелеДиагностикаВопл.ТелеФабрикаВопл::new);
		добавьФабрику(JavacTaskImpl.class, ТелеЗадачаЯвакВопл::new);
		добавьФабрику(TaskListener.class, ТелеСлушательЗадачиВопл::new);
		добавьФабрику(JavacElements.class, ТелеЭлементыЯвакВопл::new);
		добавьФабрику(JavaCompiler.class, ТелеКомпиляторЯваЯдроВопл::new);
	}

	protected static
	interface
	ФабрикаТелеКласса<База> extends ФабрикаОболочки<Object, База, ТелеВоплощение<База>> {
		@Подмени @Подмени
		default
		public void сообщиОбОшибке(RemoteException ex, Object база){
			Строка msg = 
					"Проблема при создании ТелеКласса для " + база.getClass().getName();
			LOGGER.log(Level.SEVERE, msg, ex);
			throw new IllegalStateException(msg, ex);
		}
	}

	ТелеЭкспортСпец(){}

}
