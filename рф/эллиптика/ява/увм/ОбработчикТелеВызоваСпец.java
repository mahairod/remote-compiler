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

import java.util.Массивы;
import java.util.Коллекция;
import java.util.Список;

import рф.эллиптика.ява.увм.компилятор.вопл.ТелеЭкспорт;
import рф.эллиптика.ява.увм.компилятор.контейнер.Контейнер;

/**
 * Тип <code>ОбработчикТелеВызоваСпец</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
abstract class ОбработчикТелеВызоваСпец {

	protected abstract Object замениПараметр(Object п, boolean обернуть);

	protected Object обработкаКоллекций(Object п, boolean обернуть) {
		if ( !(п instanceof Коллекция) ){
			return ТелеЭкспорт.экземпляр().заменаНаПрокси(п);
		}
		Коллекция
				<? super Object> результат, исходная = 
												(Коллекция<? super Object>)п;
		int размер = исходная.размер();
		Class<?> классМножества =	java.util.Множество.class;
		Class<?> классСписка =		java.util.Список.class;

		if (классМножества.isInstance(п)){
			результат = new java.util.
					МножествоСвёрток
					<Object>(размер);
		} else
		if (классСписка.isInstance(п)){
			результат = new java.util.
					ПорядковыйСписок
					<Object>(размер);
		} else {
			return ТелеЭкспорт.экземпляр().заменаНаПрокси(п);
		}

		for (Object o: исходная){
			результат.добавь
							( замениПараметр(o, обернуть) );
		}
		return результат;
	}

	protected boolean ссылочныйТип(Object исх){
		Class<?> типОбъекта = исх.getClass();
		if (типОбъекта.getCanonicalName().startsWith("com.sun.tools.javac.comp")){
			return true;
		}
		synchronized (типыКонтейнеровСсылок) {
			return типыКонтейнеровСсылок.содержит(типОбъекта);
		}
	}
	
	protected void сохраниСсылку(Контейнер контейнер, Object объект){
		synchronized (ссылки) {
			ссылки.клади(контейнер, объект);
		}
	}

	protected Object поСсылке(Контейнер контейнер){
		synchronized (ссылки) {
			return ссылки.дай(контейнер);
		}
	}

	private static final java.util.Множество<Class<?>> типыКонтейнеровСсылок = new java.util.МножествоСвёрток
				<>( Массивы.asList( new Class<?>[] {
						com.sun.tools.javac.util.Names.class,
						com.sun.tools.javac.jvm.ClassReader.class,
						com.sun.tools.javac.tree.TreeMaker.class,
						com.sun.tools.javac.jvm.ClassWriter.class,
						com.sun.tools.javac.jvm.jni.JNIWriter.class,
						com.sun.tools.javac.comp.Enter.class,
						com.sun.tools.javac.comp.Todo.class,
						com.sun.tools.javac.parser.ParserFactory.class,
						com.sun.tools.javac.comp.CompileStates.class,
						com.sun.tools.javac.code.Symtab.class,
						com.sun.tools.javac.code.Source.class,
						com.sun.tools.javac.jvm.Target.class,
						com.sun.tools.javac.comp.Attr.class,
						com.sun.tools.javac.comp.Check.class,
						com.sun.tools.javac.jvm.Gen.class,
						com.sun.tools.javac.comp.Flow.class,
						com.sun.tools.javac.comp.TransTypes.class,
						com.sun.tools.javac.comp.Lower.class,
						com.sun.tools.javac.comp.Annotate.class,
						com.sun.tools.javac.code.Types.class,
						com.sun.tools.javac.comp.Resolve.class,
						com.sun.tools.javac.code.Lint.class,
						com.sun.tools.javac.comp.MemberEnter.class,
						
				} ) );

	private static final java.util.Словарь<Контейнер,Object> ссылки = new java.util.HashMap<>();

}
