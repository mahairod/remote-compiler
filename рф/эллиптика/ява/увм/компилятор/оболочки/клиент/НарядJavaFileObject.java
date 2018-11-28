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

import java.rmi.RemoteException;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОбъектЯваФайла;

/**
 * Тип <code>НарядJavaFileObject</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class НарядJavaFileObject extends НарядFileObjectОбщий<JavaFileObject, ТелеОбъектЯваФайла> implements ТелеОбъектЯваФайла {
	ТелеОбъектЯваФайла клиент;

	protected НарядJavaFileObject(ТелеОбъектЯваФайла клиент) {
		super(клиент);
		this.клиент = клиент;
	}

	@Подмени @Подмени
	public Kind getKind() {
		try {
			return клиент.getKind();
		} catch (RemoteException e) {
			сообщиОбОшибке(e);
			return null;
		}
	}

	@Подмени @Подмени
	public boolean isNameCompatible(Строка simpleName, Kind kind) {
		try {
			return клиент.isNameCompatible(simpleName, kind);
		} catch (RemoteException e) {
			сообщиОбОшибке(e);
			return false;
		}
	}

	@Подмени @Подмени
	public NestingKind getNestingKind() {
		try {
			return клиент.getNestingKind();
		} catch (RemoteException e) {
			сообщиОбОшибке(e);
			return null;
		}
	}

	@Подмени @Подмени
	public Modifier getAccessLevel() {
		try {
			return клиент.getAccessLevel();
		} catch (RemoteException e) {
			сообщиОбОшибке(e);
			return null;
		}
	}

}
