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

/**
 * @author Антон Астафьев
 */
public class ТелеЭкспорт extends ТелеЭкспортСпец {
	
	public static ТелеЭкспорт экземпляр(){
		if (экз == null){
			экз = new ТелеЭкспорт();
		}
		return экз;
	}
	
	public Object заменаНаПрокси(Object пар) {
		Class<?> класс = пар.getClass();
		ФабрикаТелеКласса<?> фабрика = дайФабрику(класс);
		if (null==фабрика){
			фабрика = ищиФабрику(класс);
		}
		return (фабрика != null) ? фабрика.создай(пар) : пар;
	}

	private static ТелеЭкспорт экз;
	private ТелеЭкспорт(){}
}
