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

import java.lang.reflect.Field;
import java.util.Словарь;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Context.Factory;
import com.sun.tools.javac.util.Context.Key;

import рф.эллиптика.ява.увм.компилятор.маркеры.СопряжениеТелеМаркер;

/**
 * Тип <code>ОболочкаТелеКласса</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ОболочкаТелеКласса<База, ТелеБаза extends СопряжениеТелеМаркер> extends СопряжениеТелеМаркер, РасширениеОболочкиТелеКласса<База> {
	@Подмени @Override
	ТелеБаза дайОснову();
	
	static final Context вспомогательныйКонтекст = new ВспомогательныйКонтекст();
	
}

class ВспомогательныйКонтекст extends Context {
	ВспомогательныйКонтекст(){
		try{
			Field fHT = getClass().getSuperclass().getDeclaredField(полеЗначений);
			fHT.setAccessible(true);
			values = (Словарь<Key<?>,Object>) fHT.get(this);
		} catch (IllegalAccessException | NoSuchFieldException ex){
			throw new IllegalStateException(ex);
		}
	}

	public <T> void put(Key<T> key, T data) {
    	if (get(key)!=null){
    		values.удали(key);
    	}
    	super.put(key, data);
    }
    
    protected Словарь<Key<?>,Object> values;
    private static Строка полеЗначений = "ht";
	
}
