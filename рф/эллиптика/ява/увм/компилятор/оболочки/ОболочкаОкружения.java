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

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Словарь;
import java.util.logging.Level;
import java.util.logging.Logger;

import рф.эллиптика.ява.увм.компилятор.вопл.КомпиляторЯваСериализуемый;
import рф.эллиптика.ява.увм.компилятор.вопл.Сериализуемый;
import рф.эллиптика.ява.увм.компилятор.маркеры.Field;
import рф.эллиптика.ява.увм.компилятор.маркеры.ЗаменаТипа;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОкружение;
import рф.эллиптика.ява.увм.компилятор.оболочки.клиент.КлиентскийГардероб;

import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.util.Context;

/**
 * Тип <code>ОболочкаОкружения</code> предназначен для
 * обёртывания класса удалённого доступа к Окружению компиляции
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ОболочкаОкружения extends Context implements ОболочкаТелеКласса<Context, ТелеОкружение>, ТелеОкружение {
	private final ТелеОкружение ядро;
	private final ДелегированиеОболочки об;

	ОболочкаОкружения(ТелеОкружение ядро) {
		this.ядро = ядро;
		this.об = делегатИсполнитель();
	}

	@Подмени
	public void clear() {
		об.телеВызов(ядро::clear);
	}

	@Подмени
	public void dump() {
		об.телеВызов(ядро::dump);
	}

	@Подмени
	public <T> T get(Key<T> key) {
		return об.телеФункция(ядро::get, key);
	}

	@Подмени
	public <T> void put(Key<T> key, Factory<T> fac) {
		об.телеВызов(ядро::put, key, fac);
	}

	@Подмени
	public <T> void put(Key<T> key, T data) {
		об.телеВызов(ядро::put, key, data);
	}

	public <T> T get(Class<T> clazz) {
		return об.телеФункция(ядро::get, clazz);
	}

	public <T> void put(Class<T> clazz, Factory<T> fac) {
		об.телеВызов(ядро::put, clazz, fac);
	}

	public <T> void put(Class<T> clazz, T data) {
		об.телеВызов(ядро::put, clazz, data);
	}

	public void согласуйСтатическиеКлючи(Словарь<? extends Context.Key<?>, Field> ключи) throws RemoteException {
		ядро.согласуйСтатическиеКлючи( статическиеКлючи );
	}

	@Подмени
	public ТелеОкружение дайОснову() {
		return ядро;
	}

	public Serializable замена(Object obj){
		if (obj instanceof Key){
			Key<?> key = (Key<?>)obj;
			if (ключи.дай(key)!=null){
				return ключи.дай(key);
			} else {
				return Ключ.экземпляр(key);
			}
		}
		if (false && obj instanceof JavaCompiler){
			JavaCompiler compiler = (JavaCompiler) obj;
			return new КомпиляторЯваСериализуемый(compiler, this);
		}
		return null;
	}

	public Object замена(Serializable obj){
		if (obj instanceof Ключ){
			return keys.дай((Ключ<?>)obj);
		}
		if (obj instanceof Сериализуемый){
			Сериализуемый серилаизуемый = (Сериализуемый) obj;
			return серилаизуемый.исходник();
		}
		return null;
	}

	static Словарь< Key<? extends Object>, Ключ<? extends Object> > ключи = new HashMap<>();
	static Словарь< Ключ<? extends Object>, Key<? extends Object> > keys  = new HashMap<>();

    public static interface Фабрика<T> extends Context.Factory<T>, Serializable {
        T make(Context c);
    };

	private static final Словарь<Ключ<?>, Field> статическиеКлючи = new HashMap<>();

	static {
		статическиеКлючи.клади( ключ(com.sun.tools.javac.util.JavacMessages.messagesKey), достаньПоле(com.sun.tools.javac.util.JavacMessages.class, "messagesKey") );
		статическиеКлючи.клади( ключ(com.sun.tools.javac.util.Log.logKey), достаньПоле(com.sun.tools.javac.util.Log.class, "logKey") );
		статическиеКлючи.клади( ключ(com.sun.tools.javac.util.Log.outKey), достаньПоле(com.sun.tools.javac.util.Log.class, "outKey") );
		статическиеКлючи.клади( ключ(com.sun.tools.javac.util.Options.optionsKey), достаньПоле(com.sun.tools.javac.util.Options.class, "optionsKey") );
		статическиеКлючи.клади( ключ(com.sun.tools.javac.util.Names.namesKey), достаньПоле(com.sun.tools.javac.util.Names.class, "namesKey") );

		статическиеКлючи.клади( ключ(ДоступККомпилятору.дайКлюч() ), 			достаньПоле(com.sun.tools.javac.main.JavaCompiler.class, "compilerKey") );
		статическиеКлючи.клади( ключ(ДоступКФабрикеДиагностики.дайКлюч()),		достаньПоле(com.sun.tools.javac.util.JCDiagnostic.Factory.class, "diagnosticFactoryKey") );
	}

	private static <T> Ключ<T> ключ(Key<T> key){
		return new Ключ<T>(key);
	}

	private static Field достаньПоле(Class<?> класс, Строка имя){
		return new Field(класс, имя.toCharArray());
	}

}

class ДоступКФабрикеДиагностики extends com.sun.tools.javac.util.JCDiagnostic.Factory {
	static Context.Key<com.sun.tools.javac.util.JCDiagnostic.Factory> дайКлюч(){
		return com.sun.tools.javac.util.JCDiagnostic.Factory.diagnosticFactoryKey;
	}
	protected ДоступКФабрикеДиагностики() {
		super(null);
	}
}

class ДоступККомпилятору extends com.sun.tools.javac.main.JavaCompiler {
	static Context.Key<com.sun.tools.javac.main.JavaCompiler> дайКлюч(){
		return com.sun.tools.javac.main.JavaCompiler.compilerKey;
	}
	public ДоступККомпилятору() {
		super(null);
	}
}

class Ключ<T> extends Context.Key<T> implements Serializable {
	private static final long serialVersionUID = 3229137784031531181L;
	
	Ключ(){
	}

	Ключ(Context.Key<T> key){
		this.hash = key.hashCode();
	}
	
	private int hash;

	@Подмени
	public int hashCode() {
		return hash;
	}

	@Подмени
	public boolean equals(Object obj) {
		if (obj!=null && obj instanceof Context.Key){
			return hash == obj.hashCode();
		} else return false;
	}

	protected static <T> Ключ<T> экземпляр(Context.Key<T> key){
		Ключ<T> ключ = new Ключ<T>(key);
		ОболочкаОкружения.ключи.клади(key, ключ);
		ОболочкаОкружения.keys.клади(ключ, key);
		return ключ;
	}
}
