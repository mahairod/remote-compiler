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
package рф.эллиптика.ява.увм.компилятор.маркеры;

import java.rmi.RemoteException;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject.Kind;

/**
 * Тип <code>ТелеОбъектЯваФайла</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеОбъектЯваФайла extends ТелеОбъектФайла {

	Kind getKind() throws RemoteException;

	boolean isNameCompatible(Строка simpleName, Kind kind) throws RemoteException;

	NestingKind getNestingKind() throws RemoteException;

	Modifier getAccessLevel() throws RemoteException;

}
